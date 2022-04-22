/*
 * Copyright (c) by Lama_Agent (2022).
 * All rights reserved
 */

package de.lamacraft.pointsystem.commands;

import de.lamacraft.pointsystem.main.Main;
import de.lamacraft.pointsystem.utils.managers.FileManager;
import de.lamacraft.pointsystem.utils.managers.InventoryManager;
import de.lamacraft.pointsystem.utils.managers.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;

public class TestCasinoCommand implements CommandExecutor {

    private static void setGlassPanes(ItemStack glassPanes, Inventory inv, List<Integer> slots) {

        for (int slot : slots) {
            inv.setItem(slot, glassPanes);
        }

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p) {

            p.openInventory(InventoryManager.getCasinoInventory());

            p.sendMessage("§aDein Spin geht los!");

            BukkitTask runnable = new BukkitRunnable() {
                int status = 15;

                @Override
                public void run() {
                    if (status >= 0) {

                        if (p.getOpenInventory().getTitle().equalsIgnoreCase("CASINO")) {
                            Inventory inv = p.getOpenInventory().getTopInventory();
                            List<Integer> slots = new ArrayList<>();
                            slots.add(0);
                            slots.add(1);
                            slots.add(2);
                            slots.add(6);
                            slots.add(7);
                            slots.add(8);
                            switch (status) {
                                case 15:
                                case 0:
                                case 3:
                                case 6:
                                case 9:
                                case 12:
                                    setGlassPanes(ItemManager.getGlassPanes().get(0), inv, slots);
                                    break;
                                case 14:
                                case 2:
                                case 5:
                                case 8:
                                case 11:
                                    setGlassPanes(ItemManager.getGlassPanes().get(1), inv, slots);
                                    break;
                                case 13:
                                case 1:
                                case 4:
                                case 7:
                                case 10:
                                    setGlassPanes(ItemManager.getGlassPanes().get(2), inv, slots);
                                    break;
                            }
                            if (status > 10) {

                                for (int i = 3; i <= 5; i++) {

                                    List<ItemStack> casino_items = ItemManager.getCasinoItems();

                                    int max = casino_items.size();

                                    int min = 0;

                                    int random_int = (int) Math.floor(Math.random() * (max - min) + min);

                                    inv.setItem(i, casino_items.get(random_int));
                                }
                            } else if (status > 5) {
                                for (int i = 4; i <= 5; i++) {

                                    List<ItemStack> casino_items = ItemManager.getCasinoItems();

                                    int max = casino_items.size();

                                    int min = 0;

                                    int random_int = (int) Math.floor(Math.random() * (max - min) + min);

                                    inv.setItem(i, casino_items.get(random_int));
                                }
                            } else if (status > 0) {
                                for (int i = 5; i <= 5; i++) {

                                    List<ItemStack> casino_items = ItemManager.getCasinoItems();

                                    int max = casino_items.size();

                                    int min = 0;

                                    int random_int = (int) Math.floor(Math.random() * (max - min) + min);

                                    inv.setItem(i, casino_items.get(random_int));
                                }
                            }
                        } else {
                            p.sendMessage("§4Spin abgebrochen!");
                            cancel();
                        }

                        status--;

                    } else {
                        p.sendMessage("§6Auswertung...");
                        cancel();
                    }

                }
            }.runTaskTimer(Main.getInstance(), 0, 10L);


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
                                    if (item1.getType() != Material.DIRT) {
                                        p.getInventory().addItem(item1);
                                        p.sendMessage("§aDu hast gewonnen!");
                                        cancel();
                                    } else {
                                        List<String> sayings = FileManager.getSayingsFileConfiguration().getStringList("sayings");

                                        int max = sayings.size();

                                        int min = 0;

                                        int random_int = (int) Math.floor(Math.random() * (max - min) + min);

                                        p.sendMessage(ChatColor.DARK_RED + sayings.get(random_int));

                                        cancel();
                                    }
                                } else {

                                    List<String> sayings = FileManager.getSayingsFileConfiguration().getStringList("sayings");

                                    int max = sayings.size();

                                    int min = 0;

                                    int random_int = (int) Math.floor(Math.random() * (max - min) + min);

                                    p.sendMessage(ChatColor.DARK_RED + sayings.get(random_int));

                                    cancel();
                                }
                            }
                        } else {
                            p.sendMessage("§4Spin abgebrochen!");
                            cancel();
                        }
                    } else {
                        p.sendMessage("§cNot cancelled!");
                        cancel();
                    }
                }
            }.runTaskLater(Main.getInstance(), 200L);

        }

        return false;
    }

}
