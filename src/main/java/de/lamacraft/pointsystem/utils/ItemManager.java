package de.lamacraft.pointsystem.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    private static final ItemStack golden_apple_show = new ItemStack(Material.GOLDEN_APPLE);
    private static final ItemStack golden_carrot_show = new ItemStack(Material.GOLDEN_CARROT);
    private static final ItemStack ender_pearl_show = new ItemStack(Material.ENDER_PEARL);
    private static final ItemStack diamond_sword_show = new ItemStack(Material.DIAMOND_SWORD);
    private static final ItemStack diamond_pickaxe_show = new ItemStack(Material.DIAMOND_PICKAXE);
    private static final ItemStack god_sword_show = new ItemStack(Material.NETHERITE_SWORD);

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
