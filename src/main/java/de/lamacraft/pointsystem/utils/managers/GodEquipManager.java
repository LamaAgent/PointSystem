/*
 * Copyright (c) by Lama_Agent (2022).
 * All rights reserved
 */

package de.lamacraft.pointsystem.utils.managers;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GodEquipManager {

    private static final ItemStack netherite_sword = new ItemStack(Material.NETHERITE_SWORD);

    private static final ItemStack netherite_axe = new ItemStack(Material.NETHERITE_AXE);

    private static final ItemStack netherite_pickaxe = new ItemStack(Material.NETHERITE_PICKAXE);


    private static final ItemStack bow = new ItemStack(Material.BOW);


    private static final ItemStack shield = new ItemStack(Material.SHIELD);


    private static final ItemStack netherite_helmet = new ItemStack(Material.NETHERITE_HELMET);

    private static final ItemStack netherite_chestplate = new ItemStack(Material.NETHERITE_CHESTPLATE);

    private static final ItemStack netherite_leggings = new ItemStack(Material.NETHERITE_LEGGINGS);

    private static final ItemStack netherite_boots = new ItemStack(Material.NETHERITE_BOOTS);


    private static final ItemStack arrow = new ItemStack(Material.ARROW);


    public static void applyEnchants() {

        netherite_sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 7);
        netherite_sword.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 5);
        netherite_sword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 4);

        ItemMeta netherite_sword_item_meta = netherite_sword.getItemMeta();
        netherite_sword_item_meta.setUnbreakable(true);
        netherite_sword_item_meta.setDisplayName("§l§4Graf Darryl");
        netherite_sword.setItemMeta(netherite_sword_item_meta);


        netherite_axe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 7);
        netherite_axe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 5);
        netherite_axe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 5);
        netherite_axe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 7);

        ItemMeta netherite_axe_item_meta = netherite_axe.getItemMeta();
        netherite_axe_item_meta.setUnbreakable(true);
        netherite_axe_item_meta.setDisplayName("§l§5Darryl Capacitor");
        netherite_axe.setItemMeta(netherite_axe_item_meta);


        netherite_pickaxe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 5);
        netherite_pickaxe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 7);

        ItemMeta netherite_pickaxe_item_meta = netherite_pickaxe.getItemMeta();
        netherite_pickaxe_item_meta.setUnbreakable(true);
        netherite_pickaxe_item_meta.setDisplayName("§l§8Darryl das Nutztier");
        netherite_pickaxe.setItemMeta(netherite_pickaxe_item_meta);


        bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 10);
        bow.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 10);
        bow.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 10);
        bow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 10);

        ItemMeta bow_item_meta = bow.getItemMeta();
        bow_item_meta.setUnbreakable(true);
        bow.setItemMeta(bow_item_meta);


        ItemMeta shield_item_meta = shield.getItemMeta();
        shield_item_meta.setUnbreakable(true);
        shield.setItemMeta(shield_item_meta);


        netherite_helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
        netherite_helmet.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 10);
        netherite_helmet.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 10);
        netherite_helmet.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 10);
        netherite_helmet.addUnsafeEnchantment(Enchantment.THORNS, 10);

        ItemMeta netherite_helmet_item_meta = netherite_helmet.getItemMeta();
        netherite_helmet_item_meta.setUnbreakable(true);
        netherite_helmet.setItemMeta(netherite_helmet_item_meta);


        netherite_chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
        netherite_chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 10);
        netherite_chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 10);
        netherite_chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 10);
        netherite_chestplate.addUnsafeEnchantment(Enchantment.THORNS, 10);

        ItemMeta netherite_chestplate_item_meta = netherite_chestplate.getItemMeta();
        netherite_chestplate_item_meta.setUnbreakable(true);
        netherite_chestplate.setItemMeta(netherite_chestplate_item_meta);


        netherite_leggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
        netherite_leggings.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 10);
        netherite_leggings.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 10);
        netherite_leggings.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 10);
        netherite_leggings.addUnsafeEnchantment(Enchantment.THORNS, 10);

        ItemMeta netherite_leggings_item_meta = netherite_leggings.getItemMeta();
        netherite_leggings_item_meta.setUnbreakable(true);
        netherite_leggings.setItemMeta(netherite_leggings_item_meta);


        netherite_boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
        netherite_boots.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 10);
        netherite_boots.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 10);
        netherite_boots.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 10);
        netherite_boots.addUnsafeEnchantment(Enchantment.THORNS, 10);
        netherite_boots.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 10);

        ItemMeta netherite_boots_item_meta = netherite_boots.getItemMeta();
        netherite_boots_item_meta.setUnbreakable(true);
        netherite_boots.setItemMeta(netherite_boots_item_meta);


    }

    public static List<ItemStack> getGodItems() {
        applyEnchants();
        List<ItemStack> goditems = new ArrayList<>();

        goditems.add(netherite_sword);
        goditems.add(netherite_axe);
        goditems.add(netherite_pickaxe);

        goditems.add(bow);

        goditems.add(shield);

        goditems.add(netherite_helmet);
        goditems.add(netherite_chestplate);
        goditems.add(netherite_leggings);
        goditems.add(netherite_boots);

        goditems.add(arrow);

        return goditems;
    }
}
