package de.lamacraft.pointsystem.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryManager {

    public static void createInventory(Player p) {
        Inventory inv = Bukkit.createInventory(null, 9, "§6SHOP");

        for(ItemStack itemStack : ItemManager.getShowItems()) {
            inv.addItem(itemStack);
        }

        p.openInventory(inv);
    }

}
