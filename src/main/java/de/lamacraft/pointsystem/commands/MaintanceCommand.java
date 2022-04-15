package de.lamacraft.pointsystem.commands;

import de.lamacraft.pointsystem.utils.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.IOException;

public class MaintanceCommand implements CommandExecutor {

    FileConfiguration cfg = FileManager.getConfigFileConfiguration();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender.hasPermission("lamacraft.maintance.change")) {
            if (args.length == 0) {
                if (cfg.getBoolean("maintance")) {
                    cfg.set("maintance", false);
                    sender.sendMessage("§cDer Wartungsmodus wurde deaktiviert!");
                } else {
                    cfg.set("maintance", true);
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        if (!players.hasPermission("lamacraft.maintance.bypass")) {
                            players.kickPlayer("§cDer Server befindet sich nun im Wartungsmodus!");
                        }
                    }
                    sender.sendMessage("§aDer Wartungsmodus wurde aktiviert, und es wurden alle Spieler gekickt!");
                }
                try {
                    cfg.save(FileManager.getConfigFile());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else
                sender.sendMessage("§cBitte benutze §6/maintance §c!");
        } else
            sender.sendMessage("§cDazu hast du keine Rechte!");

        return false;
    }
}
