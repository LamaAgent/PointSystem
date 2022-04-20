/*
 * Copyright (c) by Lama_Agent (2022).
 * All rights reserved
 */

package de.lamacraft.pointsystem.commands;

import de.lamacraft.pointsystem.main.Main;
import de.lamacraft.pointsystem.utils.managers.ItemManager;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

public class AddEnchantmentCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p) {
            String enchantment_type = args[0];
            int enchantment_level;
            try {
                enchantment_level = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                p.sendMessage("§c<Level> muss eine Zahl sein!");
                return true;
            }

            if (enchantment_type.equalsIgnoreCase("protection")) {
                PlayerInventory inv = p.getInventory();
                int i = 0;

                for (ItemStack enchant : ItemManager.getProtectionEnchants()) {
                    if (inv.contains(enchant)) {
                        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) enchant.getItemMeta();
                        assert meta != null;
                        int enchant_level = meta.getStoredEnchants().get(Enchantment.PROTECTION_ENVIRONMENTAL);
                        if (enchant_level == enchantment_level) {
                            if (inv.getItemInMainHand().getType() != Material.AIR) {

                                if (p.getLevel() >= 30) {
                                    p.setLevel(p.getLevel() - 30);
                                    inv.remove(enchant);
                                    inv.getItemInMainHand().addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, enchant_level);
                                    p.sendMessage(Main.getInstance().prefix + "§aDein Item wurde erfolgreich enchantet!");
                                } else {
                                    p.sendMessage(Main.getInstance().prefix + "§cDazu hast du zu wenige Level!");
                                }
                            }
                        }
                    } else {
                        i++;
                        if (i >= 3)
                            p.sendMessage(Main.getInstance().prefix + "§cDu hast nicht das passende Buch!");
                    }
                }
            }

        }

        return false;
    }
}
