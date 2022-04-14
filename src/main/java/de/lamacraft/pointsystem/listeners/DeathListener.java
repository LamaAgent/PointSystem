package de.lamacraft.pointsystem.listeners;

import de.lamacraft.pointsystem.api.PointsAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.HashMap;

public class DeathListener implements Listener {

    public static HashMap<Player, Integer> kills = new HashMap<>();

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player killer = e.getEntity().getKiller();
        if (killer != null) {
            if (kills.containsKey(killer)) {
                if (kills.get(killer) < 5) {
                    kills.put(killer, kills.get(killer) + 1);
                    PointsAPI.addPoints(killer.getUniqueId(), 100, null);
                    killer.sendMessage("§aDu hast §6100 Punkte §afür den Kill an §4" + e.getEntity().getName() + " §abekommen!");
                } else
                    killer.sendMessage("§cDu bekommst keine Punkte mehr in dieser Stunde für Player Kills!");
            } else {
                kills.put(killer, 1);
                PointsAPI.addPoints(killer.getUniqueId(), 100, null);
                killer.sendMessage("§aDu hast §6100 Punkte §afür den Kill an §4" + e.getEntity().getName() + " §abekommen!");
            }
        }
    }

}
