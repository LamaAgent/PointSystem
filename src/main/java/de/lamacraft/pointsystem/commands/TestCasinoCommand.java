/*
 * Copyright (c) by Lama_Agent (2022).
 * All rights reserved
 */

package de.lamacraft.pointsystem.commands;

import de.lamacraft.pointsystem.main.Main;
import de.lamacraft.pointsystem.utils.managers.GodEquipManager;
import de.lamacraft.pointsystem.utils.managers.InventoryManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.List;

public class TestCasinoCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p) {

            p.openInventory(InventoryManager.getCasinoInventory());


            BukkitTask runnable = new BukkitRunnable() {
                int status = 0;

                @Override
                public void run() {

                    if (status <= 10) {

                        if (p.getOpenInventory().getTitle().equalsIgnoreCase("CASINO")) {
                            Inventory inv = p.getOpenInventory().getTopInventory();
                            for (int i = 3; i <= 5; i++) {

                                List<ItemStack> casino_items = GodEquipManager.getGodItems();

                                int max = casino_items.size();

                                int min = 0;

                                int random_int = (int) Math.floor(Math.random() * (max - min) + min);

                                inv.setItem(i, casino_items.get(random_int));

                            }
                        } else {
                            cancel();
                        }

                        status++;

                    } else {
                        p.sendMessage("§6Auswertung...");
                        cancel();
                    }

                }
            }.runTaskTimer(Main.getInstance(), 0, 20L);


            new BukkitRunnable() {
                @Override
                public void run() {
                    if (runnable.isCancelled()) {
                        if (p.getOpenInventory().getTitle().equalsIgnoreCase("CASINO")) {
                            Inventory topInv = p.getOpenInventory().getTopInventory();
                            ItemStack item1 = topInv.getItem(3);
                            ItemStack item2 = topInv.getItem(4);
                            ItemStack item3 = topInv.getItem(5);

                            if (item1 != null && item2 != null && item3 != null) {

                                if (item1.isSimilar(item2) && item2.isSimilar(item3)) {
                                    p.getInventory().addItem(item1);
                                    p.sendMessage("§aDu hast gewonnen!");
                                    cancel();
                                } else {
                                    p.sendMessage("§cDu hast verloren!");
                                    cancel();
                                }
                            }
                        } else {
                            cancel();
                        }
                    } else {
                        p.sendMessage("§cNot cancelled!");
                        cancel();
                    }
                }
            }.runTaskLater(Main.getInstance(), 250L);

        }

        return false;
    }

}
