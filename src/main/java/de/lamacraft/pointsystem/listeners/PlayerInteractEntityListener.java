/*
 * Copyright (c) by Lama_Agent (2022).
 * All rights reserved
 */

package de.lamacraft.pointsystem.listeners;

import de.lamacraft.pointsystem.commands.TestCasinoCommand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class PlayerInteractEntityListener implements Listener {

    @EventHandler
    public void onInteractEntity(PlayerInteractEntityEvent e) {

        Entity entity = e.getRightClicked();

        if (entity instanceof ItemFrame) {
            if (entity.getLocation().equals(TestCasinoCommand.loc1) || entity.getLocation().equals(TestCasinoCommand.loc2) || entity.getLocation().equals(TestCasinoCommand.loc3)) {
                e.setCancelled(true);
            }
        }

    }

}
