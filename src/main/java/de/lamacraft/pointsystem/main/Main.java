package de.lamacraft.pointsystem.main;

import de.lamacraft.pointsystem.mysql.MySQL;
import de.lamacraft.pointsystem.utils.FileManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static String webhook_url;
    private static Main instance;

    public String prefix;
    @Override
    public void onEnable() {
        instance = this;
        setupFiles();
        setupMySQL();

    }

    @Override
    public void onDisable() {

    }

    public static Main getInstance() {
        return instance;
    }

    public void setupFiles() {
        FileManager.setStandardConfig();
        FileManager.setStandardMySQL();
        FileManager.readConfig();
        FileManager.readMySQL();
    }

    public void setupMySQL() {
        MySQL.connect();
        MySQL.createPointTable();
    }
}
