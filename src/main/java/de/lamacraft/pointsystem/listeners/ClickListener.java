package de.lamacraft.pointsystem.listeners;

import de.lamacraft.pointsystem.api.PointsAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if(e.getView().getTitle().equalsIgnoreCase("§6SHOP")){

            Player p = (Player) e.getWhoClicked();

            if(e.getCurrentItem().getType() == Material.DIAMOND_SWORD) {
                if(PointsAPI.getPoints(p.getUniqueId()) >= 100) {
                    PointsAPI.removePoints(p.getUniqueId(), 100, null, false);
                    p.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
                }
            }

            e.setCancelled(true);
        }
    }

}
