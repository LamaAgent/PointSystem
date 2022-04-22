/*
 * Copyright (c) by Lama_Agent (2022).
 * All rights reserved
 */

package de.lamacraft.pointsystem.listeners;

import de.lamacraft.pointsystem.api.PointsAPI;
import de.lamacraft.pointsystem.main.Main;
import de.lamacraft.pointsystem.utils.managers.InventoryManager;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Sign;
import org.bukkit.block.TileState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.hasBlock()) {
            if (Objects.requireNonNull(e.getClickedBlock()).getType() == Material.CHEST) {
                if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    if (e.getClickedBlock().getState() instanceof TileState state) {

                        PersistentDataContainer container = state.getPersistentDataContainer();

                        NamespacedKey key = new NamespacedKey(Main.getInstance(), "shop-chests");
                        if (container.has(key, PersistentDataType.STRING)) {
                            if ("chest_shop".equalsIgnoreCase(container.get(key, PersistentDataType.STRING))) {
                                e.setCancelled(true);
                                InventoryManager.createShopInventory(p);
                            }
                        }
                    }
                }
            } else if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getState() instanceof Sign clickedSign) {

                String line1 = clickedSign.getLine(0);

                if (line1.equalsIgnoreCase("[CASINO]")) {
                    if (PointsAPI.getPoints(p.getUniqueId()) >= 50000) {
                        PointsAPI.removePoints(p.getUniqueId(), 50000, false);
                        p.performCommand("testcasino");
                    } else {
                        p.sendMessage("§4Du brauchst mindestens §650000 §4Punkte um zu spinnen!");
                        e.setCancelled(true);
                    }
                }
            }
        }
    }


}
