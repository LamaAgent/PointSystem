package de.lamacraft.pointsystem.commands;

import de.lamacraft.pointsystem.utils.FileManager;
import de.lamacraft.pointsystem.utils.HologramManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HoloCommand implements CommandExecutor, TabCompleter {

    private static FileConfiguration cfg = FileManager.getConfigFileConfiguration();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p) {
            if (args.length >= 2 && args[0].equalsIgnoreCase("create")) {
                StringBuilder text = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    text.append(args[i]).append(" ");
                }
                String final_text = text.toString().trim();
                ArmorStand holo = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
                holo.setVisible(false);
                holo.setCustomNameVisible(true);
                holo.setCustomName(ChatColor.RED + final_text);
                holo.setGravity(false);

                HologramManager.cfg = FileManager.getConfigFileConfiguration();
                HologramManager.saveHolo(holo, HologramManager.getNextID(), holo.getEntityId());
                p.sendMessage("§aHolo created!");
                cfg = FileManager.getConfigFileConfiguration();
                return false;
            } else if (args.length == 2 && args[0].equalsIgnoreCase("remove")) {

                int id;
                try {
                    id = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    p.sendMessage("§c(ID) muss eine Zahl sein!");
                    return true;
                }
                if (cfg.get("hologram." + id) != null) {
                    List<String> list = cfg.getStringList("hologram." + id);
                    if (!(list.size() <= 0)) {
                        String string = list.get(list.size() - 1);
                        String entityID = string.split(",")[4];
                        for (Entity entity : p.getWorld().getEntities()) {
                            if (entity instanceof ArmorStand) {
                                if (entity.getCustomName() != null) {
                                    if (entity.getEntityId() == Integer.parseInt(entityID)) {
                                        entity.remove();
                                        cfg.set("hologram." + id, null);
                                        try {
                                            cfg.save(FileManager.getConfigFile());
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        p.sendMessage("§aHolo removed!");
                                        HologramManager.cfg = FileManager.getConfigFileConfiguration();
                                        cfg = FileManager.getConfigFileConfiguration();
                                        return false;
                                    }
                                }
                            }
                        }
                    } else {
                        p.sendMessage("§4FEHLER!");
                        return true;
                    }
                } else {
                    p.sendMessage("§cDieses Hologramm gibt es nicht!");
                    return true;
                }


            } else if (args.length == 3 && args[0].equalsIgnoreCase("addline")) {

                int id;
                try {
                    id = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    p.sendMessage("§c(ID) muss eine Zahl sein!");
                    return true;
                }
                if (cfg.get("hologram." + id) != null) {
                    List<String> list = cfg.getStringList("hologram." + id);
                    if (!(list.size() <= 0)) {
                        String data = list.get(list.size() - 1);
                        World world = Bukkit.getWorld(data.split(",")[0]);
                        double x = Double.parseDouble(data.split(",")[1]);
                        double y = Double.parseDouble(data.split(",")[2]);
                        double z = Double.parseDouble(data.split(",")[3]);
                        Location loc = new Location(world, x, y - 0.25D, z);

                        ArmorStand holo = (ArmorStand) p.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
                        holo.setVisible(false);
                        holo.setCustomNameVisible(true);
                        holo.setCustomName(ChatColor.BLUE + args[2]);
                        holo.setGravity(false);

                        int entityID = holo.getEntityId();


                        HologramManager.saveHolo(holo, HologramManager.getNextID(), entityID);
                        HologramManager.cfg = FileManager.getConfigFileConfiguration();
                        cfg = FileManager.getConfigFileConfiguration();
                        p.sendMessage("§aLine added!");
                    }
                } else {
                    p.sendMessage("§cEs gibt kein Hologramm mit dieser ID!");
                    return true;
                }

            } else {
                p.sendMessage("§cBitte benutze §6/holo <create|remove> (ID) §c!");
                return true;
            }
        } else {
            Bukkit.getConsoleSender().sendMessage("§cDieser Command kann nur von einem Spieler ausgeführt werden!");
            return true;
        }

        return false;
    }

    public List<String> onTabComplete(final CommandSender sender, final Command command, final String label, final String[] args) {
        final ArrayList<String> list = new ArrayList<>();
        if (args.length == 0) {
            return list;
        }
        if (args.length == 1) {
            list.add("create");
            list.add("remove");
            list.add("addline");
        } else if (args.length == 2) {
            if (args[0].equalsIgnoreCase("remove")) {

                for (int i = cfg.getInt("id") - 1; i >= 0; i--) {
                    if (cfg.get("hologram." + i) != null) {
                        list.add(Integer.toString(i));
                    }
                }

            }
        }
        final ArrayList<String> completerlist = new ArrayList<>();
        final String currentarg = args[args.length - 1];
        for (final String s : list) {
            if (s.startsWith(currentarg)) {
                completerlist.add(s);
            }
        }
        return completerlist;
    }
}
