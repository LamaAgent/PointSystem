package de.lamacraft.pointsystem.utils;

import de.lamacraft.pointsystem.listeners.DeathListener;
import de.lamacraft.pointsystem.main.Main;
import org.bukkit.Bukkit;

public class KillController {

    static int taskID = -1;

    @SuppressWarnings("deprecation")
    public static void startKillTimer() {
        taskID = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getInstance(), () -> DeathListener.kills.clear(), 0, 72000);
    }

    public static void stopKillTimer() {
        if (taskID != -1) {
            Bukkit.getScheduler().cancelTask(taskID);
        }
    }

}
