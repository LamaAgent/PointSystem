package de.lamacraft.pointsystem.commands;

import de.lamacraft.pointsystem.utils.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShopCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p) {
            p.getInventory().addItem(ItemManager.getShop_chest());

        }

        return false;
    }
}
