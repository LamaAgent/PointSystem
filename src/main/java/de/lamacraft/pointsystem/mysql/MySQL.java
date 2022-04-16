package de.lamacraft.pointsystem.mysql;

import de.lamacraft.pointsystem.main.Main;
import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {
    public static String username;
    public static String password;
    public static String database;
    public static String host;
    public static String port;
    public static Connection con;

    public static void connect() {
        if (!isConnected()) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
                Bukkit.getConsoleSender().sendMessage(Main.getInstance().prefix + "MySQL Verbindung aufgebaut!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close() {
        if (isConnected()) {
            try {
                con.close();
                Bukkit.getConsoleSender().sendMessage(Main.getInstance().prefix + "MySQL Verbindung geschlossen!");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public static boolean isConnected() {
        return con != null;
    }

    public static void createPointTable() {
        if (isConnected()) {
            try {
                con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS points (playername VARCHAR(100), uuid VARCHAR(100), value INT(100))");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
