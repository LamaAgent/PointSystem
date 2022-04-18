package de.lamacraft.pointsystem.listeners;

import de.lamacraft.pointsystem.main.Main;
import de.lamacraft.pointsystem.utils.managers.InventoryManager;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.TileState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

public class InteractListener implements Listener {

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
                                InventoryManager.createInventory(p);
                            }
                        }
                        }
                    }
                }
            }
        }


}
