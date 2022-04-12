//package de.lamacraft.pointsystem.commands;
//
//import de.lamacraft.pointsystem.api.PointsAPI;
//import de.lamacraft.pointsystem.main.Main;
//import de.lamacraft.pointsystem.utils.Hologram;
//import org.bukkit.Bukkit;
//import org.bukkit.ChatColor;
//import org.bukkit.command.Command;
//import org.bukkit.command.CommandExecutor;
//import org.bukkit.command.CommandSender;
//import org.bukkit.entity.Player;
//
//import java.util.HashMap;
//
//public class HologramCommand implements CommandExecutor {
//
//    public static Hologram hologram = null;
//    public static HashMap<Integer, Hologram> holograms = new HashMap<>();
//
//    @Override
//    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
//
//        if (sender instanceof Player) {
//            Player p = (Player) sender;
//
//            if (args.length >= 2 && args[0].equalsIgnoreCase("create")) {
//                String text = "";
//                text = text + "&6Punkte von &7" + args[1] + " &6:" + " ";
//                text.trim();
//                Hologram holo = new Hologram(p.getLocation(), ChatColor.translateAlternateColorCodes('&', text));
//                holo.spawn();
//                Main.getManager().saveHolo(holo, Main.getManager().getNextID());
//            } else if (args.length >= 3 && args[0].equalsIgnoreCase("addline")) {
//
//                try {
//                    int id = Integer.parseInt(args[1]);
//                    String text = "";
//                    for (int i = 2; i < args.length; i++) {
//                        text = text + args[i] + " ";
//                    }
//                    text.trim();
//                    if (text.contains("%points%")) {
//                        int points = PointsAPI.getPoints(Bukkit.getPlayer(args[3]).getUniqueId());
//                        text = text.replace("%points%", "§6" + Integer.toString(points));
//                        text = text.replace(args[3], "");
//                        text.trim();
//                    }
//                    Main.getManager().addLine(ChatColor.translateAlternateColorCodes('&', text), id);
//                } catch (NumberFormatException e) {
//                    p.sendMessage("§c<ID> muss eine Zahl sein!");
//                }
//
//            } else {
//                p.sendMessage(Main.getInstance().prefix + "§cBitte benutze:");
//                p.sendMessage(Main.getInstance().prefix + "§6/hologram create <Text> <Text> ... §e- §aErstellt ein neues Hologramm");
//                p.sendMessage(Main.getInstance().prefix + "§6/hologram addline <ID> <Text> <Text> ... §e- §aFügt eine neue Zeile hinzu");
//            }
//
//        } else {
//            Bukkit.getConsoleSender().sendMessage("§cDer Command kann nur von einem Spieler ausgeführt werden!");
//            return true;
//        }
//
//        return false;
//    }
//
//}
