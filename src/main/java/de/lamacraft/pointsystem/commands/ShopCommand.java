/*
 * Copyright (c) by Lama_Agent (2022).
 * All rights reserved
 */

package de.lamacraft.pointsystem.commands;

import de.lamacraft.pointsystem.utils.managers.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ShopCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p) {
            p.getInventory().addItem(ItemManager.getShop_chest());

            for (ItemStack protectionEnchant : ItemManager.getProtectionEnchants()) {
                p.getInventory().addItem(protectionEnchant);
            }

            for (ItemStack enchant : ItemManager.getUnbreakingEnchants()) {
                p.getInventory().addItem(enchant);
            }

            for (ItemStack enchant : ItemManager.getPowerEnchants()) {
                p.getInventory().addItem(enchant);
            }

            for (ItemStack enchant : ItemManager.getSharpnessEnchants()) {
                p.getInventory().addItem(enchant);
            }

            for (ItemStack enchant : ItemManager.getFortuneEnchants()) {
                p.getInventory().addItem(enchant);
            }

        }

        return false;
    }
}
