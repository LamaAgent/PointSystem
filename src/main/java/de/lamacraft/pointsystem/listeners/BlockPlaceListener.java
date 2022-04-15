package de.lamacraft.pointsystem.listeners;

import de.lamacraft.pointsystem.main.Main;
import de.lamacraft.pointsystem.utils.ItemManager;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.TileState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class BlockPlaceListener implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (e.getItemInHand().isSimilar(ItemManager.getShop_chest())) {
            if (e.getBlock().getType() == Material.CHEST) {
                if (e.getBlock().getState() instanceof TileState) {
                    TileState state = (TileState) e.getBlock().getState();
                    PersistentDataContainer container = state.getPersistentDataContainer();

                    NamespacedKey key = new NamespacedKey(Main.getInstance(), "shop-chests");
                    container.set(key, PersistentDataType.STRING, "chest_shop");

                    state.update();

                    e.getPlayer().sendMessage("§aShop erstellt!");
                }
            }
        }
    }

}
