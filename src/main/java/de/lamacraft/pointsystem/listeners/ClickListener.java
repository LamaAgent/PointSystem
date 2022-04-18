package de.lamacraft.pointsystem.listeners;

import de.lamacraft.pointsystem.api.PointsAPI;
import de.lamacraft.pointsystem.main.Main;
import de.lamacraft.pointsystem.utils.ItemManager;
import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class ClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("§6SHOP")) {

            for (ItemStack item : ItemManager.getShowItems()) {
                if (Objects.requireNonNull(e.getCurrentItem()).isSimilar(item)) {
                    if (PointsAPI.getPoints(p.getUniqueId()) >= 1000) {
                        PointsAPI.removePoints(p.getUniqueId(), 1000, null, false);
                        p.getInventory().addItem(item);
                        String itemType = item.getType().toString();
                        String output = WordUtils.capitalizeFully(itemType.replace("_", " "));
                        p.sendMessage("§aDu hast dir erfolgreich ein/e/en §6" + output + " §agekauft!");
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                        e.setCancelled(true);
                    }
                }
            }


            if (e.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY) {
                if (e.getClickedInventory() == p.getInventory()) {
                    if (Objects.requireNonNull(e.getCurrentItem()).getType() == Material.DIAMOND) {
                        ItemStack diamonds = e.getCurrentItem();
                        int points = diamonds.getAmount() * 100;
                        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> e.getView().getTopInventory().remove(Material.DIAMOND), 1L);
                        PointsAPI.addPoints(p.getUniqueId(), points, null);
                        p.sendMessage(Main.getInstance().prefix + "§aDu hast §6" + points + " §aPunkte bekommen!");
                    }
                }
            } else if (e.getAction() == InventoryAction.PLACE_ALL || e.getAction() == InventoryAction.PLACE_ONE || e.getAction() == InventoryAction.PLACE_SOME) {

                if (e.getClickedInventory() != p.getInventory()) {
                    if (Objects.requireNonNull(e.getCursor()).getType() == Material.DIAMOND) {
                        ItemStack diamonds = e.getCursor();
                        int points = diamonds.getAmount() * 100;
                        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> e.getView().getTopInventory().clear(), 1L);
                        PointsAPI.addPoints(p.getUniqueId(), points, null);
                        p.sendMessage(Main.getInstance().prefix + "§aDu hast §6" + points + " §aPunkte bekommen!");
                    }
                }
            }
        }
    }

}
