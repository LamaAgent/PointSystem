package de.lamacraft.pointsystem.main;

import de.lamacraft.pointsystem.commands.PointsCommand;
import de.lamacraft.pointsystem.commands.ShopCommand;
import de.lamacraft.pointsystem.listeners.ClickListener;
import de.lamacraft.pointsystem.listeners.EnemyKillListener;
import de.lamacraft.pointsystem.listeners.JoinListener;
import de.lamacraft.pointsystem.listeners.PointChangeListener;
import de.lamacraft.pointsystem.mysql.MySQL;
import de.lamacraft.pointsystem.utils.FileManager;
import de.lamacraft.pointsystem.utils.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static String webhook_url;
    private static Main instance;
//    private static HoloManager manager;

    public String prefix;

    public static Main getInstance() {
        return instance;
    }

//    public static HoloManager getManager() {
//        return manager;
//    }

    @Override
    public void onEnable() {
        instance = this;
        setupFiles();
        setupMySQL();
        registerCommands();
        setupListeners();

        if (!Bukkit.getOnlinePlayers().isEmpty()) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                ScoreboardManager.updateScoreboard(player);
            }
        }

//        manager = new HoloManager();
//
//        manager.spawnAllHolos();

        Bukkit.getConsoleSender().sendMessage(prefix + "§aPointsSystem erfolgreich aktiviert!");
    }

    @Override
    public void onDisable() {

        MySQL.close();

//        manager.removeAllHolos();

        Bukkit.getConsoleSender().sendMessage(prefix + "§cPointsSystem erfolgreich deaktiviert!");
    }

    public void setupFiles() {
        FileManager.setStandardConfig();
        FileManager.setStandardMySQL();
        FileManager.setStandardMobPoints();
        FileManager.readConfig();
        FileManager.readMySQL();
    }

    public void setupMySQL() {
        MySQL.connect();
        MySQL.createPointTable();
    }

    public void registerCommands() {
        Bukkit.getPluginCommand("points").setExecutor(new PointsCommand());
        Bukkit.getPluginCommand("shop").setExecutor(new ShopCommand());
//        Bukkit.getPluginCommand("hologram").setExecutor(new HologramCommand());
    }

    public void setupListeners() {

        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);

        Bukkit.getPluginManager().registerEvents(new ClickListener(), this);

        Bukkit.getPluginManager().registerEvents(new EnemyKillListener(), this);

        Bukkit.getPluginManager().registerEvents(new PointChangeListener(), this);
    }
}
