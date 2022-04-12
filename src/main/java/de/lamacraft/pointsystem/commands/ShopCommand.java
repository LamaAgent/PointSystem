package de.lamacraft.pointsystem.commands;

import de.lamacraft.pointsystem.main.Main;
import de.lamacraft.pointsystem.utils.FileManager;
import de.lamacraft.pointsystem.utils.InventoryManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class ShopCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            InventoryManager.createInventory(p);

//            Main.getManager().removeAllHolos();
        }

        return false;
    }
}
