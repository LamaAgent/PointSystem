package de.lamacraft.pointsystem.listeners;

import de.lamacraft.pointsystem.api.PointsAPI;
import de.lamacraft.pointsystem.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class ClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equalsIgnoreCase("§6SHOP")){



            if(e.getCurrentItem().getType() == Material.DIAMOND_SWORD) {
                if(PointsAPI.getPoints(p.getUniqueId()) >= 100) {
                    PointsAPI.removePoints(p.getUniqueId(), 100, null, false);
                    p.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
                }
            }

            e.setCancelled(true);
        } else if(e.getView().getTopInventory().getType() == InventoryType.CHEST) {
//            && e.getView().getTitle().equalsIgnoreCase("§6SELLING")
            if (e.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY) {
                if(e.getClickedInventory() == p.getInventory()) {
                    if (e.getCurrentItem().getType() == Material.DIAMOND) {
                        ItemStack diamonds = e.getCurrentItem();
                        int points = diamonds.getAmount() * 100;
                        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                e.getView().getTopInventory().clear();
                            }
                        }, 1L);
                        PointsAPI.addPoints(p.getUniqueId(), points, null);
                        p.sendMessage(Main.getInstance().prefix + "§aDu hast §6" + points + " §aPunkte bekommen!");
                    }
                }
            } else if(e.getAction() == InventoryAction.PLACE_ALL || e.getAction() == InventoryAction.PLACE_ONE ||e.getAction() == InventoryAction.PLACE_SOME) {

                if(e.getClickedInventory() != p.getInventory()) {
                    if (e.getCursor().getType() == Material.DIAMOND) {
                        ItemStack diamonds = e.getCursor();
                        int points = diamonds.getAmount() * 100;
                        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                e.getView().getTopInventory().clear();
                            }
                        }, 1L);
                        PointsAPI.addPoints(p.getUniqueId(), points, null);
                        p.sendMessage(Main.getInstance().prefix + "§aDu hast §6" + points + " §aPunkte bekommen!");
                    }
                }
            }
        }
    }

}
