/*
 * Copyright (c) by Lama_Agent (2022).
 * All rights reserved
 */

package de.lamacraft.pointsystem.utils.managers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class InventoryManager {

    public static void createShopInventory(Player p) {
        Inventory inv = Bukkit.createInventory(null, 9, "§6SHOP");

        for (ItemStack itemStack : ItemManager.getShowItems()) {
            inv.addItem(itemStack);
        }

        p.openInventory(inv);
    }

    public static Inventory getCasinoInventory() {
        Inventory inv = Bukkit.createInventory(null, 9, "CASINO");
        ItemStack glass = new ItemStack(Material.BLACK_STAINED_GLASS);
        inv.setItem(0, glass);
        inv.setItem(1, glass);
        inv.setItem(2, glass);
        inv.setItem(6, glass);
        inv.setItem(7, glass);
        inv.setItem(8, glass);
        for (int i = 3; i <= 5; i++) {

            List<ItemStack> casino_items = GodEquipManager.getGodItems();

            int max = casino_items.size();

            int min = 0;

            int random_int = (int) Math.floor(Math.random() * (max - min) + min);

            inv.setItem(i, casino_items.get(random_int));

        }
        return inv;
    }

}
