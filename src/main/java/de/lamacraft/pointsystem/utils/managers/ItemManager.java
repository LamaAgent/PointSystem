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

    private static final ItemStack protection_six_book = new ItemStack(Material.ENCHANTED_BOOK);
    private static final ItemStack protection_five_book = new ItemStack(Material.ENCHANTED_BOOK);

    private static final ItemStack fortune_four_book = new ItemStack(Material.ENCHANTED_BOOK);
    private static final ItemStack fortune_five_book = new ItemStack(Material.ENCHANTED_BOOK);

    private static final ItemStack sharpness_six_book = new ItemStack(Material.ENCHANTED_BOOK);
    private static final ItemStack sharpness_seven_book = new ItemStack(Material.ENCHANTED_BOOK);

    private static final ItemStack power_six_book = new ItemStack(Material.ENCHANTED_BOOK);
    private static final ItemStack power_seven_book = new ItemStack(Material.ENCHANTED_BOOK);

    private static final ItemStack unbreaking_four_book = new ItemStack(Material.ENCHANTED_BOOK);
    private static final ItemStack unbreaking_five_book = new ItemStack(Material.ENCHANTED_BOOK);

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

    public static ItemStack getFortune_four_book() {
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) fortune_four_book.getItemMeta();
        meta.addStoredEnchant(Enchantment.LOOT_BONUS_BLOCKS, 4, true);
        fortune_four_book.setItemMeta(meta);
        return fortune_four_book;
    }

    public static ItemStack getFortune_five_book() {
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) fortune_five_book.getItemMeta();
        meta.addStoredEnchant(Enchantment.LOOT_BONUS_BLOCKS, 5, true);
        fortune_five_book.setItemMeta(meta);
        return fortune_five_book;
    }

    public static ItemStack getPower_six_book() {
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) power_six_book.getItemMeta();
        meta.addStoredEnchant(Enchantment.ARROW_DAMAGE, 6, true);
        power_six_book.setItemMeta(meta);
        return power_six_book;
    }

    public static ItemStack getPower_seven_book() {
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) power_seven_book.getItemMeta();
        meta.addStoredEnchant(Enchantment.ARROW_DAMAGE, 7, true);
        power_seven_book.setItemMeta(meta);
        return power_seven_book;
    }

    public static ItemStack getSharpness_six_book() {
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) sharpness_six_book.getItemMeta();
        meta.addStoredEnchant(Enchantment.DAMAGE_ALL, 6, true);
        sharpness_six_book.setItemMeta(meta);
        return sharpness_six_book;
    }

    public static ItemStack getSharpness_seven_book() {
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) sharpness_seven_book.getItemMeta();
        meta.addStoredEnchant(Enchantment.DAMAGE_ALL, 7, true);
        sharpness_seven_book.setItemMeta(meta);
        return sharpness_seven_book;
    }

    public static ItemStack getUnbreaking_four_book() {
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) unbreaking_four_book.getItemMeta();
        meta.addStoredEnchant(Enchantment.DURABILITY, 4, true);
        unbreaking_four_book.setItemMeta(meta);
        return unbreaking_four_book;
    }

    public static ItemStack getUnbreaking_five_book() {
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) unbreaking_five_book.getItemMeta();
        assert meta != null;
        meta.addStoredEnchant(Enchantment.DURABILITY, 5, true);
        unbreaking_five_book.setItemMeta(meta);
        return unbreaking_five_book;
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
        return protection_enchants;
    }

    public static List<ItemStack> getFortuneEnchants() {
        List<ItemStack> fortune_enchants = new ArrayList<>();
        fortune_enchants.add(getFortune_four_book());
        fortune_enchants.add(getFortune_five_book());
        return fortune_enchants;
    }

    public static List<ItemStack> getPowerEnchants() {
        List<ItemStack> power_enchants = new ArrayList<>();
        power_enchants.add(getPower_six_book());
        power_enchants.add(getPower_seven_book());
        return power_enchants;
    }

    public static List<ItemStack> getSharpnessEnchants() {
        List<ItemStack> sharpness_enchants = new ArrayList<>();
        sharpness_enchants.add(getSharpness_six_book());
        sharpness_enchants.add(getSharpness_seven_book());
        return sharpness_enchants;
    }

    public static List<ItemStack> getUnbreakingEnchants() {
        List<ItemStack> unbreaking_enchants = new ArrayList<>();
        unbreaking_enchants.add(getUnbreaking_four_book());
        unbreaking_enchants.add(getUnbreaking_five_book());
        return unbreaking_enchants;
    }

//    public static List<ItemStack> getCasinoItems() {
//        List<ItemStack> items = new ArrayList<>();
//        items.add(new ItemStack(Material.GOLD_INGOT));
//        items.add(new ItemStack(Material.DIAMOND));
//        items.add(new ItemStack(Material.EMERALD));
//        return items;
//    }

    public static ItemStack getShop_chest() {
        ItemMeta meta = shop_chest.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add("Shop_Chest");
        assert meta != null;
        meta.setLore(lore);
        meta.setDisplayName("Shop_Chest");
        shop_chest.setItemMeta(meta);
        return shop_chest;
    }
}
