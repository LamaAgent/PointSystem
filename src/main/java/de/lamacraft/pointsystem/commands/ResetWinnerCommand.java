package de.lamacraft.pointsystem.commands;

import de.lamacraft.pointsystem.utils.managers.FileManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.IOException;
import java.util.Objects;

public class ResetWinnerCommand implements CommandExecutor {

    public static FileConfiguration cfg = FileManager.getConfigFileConfiguration();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender.hasPermission("lamacraft.resetwinner")) {
            if (!Objects.requireNonNull(cfg.getString("winner")).equalsIgnoreCase("")) {
                cfg.set("winner", "");
                try {
                    cfg.save(FileManager.getConfigFile());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sender.sendMessage("§aGewinner zurückgesetzt!");
            } else {
                sender.sendMessage("§cEs gibt zurzeit keinen Gewinner!");
            }
        } else {
            sender.sendMessage("§cDazu hast du keine Rechte!");
        }

        return false;
    }
}
