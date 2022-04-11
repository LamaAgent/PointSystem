package de.lamacraft.pointsystem.listeners;

import de.lamacraft.pointsystem.Events.PointChangeEvent;
import de.lamacraft.pointsystem.utils.ScoreboardManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PointChangeListener implements Listener {

    @EventHandler
    public void onPointChange(PointChangeEvent e) {
        Player p = e.getPlayer();

        ScoreboardManager.updateScoreboard(p);
    }

}
