/*
 * Copyright (c) by Lama_Agent (2022).
 * All rights reserved
 */

package de.lamacraft.pointsystem.listeners;

import de.lamacraft.pointsystem.api.PointsAPI;
import de.lamacraft.pointsystem.main.Main;
import de.lamacraft.pointsystem.utils.managers.FileManager;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Block block = e.getBlock();
        if (block.getType() == Material.SPAWNER) {
            int points = FileManager.getBlockPointsFileConfiguration().getInt("points.spawner");
            PointsAPI.addPoints(p.getUniqueId(), points, null);
            p.sendMessage(Main.getInstance().prefix + "§aDu hast §6" + points + " §aPunkte bekommen!");
        }
    }

}
