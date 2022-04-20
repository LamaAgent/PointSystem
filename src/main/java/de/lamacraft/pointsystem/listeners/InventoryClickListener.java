/*
 * Copyright (c) by Lama_Agent (2022).
 * All rights reserved
 */

package de.lamacraft.pointsystem.listeners;

import de.lamacraft.pointsystem.api.PointsAPI;
import de.lamacraft.pointsystem.main.Main;
import de.lamacraft.pointsystem.utils.managers.FileManager;
import de.lamacraft.pointsystem.utils.managers.ItemManager;
import org.apache.commons.lang.WordUtils;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClickListener implements Listener {

    FileConfiguration cfg = FileManager.getItemPointsFileConfiguration();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("§6SHOP")) {

            for (ItemStack item : ItemManager.getShowItems()) {
                if (e.getCurrentItem() != null) {
                    if (e.getCurrentItem().isSimilar(item)) {
                        if (PointsAPI.getPoints(p.getUniqueId()) >= 1000) {
                            PointsAPI.removePoints(p.getUniqueId(), 1000, false);
                            p.getInventory().addItem(item);
                            String itemType = item.getType().toString();
                            String output = WordUtils.capitalizeFully(itemType.replace("_", " "));
                            p.sendMessage("§aDu hast dir erfolgreich ein/e/en §6" + output + " §agekauft!");
                            p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                            e.setCancelled(true);
                        }
                    }
                }
            }


            if (e.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY) {
                if (e.getClickedInventory() == p.getInventory()) {
                    if (e.getCurrentItem() != null) {
                        switch (e.getCurrentItem().getType()) {
                            case IRON_INGOT, GOLD_INGOT, COPPER_INGOT, NETHERITE_INGOT, EMERALD, LAPIS_LAZULI, REDSTONE, COAL, DIAMOND, DRAGON_EGG, SPONGE, BEACON, SHULKER_BOX, TURTLE_EGG, ENDER_PEARL, EXPERIENCE_BOTTLE, NETHER_STAR, SADDLE, NAME_TAG, HEART_OF_THE_SEA, ELYTRA -> {
                                ItemStack item = e.getCurrentItem();
                                int cfg_value = cfg.getInt("points." + item.getType().toString().toLowerCase());
                                int points = item.getAmount() * cfg_value;
                                item.setAmount(0);
//                                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> e.getView().getTopInventory().remove(item.getType()), 10L);
                                PointsAPI.addPoints(p.getUniqueId(), points, null);
                                p.sendMessage(Main.getInstance().prefix + "§aDu hast §6" + points + " §aPunkte bekommen!");
                            }
                            default -> e.setCancelled(true);
                        }
                    }
                }
            } else if (e.getAction() == InventoryAction.PLACE_ALL || e.getAction() == InventoryAction.PLACE_ONE || e.getAction() == InventoryAction.PLACE_SOME) {

                if (e.getClickedInventory() != p.getInventory()) {
                    if (e.getCursor() != null) {
                        switch (e.getCursor().getType()) {
                            case IRON_INGOT, GOLD_INGOT, COPPER_INGOT, NETHERITE_INGOT, EMERALD, LAPIS_LAZULI, REDSTONE, COAL, DIAMOND, DRAGON_EGG, SPONGE, BEACON, SHULKER_BOX, TURTLE_EGG, ENDER_PEARL, EXPERIENCE_BOTTLE, NETHER_STAR, SADDLE, NAME_TAG, HEART_OF_THE_SEA, ELYTRA -> {
                                ItemStack item = e.getCursor();
                                int cfg_value = cfg.getInt("points." + item.getType().toString().toLowerCase());
                                int points = item.getAmount() * cfg_value;
                                item.setAmount(0);
//                                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> e.getView().getTopInventory().remove(item.getType()), 1L);
                                PointsAPI.addPoints(p.getUniqueId(), points, null);
                                p.sendMessage(Main.getInstance().prefix + "§aDu hast §6" + points + " §aPunkte bekommen!");
                            }
                            default -> e.setCancelled(true);
                        }
                    }
                }
            }
        }
    }

}
