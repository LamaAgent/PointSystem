package de.lamacraft.pointsystem.listeners;

import de.lamacraft.pointsystem.utils.FileManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class PingListener implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent e) {
        if (!FileManager.getConfigFileConfiguration().getBoolean("maintance")) {
            e.setMaxPlayers(10);
            e.setMotd("\u0020\u0020\u0020\u0020\u0020§dViel Spaß beim K\u00e4mpfen um die meisten Punkte!\n" +
                    "\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020§eMöge der oder die Beste gewinnen!");
        } else {
            e.setMaxPlayers(0);
            e.setMotd("§4Du kannst dem Server zurzeit nicht joinen!");
        }
    }

}
