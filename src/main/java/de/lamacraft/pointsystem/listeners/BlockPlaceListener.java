//package de.lamacraft.pointsystem.listeners;
//
//import de.lamacraft.pointsystem.utils.FileManager;
//import de.lamacraft.pointsystem.utils.ItemManager;
//import org.bukkit.entity.Player;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.Listener;
//import org.bukkit.event.block.BlockPlaceEvent;
//
//import java.util.List;
//
//public class BlockPlaceListener implements Listener {
//
//    @EventHandler
//    public void onBlockPlace(BlockPlaceEvent e) {
//        Player p = e.getPlayer();
//        if(e.getItemInHand() == ItemManager.getShop_chest()) {
//            FileManager.getConfigFileConfiguration().set();
//        }
//    }
//
//}
