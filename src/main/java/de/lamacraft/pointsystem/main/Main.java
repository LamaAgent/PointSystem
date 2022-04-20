/*
 * Copyright (c) by Lama_Agent (2022).
 * All rights reserved
 */

package de.lamacraft.pointsystem.main;

import de.lamacraft.pointsystem.commands.*;
import de.lamacraft.pointsystem.listeners.*;
import de.lamacraft.pointsystem.mysql.MySQL;
import de.lamacraft.pointsystem.utils.DiscordWebhook;
import de.lamacraft.pointsystem.utils.KillController;
import de.lamacraft.pointsystem.utils.managers.FileManager;
import de.lamacraft.pointsystem.utils.managers.HologramManager;
import de.lamacraft.pointsystem.utils.managers.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Main extends JavaPlugin {

    public String webhook_url;
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
        HologramManager.spawnHolos();
        registerCommands();
        setupListeners();

        if (!Bukkit.getOnlinePlayers().isEmpty()) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                ScoreboardManager.updateScoreboard(player);
            }
        }

        KillController.startKillTimer();

        DiscordWebhook webhook = new DiscordWebhook(webhook_url);
        webhook.addEmbed(new DiscordWebhook.EmbedObject()
                .setDescription("Der Server wurde gestartet!")
                .setColor(Color.GREEN)
                .setAuthor("SERVER", "", "https://i.ibb.co/Dw1CHgT/server-icon.png"));

        try {
            webhook.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Bukkit.getConsoleSender().sendMessage(prefix + "§aPointsSystem erfolgreich aktiviert!");
    }

    @Override
    public void onDisable() {

        MySQL.close();

        KillController.stopKillTimer();

        HologramManager.despawnAllHolos(Bukkit.getWorld("world"));

        DiscordWebhook webhook = new DiscordWebhook(webhook_url);
        webhook.addEmbed(new DiscordWebhook.EmbedObject()
                .setDescription("Der Server wurde gestoppt!!")
                .setColor(Color.RED)
                .setAuthor("SERVER", "", "https://i.ibb.co/Dw1CHgT/server-icon.png"));

        try {
            webhook.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Bukkit.getConsoleSender().sendMessage(prefix + "§cPointsSystem erfolgreich deaktiviert!");
    }

    public void setupFiles() {
        FileManager.setStandardConfig();
        FileManager.setStandardMySQL();
        FileManager.setStandardMobPoints();
        FileManager.setStandardItemPoints();
        FileManager.readConfig();
        FileManager.readMySQL();
    }

    public void setupMySQL() {
        MySQL.connect();
        MySQL.createPointTable();
    }

    public void registerCommands() {
        Objects.requireNonNull(Bukkit.getPluginCommand("points")).setExecutor(new PointsCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("shop")).setExecutor(new ShopCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("holo")).setExecutor(new HoloCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("maintance")).setExecutor(new MaintanceCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("resetwinner")).setExecutor(new ResetWinnerCommand());
    }

    public void setupListeners() {

        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);

        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);

        Bukkit.getPluginManager().registerEvents(new EnemyKillListener(), this);

        Bukkit.getPluginManager().registerEvents(new PointChangeListener(), this);

        Bukkit.getPluginManager().registerEvents(new DeathListener(), this);

        Bukkit.getPluginManager().registerEvents(new InteractListener(), this);

        Bukkit.getPluginManager().registerEvents(new BlockPlaceListener(), this);

        Bukkit.getPluginManager().registerEvents(new PingListener(), this);

        Bukkit.getPluginManager().registerEvents(new LoginListener(), this);
    }
}
