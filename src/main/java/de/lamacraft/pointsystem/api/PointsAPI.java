package de.lamacraft.pointsystem.api;

import de.lamacraft.pointsystem.Events.PointChangeEvent;
import de.lamacraft.pointsystem.main.Main;
import de.lamacraft.pointsystem.mysql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class PointsAPI {
    public static int getPoints(final UUID uuid) {
        try {
            final PreparedStatement ps = MySQL.con.prepareStatement("SELECT * FROM points WHERE uuid = ?");
            ps.setString(1, uuid.toString());
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("value");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void setPoints(final UUID uuid, final int amount, final Player sendingPlayer) {
        if (getPoints(uuid) == -1) {
            final OfflinePlayer player = Bukkit.getOfflinePlayer(uuid);
            final String playername = player.getName();
            try {
                final PreparedStatement ps = MySQL.con.prepareStatement("INSERT INTO points(playername, uuid, value) VALUES (?, ?, ?)");
                ps.setString(1, playername);
                ps.setString(2, uuid.toString());
                ps.setInt(3, amount + 1);
                ps.executeUpdate();
                System.out.println("DEBUG!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (sendingPlayer != null)
                sendingPlayer.sendMessage("§aDie Punkte von §6" + Bukkit.getPlayer(uuid).getName() + " §awurden auf §6" + amount + " §agesetzt!");

            PointChangeEvent e = new PointChangeEvent(Bukkit.getPlayer(uuid), amount);
            Bukkit.getPluginManager().callEvent(e);
        } else {
            if (amount <= 0) {
                if (amount != 0) {
                    if (sendingPlayer != null)
                        sendingPlayer.sendMessage(Main.getInstance().prefix + "§cDer Wert muss mindestens 0 sein!");
                    return;
                }
            }
            if (amount > 200000000) {
                if (sendingPlayer != null)
                    sendingPlayer.sendMessage(Main.getInstance().prefix + "§cDer Wert darf maximal 200000000 sein!");
                return;
            }
            try {
                final PreparedStatement ps2 = MySQL.con.prepareStatement("UPDATE points SET value = ? WHERE uuid = ?");
                ps2.setInt(1, amount);
                ps2.setString(2, uuid.toString());
                ps2.executeUpdate();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            if (sendingPlayer != null)
                sendingPlayer.sendMessage(Main.getInstance().prefix + "§aDie Punkte von §6" + Bukkit.getPlayer(uuid).getName() + " §awurden erfolgreich auf §6" + amount + " §a gesetzt!");

            PointChangeEvent e = new PointChangeEvent(Bukkit.getPlayer(uuid), amount);
            Bukkit.getPluginManager().callEvent(e);

        }
    }

    public static void addPoints(final UUID uuid, final int amount, final Player sendingPlayer) {
        final int current = getPoints(uuid);
        if (amount >= 1) {
            if (current < 200000000) {
                if (current + amount < 200000000) {
                    try {
                        final PreparedStatement ps2 = MySQL.con.prepareStatement("UPDATE points SET value = ? WHERE uuid = ?");
                        ps2.setInt(1, current + amount);
                        ps2.setString(2, uuid.toString());
                        ps2.executeUpdate();
                        if (sendingPlayer != null)
                            sendingPlayer.sendMessage(Main.getInstance().prefix + "§aDem Spieler §6" + Bukkit.getPlayer(uuid).getName() + " §awurden erfolgreich §6" + amount + " §a hinzugefügt!");

                        PointChangeEvent e = new PointChangeEvent(Bukkit.getPlayer(uuid), amount);
                        Bukkit.getPluginManager().callEvent(e);

                    } catch (SQLException e2) {
                        e2.printStackTrace();
                    }
                } else {
                    if (sendingPlayer != null)
                        sendingPlayer.sendMessage("§cEin Spieler darf maximal 200000000 Punkte haben!");
                    return;
                }
            } else {
                if (sendingPlayer != null)
                    sendingPlayer.sendMessage("§cEin Spieler darf maximal 200000000 Punkte haben!");
                return;
            }
        } else {
            if (sendingPlayer != null)
                sendingPlayer.sendMessage("§cEinem Spieler muss mindestens 1 Punkt hinzugefügt werden!");
            return;
        }
    }

    public static void removePoints(final UUID uuid, final int amount, final Player sendingPlayer, final boolean all) {
        final int current = getPoints(uuid);
        if (!all) {
            setPoints(uuid, current - amount, sendingPlayer);
            PointChangeEvent e = new PointChangeEvent(Bukkit.getPlayer(uuid), amount);
            Bukkit.getPluginManager().callEvent(e);
        } else {
            setPoints(uuid, 0, sendingPlayer);
            PointChangeEvent e = new PointChangeEvent(Bukkit.getPlayer(uuid), amount);
            Bukkit.getPluginManager().callEvent(e);
        }
    }
}
