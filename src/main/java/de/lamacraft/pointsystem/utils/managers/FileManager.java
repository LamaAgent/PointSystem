/*
 * Copyright (c) by Lama_Agent (2022).
 * All rights reserved
 */

package de.lamacraft.pointsystem.utils.managers;


import de.lamacraft.pointsystem.main.Main;
import de.lamacraft.pointsystem.mysql.MySQL;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

    public static File getItemPointsFile() {
        return new File("plugins/PointSystem", "itempoints.yml");
    }

    public static FileConfiguration getItemPointsFileConfiguration() {
        return YamlConfiguration.loadConfiguration(getItemPointsFile());
    }

    public static File getBlockPointsFile() {
        return new File("plugins/PointSystem", "blockpoints.yml");
    }

    public static FileConfiguration getBlockPointsFileConfiguration() {
        return YamlConfiguration.loadConfiguration(getBlockPointsFile());
    }

    public static File getSayingsFile() {
        return new File("plugins/PointSystem", "sayings.yml");
    }

    public static FileConfiguration getSayingsFileConfiguration() {
        return YamlConfiguration.loadConfiguration(getSayingsFile());
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

    public static void setStandardMobPoints() {
        FileConfiguration cfg = getMobPointsFileConfiguration();
        cfg.options().copyDefaults(true);
        cfg.addDefault("points.evoker", 850);
        cfg.addDefault("points.vindicator", 500);
        cfg.addDefault("points.pillager", 300);
        cfg.addDefault("points.ravager", 1000);
        cfg.addDefault("points.vex", 100);
        cfg.addDefault("points.endermite", 100);
        cfg.addDefault("points.guardian", 100);
        cfg.addDefault("points.elder_guardian", 2000);
        cfg.addDefault("points.shulker", 250);
        cfg.addDefault("points.husk", 40);
        cfg.addDefault("points.spider", 35);
        cfg.addDefault("points.stray", 75);
        cfg.addDefault("points.phantom", 100);
        cfg.addDefault("points.blaze", 100);
        cfg.addDefault("points.creeper", 50);
        cfg.addDefault("points.ghast", 150);
        cfg.addDefault("points.magma_cube", 10);
        cfg.addDefault("points.silverfish", 50);
        cfg.addDefault("points.skeleton", 50);
        cfg.addDefault("points.slime", 10);
        cfg.addDefault("points.zombie", 25);
        cfg.addDefault("points.zombie_villager", 200);
        cfg.addDefault("points.drowned", 40);
        cfg.addDefault("points.wither_skeleton", 200);
        cfg.addDefault("points.witch", 100);
        cfg.addDefault("points.hoglin", 150);
        cfg.addDefault("points.zoglin", 1000);
        cfg.addDefault("points.piglin_brute", 1000);
        cfg.addDefault("points.cave_spider", 75);
        cfg.addDefault("points.enderman", 30);
        cfg.addDefault("points.piglin", 50);
        cfg.addDefault("points.zombified_piglin", 50);
        cfg.addDefault("points.wither", 1200);
        cfg.addDefault("points.ender_dragon", 10000);
        try {
            cfg.save(getMobPointsFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setStandardItemPoints() {
        FileConfiguration cfg = getItemPointsFileConfiguration();
        cfg.options().copyDefaults(true);
        //Ingots
        cfg.addDefault("points.iron_ingot", 12);
        cfg.addDefault("points.gold_ingot", 12);
        cfg.addDefault("points.copper_ingot", 10);
        cfg.addDefault("points.netherite_ingot", 800);

        //Other Ores
        cfg.addDefault("points.emerald", 15);
        cfg.addDefault("points.lapis_lazuli", 10);
        cfg.addDefault("points.redstone", 10);
        cfg.addDefault("points.coal", 8);
        cfg.addDefault("points.diamond", 40);

        //Special Items
        cfg.addDefault("points.dragon_egg", 100000);
        cfg.addDefault("points.sponge", 200);
        cfg.addDefault("points.beacon", 6000);
        cfg.addDefault("points.shulker_box", 2500);
        cfg.addDefault("points.turtle_egg", 60);
        cfg.addDefault("points.ender_pearl", 15);
        cfg.addDefault("points.experience_bottle", 5000);
        cfg.addDefault("points.nether_star", 5000);
        cfg.addDefault("points.saddle", 2000);
        cfg.addDefault("points.name_tag", 1000);
        cfg.addDefault("points.heart_of_the_sea", 6000);
        cfg.addDefault("points.elytra", 4500);

        try {
            cfg.save(getItemPointsFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setStandardBlockPoints() {
        FileConfiguration cfg = getBlockPointsFileConfiguration();
        cfg.options().copyDefaults(true);
        cfg.addDefault("points.spawner", 1500);
        try {
            cfg.save(getBlockPointsFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void setStandardSayings() {
        FileConfiguration cfg = getSayingsFileConfiguration();
        cfg.options().copyDefaults(true);

        List<String> sayings = new ArrayList<>();

        sayings.add("Ein Satz mit X, das war wohl nichts!");
        sayings.add("Better luck next time!");
        sayings.add("Du hast wohl weder Gl??ck im Spiel noch in der Liebe!");
        sayings.add("Der Weg zum Gl??ck ist der n??chste Versuch!");
        sayings.add("Das n??chste Los gewinnt bestimmt!");
        sayings.add("Nicht verzagen - nochmal wagen!");
        sayings.add("Das n??chste Mal klappt's sicher!");
        sayings.add("Dabeisein ist alles!");
        sayings.add("Nimm's leicht - mach noch ein Spin!");
        sayings.add("So'n Pech - Spin gleich nochmal!");
        sayings.add("Neuer Spin - neues Gl??ck!");
        sayings.add("Pech im Spiel - Gl??ck in der Liebe!");

        cfg.addDefault("sayings", sayings);
        try {
            cfg.save(getSayingsFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void readConfig() {
        FileConfiguration cfg = getConfigFileConfiguration();
        Main.getInstance().prefix = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Prefix"))) + " ??r";

        Main.getInstance().webhook_url = cfg.getString("DiscordWebhook");
    }

    public static void readMySQL() {
        FileConfiguration cfg = getMySQLFileConfiguration();
        MySQL.username = cfg.getString("username");
        MySQL.password = cfg.getString("password");
        MySQL.database = cfg.getString("database");
        MySQL.host = cfg.getString("host");
        MySQL.port = cfg.getString("port");
    }
}
