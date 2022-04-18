package de.lamacraft.pointsystem.utils.managers;


import de.lamacraft.pointsystem.main.Main;
import de.lamacraft.pointsystem.mysql.MySQL;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class FileManager {

    public static File getConfigFile() {
        return new File("plugins/PointSystem", "config.yml");
    }

    public static FileConfiguration getConfigFileConfiguration() {
        return YamlConfiguration.loadConfiguration(getConfigFile());
    }

    public static File getMySQLFile() {
        return new File("plugins/PointSystem", "mysql.yml");
    }

    public static FileConfiguration getMySQLFileConfiguration() {
        return YamlConfiguration.loadConfiguration(getMySQLFile());
    }

    public static File getMobPointsFile() {
        return new File("plugins/PointSystem", "mobpoints.yml");
    }

    public static FileConfiguration getMobPointsFileConfiguration() {
        return YamlConfiguration.loadConfiguration(getMobPointsFile());
    }

    public static File getHologramsFile() {
        return new File("plugins/PointSystem", "holograms.yml");
    }

    public static FileConfiguration getHologramsFileConfiguration() {
        return YamlConfiguration.loadConfiguration(getHologramsFile());
    }

    public static void setStandardConfig() {
        FileConfiguration cfg = getConfigFileConfiguration();
        cfg.options().copyDefaults(true);
        cfg.addDefault("Prefix", "&8[&6PointSystem&8]");
        cfg.addDefault("DiscordWebhook", "YOUR TOKEN");
        cfg.addDefault("winner", "");
        try {
            cfg.save(getConfigFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readConfig() {
        FileConfiguration cfg = getConfigFileConfiguration();
        Main.getInstance().prefix = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Prefix"))) + " §r";

        Main.getInstance().webhook_url = cfg.getString("DiscordWebhook");
    }

    public static void setStandardMySQL() {
        FileConfiguration cfg = getMySQLFileConfiguration();
        cfg.options().copyDefaults(true);
        cfg.addDefault("username", "root");
        cfg.addDefault("password", "");
        cfg.addDefault("database", "");
        cfg.addDefault("host", "localhost");
        cfg.addDefault("port", "3306");
        try {
            cfg.save(getMySQLFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readMySQL() {
        FileConfiguration cfg = getMySQLFileConfiguration();
        MySQL.username = cfg.getString("username");
        MySQL.password = cfg.getString("password");
        MySQL.database = cfg.getString("database");
        MySQL.host = cfg.getString("host");
        MySQL.port = cfg.getString("port");
    }

    public static void setStandardMobPoints() {
        FileConfiguration cfg = getMobPointsFileConfiguration();
        cfg.options().copyDefaults(true);
        cfg.addDefault("points.evoker", 10);
        cfg.addDefault("points.vindicator", 10);
        cfg.addDefault("points.pillager", 10);
        cfg.addDefault("points.ravager", 10);
        cfg.addDefault("points.vex", 10);
        cfg.addDefault("points.endermite", 10);
        cfg.addDefault("points.guardian", 10);
        cfg.addDefault("points.elder_guardian", 10);
        cfg.addDefault("points.shulker", 10);
        cfg.addDefault("points.husk", 10);
        cfg.addDefault("points.stray", 10);
        cfg.addDefault("points.phantom", 10);
        cfg.addDefault("points.blaze", 10);
        cfg.addDefault("points.creeper", 10);
        cfg.addDefault("points.ghast", 10);
        cfg.addDefault("points.magma_cube", 10);
        cfg.addDefault("points.silverfish", 10);
        cfg.addDefault("points.skeleton", 10);
        cfg.addDefault("points.slime", 10);
        cfg.addDefault("points.zombie", 10);
        cfg.addDefault("points.zombie_villager", 10);
        cfg.addDefault("points.drowned", 10);
        cfg.addDefault("points.wither_skeleton", 10);
        cfg.addDefault("points.witch", 10);
        cfg.addDefault("points.hoglin", 10);
        cfg.addDefault("points.zoglin", 10);
        cfg.addDefault("points.piglin_brute", 10);
        cfg.addDefault("points.cave_spider", 10);
        cfg.addDefault("points.enderman", 10);
        cfg.addDefault("points.piglin", 10);
        cfg.addDefault("points.zombified_piglin", 10);
        try {
            cfg.save(getMobPointsFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
