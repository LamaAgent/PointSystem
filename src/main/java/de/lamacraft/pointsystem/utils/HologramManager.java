package de.lamacraft.pointsystem.utils;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.ArmorStand;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HologramManager {

    static FileConfiguration cfg = FileManager.getConfigFileConfiguration();

    public static void saveHolo(ArmorStand holo, int id, int entityID) {

        String path = "hologram." + id;

        Location loc = holo.getLocation();
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();
        String world = loc.getWorld().getName();
        String name = holo.getCustomName();


        String data = world + "," + x + "," + y + "," + z + "," + entityID + "," + ":--:" + name;

        if (cfg.get(path) != null) {
            List<String> list = cfg.getStringList(path);
            list.add(data);
            cfg.set(path, list);
        } else {
            List<String> list = new ArrayList<>();
            list.add(data);
            cfg.set(path, list);
            cfg.set("id", getNextID() + 1);
        }
        try {
            cfg.save(FileManager.getConfigFile());
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


}
