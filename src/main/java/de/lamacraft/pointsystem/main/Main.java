package de.lamacraft.pointsystem.main;

import de.lamacraft.pointsystem.commands.HoloCommand;
import de.lamacraft.pointsystem.commands.PointsCommand;
import de.lamacraft.pointsystem.commands.ShopCommand;
import de.lamacraft.pointsystem.listeners.*;
import de.lamacraft.pointsystem.mysql.MySQL;
import de.lamacraft.pointsystem.utils.FileManager;
import de.lamacraft.pointsystem.utils.KillController;
import de.lamacraft.pointsystem.utils.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static String webhook_url;
    private static Main instance;

    public String prefix;

    public static Main getInstance() {
        return instance;
    }


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

        KillController.startKillTimer();

        Bukkit.getConsoleSender().sendMessage(prefix + "§aPointsSystem erfolgreich aktiviert!");
    }

    @Override
    public void onDisable() {

        MySQL.close();

        KillController.stopKillTimer();

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
        Bukkit.getPluginCommand("holo").setExecutor(new HoloCommand());
    }

    public void setupListeners() {

        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);

        Bukkit.getPluginManager().registerEvents(new ClickListener(), this);

        Bukkit.getPluginManager().registerEvents(new EnemyKillListener(), this);

        Bukkit.getPluginManager().registerEvents(new PointChangeListener(), this);

        Bukkit.getPluginManager().registerEvents(new DeathListener(), this);

        Bukkit.getPluginManager().registerEvents(new InteractListener(), this);

        Bukkit.getPluginManager().registerEvents(new BlockPlaceListener(), this);

        Bukkit.getPluginManager().registerEvents(new PingListener(), this);
    }
}
