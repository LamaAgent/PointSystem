
package de.lamacraft.pointsystem.commands;

import de.lamacraft.pointsystem.api.PointsAPI;
import de.lamacraft.pointsystem.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PointsCommand implements CommandExecutor, TabCompleter {
    public static String get_perm = "lamacraft.pointsystem.get";
    public static String set_perm = "lamacraft.pointsystem.set";
    public static String add_perm = "lamacraft.pointsystem.add";
    public static String remove_perm = "lamacraft.pointsystem.remove";
    public static String remove_all_perm = "lamacraft.pointsystem.remove_all";
    private static final String prefix = Main.getInstance().prefix;

    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player p = (Player) sender;
            if (args.length == 2) {
                @SuppressWarnings("deprecation")
                final OfflinePlayer target = Bukkit.getOfflinePlayer(args[1]);
                if (args[0].equalsIgnoreCase("get")) {
                    if (p.hasPermission(PointsCommand.get_perm)) {
                        final int points = PointsAPI.getPoints(target.getUniqueId());
                        if (points == -1) {
                           p.sendMessage(prefix + "§cDer Spieler §6" + target.getName() + " §cwar noch nie auf diesem Server!");
                            return true;
                        }
                        p.sendMessage(prefix + "§aDer Spieler §6" + target.getName() + " §abesitzt zurzeit §6" + points + " §aPunkte!");
                    } else {
                        p.sendMessage(prefix + "§cDazu hast keine Rechte!");
                    }
                } else {
                    p.sendMessage(prefix + "§cBitte benutze §6/points <add|set|remove|get> (Spielername) §c!");
                }
            } else if (args.length == 3) {
                @SuppressWarnings("deprecation")
                final OfflinePlayer target = Bukkit.getOfflinePlayer(args[1]);
                if (args[0].equalsIgnoreCase("remove") && args[2].equalsIgnoreCase("all")) {
                    if (p.hasPermission(PointsCommand.remove_all_perm)) {
                        PointsAPI.removePoints(target.getUniqueId(), 0, p, true);
                        p.sendMessage(prefix + "§aDem Spieler §6" + target.getName() + " §awurden erfolgreich alle Punkte entfernt!");
                    } else {
                        p.sendMessage(prefix + "§cDazu hast keine Rechte!");
                    }
                    return true;
                }
                int points;
                try {
                    points = Integer.parseInt(args[2]);
                } catch (NumberFormatException e) {
                    p.sendMessage(prefix + "§cDer Wert muss eine Zahl sein!");
                    return true;
                }
                if (args[0].equalsIgnoreCase("add")) {
                    if (p.hasPermission(PointsCommand.add_perm)) {
                        if (points >= 1) {
                            PointsAPI.addPoints(target.getUniqueId(), points, p);
                        } else {
                            p.sendMessage(prefix + "§cEinem Spieler muss mindestens 1 Punkt hinzugefügt werden!");
                        }
                    } else {

                        p.sendMessage(prefix + "§cDazu hast keine Rechte!");
                    }
                } else if (args[0].equalsIgnoreCase("set")) {
                    if (p.hasPermission(PointsCommand.set_perm)) {
                        if (points > 0 || points == 0) {
                            PointsAPI.setPoints(target.getUniqueId(), points, p);
                        } else {
                            p.sendMessage(prefix + "§cDer Wert muss mindestens 0 sein!");
                        }
                    } else {
                        p.sendMessage(prefix + "§cDazu hast keine Rechte!");
                    }
                } else if (args[0].equalsIgnoreCase("remove")) {
                    if (p.hasPermission(PointsCommand.remove_perm)) {
                        if (points > PointsAPI.getPoints(target.getUniqueId())) {
                            p.sendMessage(prefix + "§cDer Spieler besitzt nicht so viele Punkte!");
                            return true;
                        } else
                            PointsAPI.removePoints(target.getUniqueId(), points, p, false);
                        p.sendMessage(prefix + "§aDem Spieler §6" + target.getName() + " §awurden erfolgreich §6" + points + " §aentfernt!");
                    } else {
                        p.sendMessage(prefix + "§cDazu hast keine Rechte!");
                    }
                } else {
                    p.sendMessage(prefix + "§cBitte benutze §6/points <add|set|remove|get> (Spielername) §c!");
                }
            } else {
                p.sendMessage(prefix + "§cBitte benutze §6/points <add|set|remove|get> (Spielername) §c!");
            }
        } else {
            Bukkit.getConsoleSender().sendMessage(prefix + "§cDieser Command kann nur von einem Spieler ausgeführt werden!");
        }
        return false;
    }

    public List<String> onTabComplete(final CommandSender sender, final Command command, final String label, final String[] args) {
        final ArrayList<String> list = new ArrayList<>();
        if (args.length == 0) {
            return list;
        }
        if (args.length == 1) {
            list.add("add");
            list.add("remove");
            list.add("set");
            list.add("get");
        } else if (args.length == 2) {
            for (final Player players : Bukkit.getOnlinePlayers()) {
                list.add(players.getName());
            }
        } else if (args.length == 3) {
            if (args[0].equalsIgnoreCase("add")) {
                list.add("10");
                list.add("100");
                list.add("1000");
            } else if (args[0].equalsIgnoreCase("remove")) {
                list.add("all");
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
