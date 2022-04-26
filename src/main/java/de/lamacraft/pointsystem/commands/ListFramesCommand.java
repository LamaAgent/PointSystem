/*
 * Copyright (c) by Lama_Agent (2022).
 * All rights reserved
 */

package de.lamacraft.pointsystem.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;

public class ListFramesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p) {
            for (Entity nearbyEntity : p.getNearbyEntities(5, 5, 5)) {
                if (nearbyEntity instanceof ItemFrame) {
                    p.sendMessage("Location of:" + nearbyEntity.getLocation());
                }
            }
        }

        return false;
    }
}
