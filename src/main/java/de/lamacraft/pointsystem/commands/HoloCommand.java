package de.lamacraft.pointsystem.commands;

import de.lamacraft.pointsystem.utils.FileManager;
import de.lamacraft.pointsystem.utils.HologramManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.List;

public class HoloCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p) {
            if(args.length >= 2 && args[0].equalsIgnoreCase("create")) {
                StringBuilder text = new StringBuilder();
                for(int i = 1; i<args.length; i++) {
                    text.append(args[i]).append(" ");
                }
                String final_text = text.toString().trim();
                ArmorStand holo = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
                holo.setVisible(false);
                holo.setCustomNameVisible(true);
                holo.setCustomName(ChatColor.RED + final_text);
                holo.setGravity(false);
                HologramManager.saveHolo(holo, HologramManager.getNextID(), holo.getEntityId());
                p.sendMessage("§aHolo created!");
            } else if(args.length == 2 && args[0].equalsIgnoreCase("remove")) {
                int id = Integer.parseInt(args[1]);
                if(FileManager.getConfigFileConfiguration().get("hologram." + id) != null) {
                    List<String> list = FileManager.getConfigFileConfiguration().getStringList("hologram." + id);
                    String string = list.get(list.size()-1);
                    String entityID = string.split(",") [4];
                    String text = string.split(":--:") [1];
                    for(Entity entity : p.getWorld().getEntities()) {
                        if(entity instanceof ArmorStand) {
                            if(entity.getCustomName() != null) {
                                if(entity.getEntityId() == Integer.parseInt(entityID)) {
                                    entity.remove();
                                    FileManager.getConfigFileConfiguration().set("hologram." + id, null);
                                    FileManager.getConfigFileConfiguration().set("id", 0);
                                    try {
                                        FileManager.getConfigFileConfiguration().save(FileManager.getConfigFile());
                                        p.sendMessage("File should be saved!");
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    p.sendMessage("§aHolo removed!");

                                }

                            }
                        }
                    }
                } else
                    p.sendMessage("§cDieses Hologramm gibt es nicht!");

            } else
                p.sendMessage("§cBitte benutze §6/holo <create|remove> (ID) §c!");
        } else
            Bukkit.getConsoleSender().sendMessage("§cDieser Command kann nur von einem Spieler ausgeführt werden!");

        return false;
    }
}
