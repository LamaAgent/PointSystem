/*
 * Copyright (c) by Lama_Agent (2022).
 * All rights reserved
 */

package de.lamacraft.pointsystem.listeners;

import de.lamacraft.pointsystem.utils.managers.FileManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.util.Objects;

public class PlayerLoginListener implements Listener {

    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        Player p = e.getPlayer();

        if (FileManager.getConfigFileConfiguration().getBoolean("maintance")) {
            if (!p.hasPermission("lamacraft.maintance.bypass")) {
                e.disallow(PlayerLoginEvent.Result.KICK_OTHER, "§cDu kannst den Server zurzeit nicht betreten!\n " +
                        "§6Bitte kontaktiere Lama_Agent für weitere Informationen!");
            }
        }
        if (!Objects.requireNonNull(FileManager.getConfigFileConfiguration().getString("winner")).equalsIgnoreCase("")) {
            if (!p.hasPermission("lamacraft.end.bypass")) {
                e.disallow(PlayerLoginEvent.Result.KICK_OTHER, "§bEs gibt einen Gewinner!\n" +
                        "§eBitte kontaktiere Lama_Agent für weitere Informationen!");
            }
        }
    }

}
