/*
 * Copyright (c) by Lama_Agent (2022).
 * All rights reserved
 */

package de.lamacraft.pointsystem.listeners;

import de.lamacraft.pointsystem.utils.managers.ItemManager;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

public class PrepareAnvilListener implements Listener {

    @EventHandler
    public void onAnvilPrepare(PrepareAnvilEvent e) {
        AnvilInventory inventory = e.getInventory();

        ItemStack slot1 = inventory.getItem(0);

        ItemStack slot2 = inventory.getItem(1);

        if (slot1 != null && slot2 != null) {

            if (isArmor(slot1)) {


                for (ItemStack enchantment_book : ItemManager.getProtectionEnchants()) {
                    if (slot2.isSimilar(enchantment_book)) {

                        EnchantmentStorageMeta esm = (EnchantmentStorageMeta) enchantment_book.getItemMeta();
                        if (esm != null) {
                            int level = esm.getStoredEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL);

                            ItemStack result_item = new ItemStack(slot1.getType());
                            result_item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, level);
                            e.setResult(result_item);

                        }
                    }
                }
                for (ItemStack enchantment_book : ItemManager.getFortuneEnchants()) {
                    if (slot2.isSimilar(enchantment_book)) {
                        EnchantmentStorageMeta esm = (EnchantmentStorageMeta) enchantment_book.getItemMeta();
                        if (esm != null) {
                            int level = esm.getStoredEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS);
                            ItemStack result_item = new ItemStack(slot1.getType());
                            result_item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, level);
                            e.setResult(result_item);
                        }
                    }
                }
                for (ItemStack enchantment_book : ItemManager.getPowerEnchants()) {
                    if (slot2.isSimilar(enchantment_book)) {
                        EnchantmentStorageMeta esm = (EnchantmentStorageMeta) enchantment_book.getItemMeta();
                        if (esm != null) {
                            int level = esm.getStoredEnchantLevel(Enchantment.ARROW_DAMAGE);
                            ItemStack result_item = new ItemStack(slot1.getType());
                            result_item.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, level);
                            e.setResult(result_item);
                        }
                    }
                }
                for (ItemStack enchantment_book : ItemManager.getSharpnessEnchants()) {
                    if (slot2.isSimilar(enchantment_book)) {
                        EnchantmentStorageMeta esm = (EnchantmentStorageMeta) enchantment_book.getItemMeta();
                        if (esm != null) {
                            int level = esm.getStoredEnchantLevel(Enchantment.DAMAGE_ALL);
                            ItemStack result_item = new ItemStack(slot1.getType());
                            result_item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, level);
                            e.setResult(result_item);
                        }
                    }
                }
                for (ItemStack enchantment_book : ItemManager.getUnbreakingEnchants()) {
                    if (slot2.isSimilar(enchantment_book)) {
                        EnchantmentStorageMeta esm = (EnchantmentStorageMeta) enchantment_book.getItemMeta();
                        if (esm != null) {
                            int level = esm.getStoredEnchantLevel(Enchantment.DURABILITY);
                            ItemStack result_item = new ItemStack(slot1.getType());
                            result_item.addUnsafeEnchantment(Enchantment.DURABILITY, level);
                            e.setResult(result_item);
                        }
                    }
                }
            }
        }
    }

    private boolean isArmor(final ItemStack itemStack) {
        if (itemStack == null)
            return false;
        final String typeNameString = itemStack.getType().name();
        return typeNameString.endsWith("_HELMET")
                || typeNameString.endsWith("_CHESTPLATE")
                || typeNameString.endsWith("_LEGGINGS")
                || typeNameString.endsWith("_BOOTS");
    }

}
