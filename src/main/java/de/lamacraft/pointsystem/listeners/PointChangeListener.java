package de.lamacraft.pointsystem.listeners;

import de.lamacraft.pointsystem.Events.PointChangeEvent;
import de.lamacraft.pointsystem.api.PointsAPI;
import de.lamacraft.pointsystem.commands.ResetWinnerCommand;
import de.lamacraft.pointsystem.main.Main;
import de.lamacraft.pointsystem.utils.DiscordWebhook;
import de.lamacraft.pointsystem.utils.managers.FileManager;
import de.lamacraft.pointsystem.utils.managers.HologramManager;
import de.lamacraft.pointsystem.utils.managers.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;
import java.util.Objects;

public class PointChangeListener implements Listener {

    FileConfiguration cfg = FileManager.getConfigFileConfiguration();

    @EventHandler
    public void onPointChange(PointChangeEvent e) {
        Player p = e.getPlayer();

        ScoreboardManager.updateScoreboard(p);

        HologramManager.despawnAllHolos(Bukkit.getWorld("world"));
        HologramManager.spawnHolos();

        if (PointsAPI.getPoints(p.getUniqueId()) >= 1000000) {
            if (Objects.requireNonNull(cfg.getString("winner")).equalsIgnoreCase("")) {
                cfg.set("winner", p.getName());
                try {
                    cfg.save(FileManager.getConfigFile());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                for (Player players : Bukkit.getOnlinePlayers()) {
                    if (!(players == p)) {
                        players.kickPlayer("§1Es gibt einen Sieger des Projektes!\n" +
                                "§3Bitte melde dich bei Lama_Agent!");
                    } else {
                        p.sendMessage("§bDu hast das Projekt gewonnen!");
                        new BukkitRunnable() {
                            int i = 0;

                            @Override
                            public void run() {
                                if (!(i >= 15)) {
                                    if (p.isOnline()) {
                                        Firework firework = players.getWorld().spawn(players.getLocation(), Firework.class);
                                        FireworkMeta data = firework.getFireworkMeta();
                                        data.addEffect(FireworkEffect.builder().
                                                withColor(Color.ORANGE).
                                                withColor(Color.AQUA).
                                                with(FireworkEffect.Type.BALL_LARGE).
                                                withFlicker().
                                                withFade(Color.RED).
                                                withTrail().
                                                build()
                                        );
                                        data.setPower(1);
                                        firework.setFireworkMeta(data);
                                        i++;
                                    } else
                                        cancel();
                                } else {
                                    cancel();
                                }
                            }
                        }.runTaskTimer(Main.getInstance(), 0L, 20L);

                        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> players.kickPlayer("§4Du hast das Projekt gewonnen!\n" +
                                "§5Bitte melde dich bei Lama_Agent!"), 300L);
                    }
                }
                new BukkitRunnable() {
                    int i = 0;

                    @Override
                    public void run() {
                        if (!(i >= 5)) {
                            DiscordWebhook webhook = new DiscordWebhook(Main.getInstance().webhook_url);
                            webhook.addEmbed(new DiscordWebhook.EmbedObject()
                                    .setDescription("Der Gewinner ist **" + p.getName() + "** !")
                                    .setColor(new java.awt.Color(255, 215, 0))
                                    .setAuthor("SERVER", "", "https://i.ibb.co/Dw1CHgT/server-icon.png"));
                            try {
                                webhook.execute();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            i++;
                        } else
                            cancel();
                    }
                }.runTaskTimerAsynchronously(Main.getInstance(), 0, 20L);
                ResetWinnerCommand.cfg = FileManager.getConfigFileConfiguration();
            }
        }
    }

}
