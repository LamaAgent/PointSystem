//package de.lamacraft.pointsystem.utils;
//
//import org.bukkit.Bukkit;
//import org.bukkit.Location;
//import org.bukkit.World;
//import org.bukkit.configuration.file.FileConfiguration;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//public class HoloManager {
//
//    private static final FileConfiguration config = FileManager.getConfigFileConfiguration();
//
//    private final HashMap<Integer, Hologram> holos = new HashMap<>();
//
//    public HoloManager() {
//        for (int i = 0; i <= config.getInt("id"); i++) {
//            if (config.get("hologram." + i) != null) {
//                List<String> list = config.getStringList("hologram." + i);
//                System.out.println("Loading Hologram ID:" + i);
//                for (String string : list) {
//                    World world = Bukkit.getWorld(string.split(",")[0]);
//                    Double x = Double.valueOf(string.split(",")[1]);
//                    Double y = Double.valueOf(string.split(",")[2]);
//                    Double z = Double.valueOf(string.split(",")[3]);
//                    Location loc = new Location(world, x, y, z);
//                    String text = string.split(":--:")[1];
//
//                    Hologram holo = new Hologram(loc, text.replace("&", "§"));
//                    holos.put(i, holo);
//                    System.out.println("Adding line to Hologram");
//                }
//                System.out.println("Loaded Hologram ID:" + i);
//            }
//        }
//    }
//
//    public void saveHolo(Hologram holo, int id) {
//        String world = holo.getLoc().getWorld().getName();
//        Double x = holo.getLoc().getX();
//        Double y = holo.getLoc().getY();
//        Double z = holo.getLoc().getZ();
//        String text = holo.getText();
//
//        if (config.get("hologram." + id) != null) {
//            List<String> list = config.getStringList("hologram." + id);
//            list.add(world + "," + x + "," + y + "," + z + ",:--:" + text.replace("§", "&"));
//            config.set("hologram." + id, list);
//        } else {
//            List<String> list = new ArrayList<>();
//            list.add(world + "," + x + "," + y + "," + z + ",:--:" + text.replace("§", "&"));
//            config.set("hologram." + id, list);
//            config.set("id", getNextID() + 1);
//        }
//        try {
//            config.save(FileManager.getConfigFile());
//            holos.put(id, holo);
//            System.out.println("SHOULD BE PUTTED!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void addLine(String text, int id) {
//        List<String> list = config.getStringList("hologram." + id);
//        String string = list.get(list.size() - 1);
//        World world = Bukkit.getWorld(string.split(",")[0]);
//        double x = Double.parseDouble(string.split(",")[1]);
//        double y = Double.parseDouble(string.split(",")[2]) - 0.25D;
//        double z = Double.parseDouble(string.split(",")[3]);
//        Location loc = new Location(world, x, y, z);
//        Hologram holo = new Hologram(loc, text);
//        holo.spawn();
//        saveHolo(holo, id);
//    }
//
//    public int getNextID() {
//        return config.getInt("id");
//    }
//
//    public void spawnAllHolos() {
//        for (Hologram holo : holos.values()) {
//            holo.spawn();
//        }
//    }
//
//    public void removeAllHolos() {
//        System.out.println("Anzahl holos: " + holos.size());
//        for (Hologram holo : holos.values()) {
//            holo.Hologram = holo.getHologram();
//            holo.remove();
//            System.out.println("DEBUG!!!!");
//        }
//
//    }
//}
