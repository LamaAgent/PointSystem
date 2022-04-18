/*
 * Copyright (c) by Lama_Agent (2022).
 * All rights reserved
 */

package de.lamacraft.pointsystem.utils.managers;

import de.lamacraft.pointsystem.api.PointsAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.util.Objects;

public class ScoreboardManager {

    public static void updateScoreboard(Player p) {
        Scoreboard board = Objects.requireNonNull(Bukkit.getScoreboardManager()).getNewScoreboard();
        Objective obj = board.registerNewObjective("aaa", "bbb", "§8<<< §6" + p.getName() + " §8>>>");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score score = obj.getScore(ChatColor.BLUE + "=-=-=-=-=-=-=-=-=-=-=");
        score.setScore(0);
        Score score2 = obj.getScore(ChatColor.AQUA + "Punkte: " + ChatColor.DARK_AQUA + PointsAPI.getPoints(p.getUniqueId()));
        score2.setScore(1);
        Score score3 = obj.getScore(ChatColor.BLUE + "-=-=-=-=-=-=-=-=-=-=-");
        score3.setScore(2);
        p.setScoreboard(board);
    }

}
