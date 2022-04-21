/*
 * Copyright (c) by Lama_Agent (2022).
 * All rights reserved
 */

package de.lamacraft.pointsystem.utils;

import de.lamacraft.pointsystem.listeners.PlayerDeathListener;
import de.lamacraft.pointsystem.main.Main;
import org.bukkit.Bukkit;

public class KillController {

    static int taskID = -1;

    @SuppressWarnings("deprecation")
    public static void startKillTimer() {
        taskID = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getInstance(), () -> PlayerDeathListener.kills.clear(), 0, 72000);
    }

    public static void stopKillTimer() {
        if (taskID != -1) {
            Bukkit.getScheduler().cancelTask(taskID);
        }
    }

}
