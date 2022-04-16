package de.lamacraft.pointsystem.listeners;

import de.lamacraft.pointsystem.Events.PointChangeEvent;
import de.lamacraft.pointsystem.api.PointsAPI;
import de.lamacraft.pointsystem.main.Main;
import de.lamacraft.pointsystem.utils.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class PointChangeListener implements Listener {

    @EventHandler
    public void onPointChange(PointChangeEvent e) {
        Player p = e.getPlayer();

        ScoreboardManager.updateScoreboard(p);

        if (PointsAPI.getPoints(p.getUniqueId()) >= 1000000) {
            for (Player players : Bukkit.getOnlinePlayers()) {
//                if(!players.hasPermission("lamacraft.win_success")) {
                if (!(players == p)) {
                    players.kickPlayer("§1Es gibt einen Sieger des Projektes!\n" +
                            "§3Bitte melde dich bei Lama_Agent!");
                } else {
                    p.sendMessage("§bDu hast das Projekt gewonnen!");
                    new BukkitRunnable() {
                        int i = 0;

                        @Override
                        public void run() {
                            if (!(i >= 10)) {
                                Firework firework = players.getWorld().spawn(players.getLocation(), Firework.class);
                                FireworkMeta data = firework.getFireworkMeta();
                                data.addEffect(FireworkEffect.builder().
                                        withColor(Color.ORANGE).
                                        withColor(Color.AQUA).
                                        with(FireworkEffect.Type.BALL_LARGE).
                                        withFlicker().
                                        build()
                                );
                                data.setPower(1);
                                firework.setFireworkMeta(data);
                                i++;
                            } else {
                                cancel();
                            }
                        }
                    }.runTaskTimer(Main.getInstance(), 0L, 20L);

                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> players.kickPlayer("§4Du hast das Projekt gewonnen!\n" +
                            "§5Bitte melde dich bei Lama_Agent!"), 300L);

                }
//                }
            }
        }
    }

}
