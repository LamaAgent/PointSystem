package de.lamacraft.pointsystem.utils;

import de.lamacraft.pointsystem.api.PointsAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardManager {

    public static void updateScoreboard(Player p) {
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective("aaa", "bbb", "§8<<< §6" + p.getName() + " §8>>>");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score score = obj.getScore(ChatColor.AQUA + "Punkte: " + ChatColor.DARK_AQUA + PointsAPI.getPoints(p.getUniqueId()));
        score.setScore(1);
        Score score2 = obj.getScore(ChatColor.BLUE + "=-=-=-=-=-=-=-=-=-=-=");
        score2.setScore(0);
        Score score3 = obj.getScore(ChatColor.BLUE + "-=-=-=-=-=-=-=-=-=-=-");
        score3.setScore(2);
        p.setScoreboard(board);
    }

}
