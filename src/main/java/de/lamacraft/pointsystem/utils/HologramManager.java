package de.lamacraft.pointsystem.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HologramManager {

    public static FileConfiguration cfg = FileManager.getHologramsFileConfiguration();

    public static void saveHolo(ArmorStand holo, int id, int entityID) {

        String path = "hologram." + id;

        Location loc = holo.getLocation();
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();
        String world = loc.getWorld().getName();
        String name = holo.getCustomName();


        String data = world + "," + x + "," + y + "," + z + "," + entityID + "," + ":--:" + name;

            List<String> list = new ArrayList<>();
            list.add(data);
            cfg.set(path, list);
            cfg.set("id", getNextID() + 1);
        try {
            cfg.save(FileManager.getHologramsFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getNextID() {

        return cfg.getInt("id");

    }

    public static void removeHolo(ArmorStand holo) {
        holo.remove();
    }


    public static void spawnHolos() {
        for (int i = cfg.getInt("id") - 1; i >= 0; i--) {
            if (cfg.get("hologram." + i) != null) {
                List<String> list = cfg.getStringList("hologram." + i);
                if (!(list.size() <= 0)) {
                    String data = list.get(list.size() - 1);
                    World world = Bukkit.getWorld(data.split(",")[0]);
                    double x = Double.parseDouble(data.split(",")[1]);
                    double y = Double.parseDouble(data.split(",")[2]);
                    double z = Double.parseDouble(data.split(",")[3]);
                    String text = data.split(":--:")[1];
                    Location loc = new Location(world, x, y, z);

                    ArmorStand holo = (ArmorStand) Objects.requireNonNull(Bukkit.getServer().getWorld("world")).spawnEntity(loc, EntityType.ARMOR_STAND);
                    holo.setGravity(false);
                    holo.setCustomName(text);
                    holo.setCustomNameVisible(true);
                    holo.setVisible(false);

                    int entityID = holo.getEntityId();
                    String new_data = world.getName() + "," + x + "," + y + "," + z + "," + entityID + "," + ":--:" + text;
                    List<String> new_list = new ArrayList<>();
                    new_list.add(new_data);
                    cfg.set("hologram." + i, new_list);
                    try {
                        cfg.save(FileManager.getHologramsFile());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static List<List<String>> getHolos() {
        List<List<String>> holo_list = new ArrayList<>();

        for (int i = cfg.getInt("id") - 1; i >= 0; i--) {
            if (cfg.get("hologram." + i) != null) {
                List<String> single_data_list = cfg.getStringList("hologram." + i);
                holo_list.add(single_data_list);
            }
        }

        return holo_list;
    }

    public static void despawnAllHolos(World world) {
        for (List<String> list : getHolos()) {
            if (!(list.size() <= 0)) {
                String data = list.get(list.size() - 1);
                int entityID = Integer.parseInt(data.split(",")[4]);
                for (Entity entity : world.getEntities()) {
                    if (entity.getEntityId() == entityID) {
                        entity.remove();
                    }
                }
            }
        }
    }

}
