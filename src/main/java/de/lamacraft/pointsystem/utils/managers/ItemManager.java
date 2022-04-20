/*
 * Copyright (c) by Lama_Agent (2022).
 * All rights reserved
 */

package de.lamacraft.pointsystem.utils.managers;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemManager {

    private static final ItemStack golden_apple_show = new ItemStack(Material.GOLDEN_APPLE);
    private static final ItemStack golden_carrot_show = new ItemStack(Material.GOLDEN_CARROT);
    private static final ItemStack ender_pearl_show = new ItemStack(Material.ENDER_PEARL);
    private static final ItemStack diamond_sword_show = new ItemStack(Material.DIAMOND_SWORD);
    private static final ItemStack diamond_pickaxe_show = new ItemStack(Material.DIAMOND_PICKAXE);
    private static final ItemStack god_sword_show = new ItemStack(Material.NETHERITE_SWORD);

    private static final ItemStack protection_seven_book = new ItemStack(Material.ENCHANTED_BOOK);
    private static final ItemStack protection_six_book = new ItemStack(Material.ENCHANTED_BOOK);
    private static final ItemStack protection_five_book = new ItemStack(Material.ENCHANTED_BOOK);

    private static final ItemStack shop_chest = new ItemStack(Material.CHEST);

    public static ItemStack getGolden_apple_show() {
        ItemMeta meta = golden_apple_show.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_GREEN + "Kosten: 1000 Punkte");
        meta.setLore(lore);
        golden_apple_show.setItemMeta(meta);
        return golden_apple_show;
    }

    public static ItemStack getGolden_carrot_show() {
        ItemMeta meta = golden_carrot_show.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_GREEN + "Kosten: 1000 Punkte");
        meta.setLore(lore);
        golden_carrot_show.setItemMeta(meta);
        return golden_carrot_show;
    }

    public static ItemStack getEnder_pearl_show() {
        ItemMeta meta = ender_pearl_show.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_GREEN + "Kosten: 1000 Punkte");
        meta.setLore(lore);
        ender_pearl_show.setItemMeta(meta);
        return ender_pearl_show;
    }

    public static ItemStack getDiamond_sword_show() {
        ItemMeta meta = diamond_sword_show.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_GREEN + "Kosten: 1000 Punkte");
        meta.setLore(lore);
        diamond_sword_show.setItemMeta(meta);
        return diamond_sword_show;
    }

    public static ItemStack getDiamond_pickaxe_show() {
        ItemMeta meta = diamond_pickaxe_show.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_GREEN + "Kosten: 1000 Punkte");
        meta.setLore(lore);
        diamond_pickaxe_show.setItemMeta(meta);
        return diamond_pickaxe_show;
    }

    public static ItemStack getGod_sword_show() {
        ItemMeta meta = god_sword_show.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_GREEN + "Kosten: 1000 Punkte");
        meta.setLore(lore);
        god_sword_show.setItemMeta(meta);
        return god_sword_show;
    }

    public static ItemStack getProtection_seven_book() {
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) protection_seven_book.getItemMeta();
        Objects.requireNonNull(meta).addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
        protection_seven_book.setItemMeta(meta);
        return protection_seven_book;
    }

    public static ItemStack getProtection_six_book() {
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) protection_six_book.getItemMeta();
        Objects.requireNonNull(meta).addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true);
        protection_six_book.setItemMeta(meta);
        return protection_six_book;
    }

    public static ItemStack getProtection_five_book() {
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) protection_five_book.getItemMeta();
        Objects.requireNonNull(meta).addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        protection_five_book.setItemMeta(meta);
        return protection_five_book;
    }

    public static List<ItemStack> getShowItems() {
        List<ItemStack> show_items = new ArrayList<>();
        show_items.add(getGolden_apple_show());
        show_items.add(getGolden_carrot_show());
        show_items.add(getEnder_pearl_show());
        show_items.add(getDiamond_sword_show());
        show_items.add(getDiamond_pickaxe_show());
        show_items.add(getGod_sword_show());
        return show_items;
    }

    public static List<ItemStack> getProtectionEnchants() {
        List<ItemStack> protection_enchants = new ArrayList<>();
        protection_enchants.add(getProtection_five_book());
        protection_enchants.add(getProtection_six_book());
        protection_enchants.add(getProtection_seven_book());
        return protection_enchants;
    }

    public static ItemStack getShop_chest() {
        ItemMeta meta = shop_chest.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add("Shop_Chest");
        meta.setLore(lore);
        meta.setDisplayName("Shop_Chest");
        shop_chest.setItemMeta(meta);
        return shop_chest;
    }
}
