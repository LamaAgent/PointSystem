package de.lamacraft.pointsystem.utils;

import net.minecraft.network.protocol.game.PacketPlayOutSpawnEntityLiving;
import net.minecraft.world.entity.decoration.EntityArmorStand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Hologram {

    private String text;
    private Location loc;
    private EntityArmorStand entity;

    public Hologram(String text, Location loc) {
        this.text = text;
        this.loc = loc;

        entity = new EntityArmorStand(((CraftWorld) loc.getWorld()).getHandle(), loc.getX(), loc.getY(), loc.getZ());
        entity.setInvisible(true);



        show();
    }

    public void show(Player p) {
        PacketPlayOutSpawnEntityLiving packetPlayOutSpawnEntityLiving = new PacketPlayOutSpawnEntityLiving(entity);
        ((CraftPlayer) p).getHandle().a(packetPlayOutSpawnEntityLiving);
    }

    public void show() {
        for(Player all : Bukkit.getOnlinePlayers()) {
            show(all);
        }
    }

    public void hide(Player p) {

        for(Player all : Bukkit.getOnlinePlayers()) {
            hide(all);
        }
    }

    public String getText() {
        return text;
    }

    public Location getLoc() {
        return loc;
    }
}
