/*
 * Copyright (c) by Lama_Agent (2022).
 * All rights reserved
 */

package de.lamacraft.pointsystem.commands;

import de.lamacraft.pointsystem.main.Main;
import de.lamacraft.pointsystem.utils.managers.FileManager;
import de.lamacraft.pointsystem.utils.managers.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestCasinoCommand implements CommandExecutor {

    public static HashMap<Player, Boolean> isSpinning = new HashMap<>();

    public static Location loc1 = new Location(Bukkit.getWorld("world"), -28.96875, 73.5, -0.5, 270.0f, 0.0f);

    public static Location loc2 = new Location(Bukkit.getWorld("world"), -28.96875, 73.5, -1.5, 270.0f, 0.0f);

    public static Location loc3 = new Location(Bukkit.getWorld("world"), -28.96875, 73.5, -2.5, 270.0f, 0.0f);


//    private static void setGlassPanes(ItemStack glassPanes, Inventory inv, List<Integer> slots) {
//
//        for (int slot : slots) {
//            inv.setItem(slot, glassPanes);
//        }
//
//    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p) {

            if (!isSpinning.containsKey(p) || !isSpinning.get(p)) {

                ItemFrame frame1 = null;
                ItemFrame frame2 = null;
                ItemFrame frame3 = null;


                for (Entity entity : p.getNearbyEntities(5, 5, 5)) {
                    if (entity instanceof ItemFrame) {
                        Location entityloc = entity.getLocation();
                        if (entityloc.equals(loc1)) {
                            frame1 = (ItemFrame) entity;
                        } else if (entityloc.equals(loc2)) {
                            frame2 = (ItemFrame) entity;
                        } else if (entityloc.equals(loc3)) {
                            frame3 = (ItemFrame) entity;
                        }
                    }
                }

                if (frame1 != null && frame2 != null && frame3 != null) {

                    isSpinning.put(p, true);

                    List<ItemFrame> frames = new ArrayList<>();
                    frames.add(frame1);
                    frames.add(frame2);
                    frames.add(frame3);

                    p.sendMessage("§aDein Spin geht los!");

                    BukkitTask runnable = new BukkitRunnable() {
                        int status = 15;

                        @Override
                        public void run() {
                            if (status >= 0) {

                                if (status > 10) {

                                    for (int i = 0; i <= 2; i++) {

                                        List<ItemStack> casino_items = ItemManager.getCasinoItems();

                                        int max = casino_items.size();

                                        int min = 0;

                                        int random_int = (int) Math.floor(Math.random() * (max - min) + min);

                                        frames.get(i).setItem(casino_items.get(random_int));
                                    }
                                } else if (status > 5) {
                                    for (int i = 1; i <= 2; i++) {

                                        List<ItemStack> casino_items = ItemManager.getCasinoItems();

                                        int max = casino_items.size();

                                        int min = 0;

                                        int random_int = (int) Math.floor(Math.random() * (max - min) + min);

                                        frames.get(i).setItem(casino_items.get(random_int));
                                    }
                                } else if (status > 0) {
                                    for (int i = 2; i <= 2; i++) {

                                        List<ItemStack> casino_items = ItemManager.getCasinoItems();

                                        int max = casino_items.size();

                                        int min = 0;

                                        int random_int = (int) Math.floor(Math.random() * (max - min) + min);

                                        frames.get(i).setItem(casino_items.get(random_int));
                                    }
                                }

                                status--;

                            } else {
                                p.sendMessage("§6Auswertung...");
                                cancel();
                            }

                        }
                    }.runTaskTimer(Main.getInstance(), 0, 10L);

                    ItemFrame finalFrame1 = frame1;
                    ItemFrame finalFrame2 = frame2;
                    ItemFrame finalFrame3 = frame3;
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            if (runnable.isCancelled()) {

                                isSpinning.remove(p);

                                ItemStack item1 = finalFrame1.getItem();

                                ItemStack item2 = finalFrame2.getItem();

                                ItemStack item3 = finalFrame3.getItem();


                                if (item1.getType() != Material.AIR && item2.getType() != Material.AIR && item3.getType() != Material.AIR) {

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
                                p.sendMessage("§cNot cancelled!");
                                cancel();
                            }
                        }
                    }.runTaskLater(Main.getInstance(), 200L);

                } else {
                    p.sendMessage("§cFehler!");
                    return true;
                }
//            BukkitTask runnable = new BukkitRunnable() {
//                int status = 15;
//
//                @Override
//                public void run() {
//                    if (status >= 0) {
//
//                        if (p.getOpenInventory().getTitle().equalsIgnoreCase("CASINO")) {
//                            Inventory inv = p.getOpenInventory().getTopInventory();
//                            List<Integer> slots = new ArrayList<>();
//                            slots.add(0);
//                            slots.add(1);
//                            slots.add(2);
//                            slots.add(6);
//                            slots.add(7);
//                            slots.add(8);
//                            switch (status) {
//                                case 0 -> {
//                                    ItemStack panes = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
//                                    ItemMeta meta = panes.getItemMeta();
//                                    meta.setDisplayName(ChatColor.GREEN + "Spin zu Ende!");
//                                    panes.setItemMeta(meta);
//                                    setGlassPanes(panes, inv, slots);
//                                }
//                                case 3, 6, 9, 12, 15 -> setGlassPanes(ItemManager.getGlassPanes().get(0), inv, slots);
//                                case 14, 2, 5, 8, 11 -> setGlassPanes(ItemManager.getGlassPanes().get(1), inv, slots);
//                                case 13, 1, 4, 7, 10 -> setGlassPanes(ItemManager.getGlassPanes().get(2), inv, slots);
//                            }
//                            if (status > 10) {
//
//                                for (int i = 3; i <= 5; i++) {
//
//                                    List<ItemStack> casino_items = ItemManager.getCasinoItems();
//
//                                    int max = casino_items.size();
//
//                                    int min = 0;
//
//                                    int random_int = (int) Math.floor(Math.random() * (max - min) + min);
//
//                                    inv.setItem(i, casino_items.get(random_int));
//                                }
//                            } else if (status > 5) {
//                                for (int i = 4; i <= 5; i++) {
//
//                                    List<ItemStack> casino_items = ItemManager.getCasinoItems();
//
//                                    int max = casino_items.size();
//
//                                    int min = 0;
//
//                                    int random_int = (int) Math.floor(Math.random() * (max - min) + min);
//
//                                    inv.setItem(i, casino_items.get(random_int));
//                                }
//                            } else if (status > 0) {
//                                for (int i = 5; i <= 5; i++) {
//
//                                    List<ItemStack> casino_items = ItemManager.getCasinoItems();
//
//                                    int max = casino_items.size();
//
//                                    int min = 0;
//
//                                    int random_int = (int) Math.floor(Math.random() * (max - min) + min);
//
//                                    inv.setItem(i, casino_items.get(random_int));
//                                }
//                            }
//                        } else {
//                            p.sendMessage("§4Spin abgebrochen!");
//                            cancel();
//                        }
//
//                        status--;
//
//                    } else {
//                        p.sendMessage("§6Auswertung...");
//                        cancel();
//                    }
//
//                }
//            }.runTaskTimer(Main.getInstance(), 0, 10L);
//
//
//            new BukkitRunnable() {
//                @Override
//                public void run() {
//                    if (runnable.isCancelled()) {
//                        if (p.getOpenInventory().getTitle().equalsIgnoreCase("CASINO")) {
//                            Inventory topInv = p.getOpenInventory().getTopInventory();
//                            ItemStack item1 = topInv.getItem(3);
//                            ItemStack item2 = topInv.getItem(4);
//                            ItemStack item3 = topInv.getItem(5);
//
//                            if (item1 != null && item2 != null && item3 != null) {
//
//                                if (item1.isSimilar(item2) && item2.isSimilar(item3)) {
//                                    if (item1.getType() != Material.DIRT) {
//                                        p.getInventory().addItem(item1);
//                                        p.sendMessage("§aDu hast gewonnen!");
//                                        cancel();
//                                    } else {
//                                        List<String> sayings = FileManager.getSayingsFileConfiguration().getStringList("sayings");
//
//                                        int max = sayings.size();
//
//                                        int min = 0;
//
//                                        int random_int = (int) Math.floor(Math.random() * (max - min) + min);
//
//                                        p.sendMessage(ChatColor.DARK_RED + sayings.get(random_int));
//
//                                        cancel();
//                                    }
//                                } else {
//
//                                    List<String> sayings = FileManager.getSayingsFileConfiguration().getStringList("sayings");
//
//                                    int max = sayings.size();
//
//                                    int min = 0;
//
//                                    int random_int = (int) Math.floor(Math.random() * (max - min) + min);
//
//                                    p.sendMessage(ChatColor.DARK_RED + sayings.get(random_int));
//
//                                    cancel();
//                                }
//                            }
//                        } else {
//                            p.sendMessage("§4Spin abgebrochen!");
//                            cancel();
//                        }
//                    } else {
//                        p.sendMessage("§cNot cancelled!");
//                        cancel();
//                    }
//                }
//            }.runTaskLater(Main.getInstance(), 200L);
//


            } else {
                p.sendMessage("§cDu spinnst bereits!");
                return true;
            }
        }

        return false;
    }

}
