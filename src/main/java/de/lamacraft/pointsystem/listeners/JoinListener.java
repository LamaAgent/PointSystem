package de.lamacraft.pointsystem.listeners;

import de.lamacraft.pointsystem.api.PointsAPI;
import de.lamacraft.pointsystem.mysql.MySQL;
import de.lamacraft.pointsystem.utils.managers.ScoreboardManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();

        if (PointsAPI.getPoints(p.getUniqueId()) == -1) {
            try {
                final PreparedStatement ps = MySQL.con.prepareStatement("INSERT INTO points(playername, uuid, value) VALUES (?, ?, ?)");
                ps.setString(1, p.getName());
                ps.setString(2, p.getUniqueId().toString());
                ps.setInt(3, 0);
                ps.executeUpdate();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }

        ScoreboardManager.updateScoreboard(p);

    }

}
