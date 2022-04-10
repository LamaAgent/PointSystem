package de.lamacraft.pointsystem.listeners;

import de.lamacraft.pointsystem.api.PointsAPI;
import de.lamacraft.pointsystem.utils.FileManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EnemyKillListener implements Listener {

    @EventHandler
    public void onEnemyKill(EntityDeathEvent e) {
        Entity dead = e.getEntity();
        Player p = e.getEntity().getKiller();
        if (e.getEntity().getKiller() != null) {

            FileConfiguration cfg = FileManager.getMobPointsFileConfiguration();

            if (dead.getType() == EntityType.EVOKER) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.evoker"), null);
            }

            if (dead.getType() == EntityType.VINDICATOR) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.vindicator"), null);
            }

            if (dead.getType() == EntityType.PILLAGER) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.pillager"), null);
            }

            if (dead.getType() == EntityType.RAVAGER) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.ravager"), null);
            }

            if (dead.getType() == EntityType.VEX) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.vex"), null);
            }

            if (dead.getType() == EntityType.ENDERMITE) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.endermite"), null);
            }

            if (dead.getType() == EntityType.GUARDIAN) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.guardian"), null);
            }

            if (dead.getType() == EntityType.ELDER_GUARDIAN) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.elder_guardian"), null);
            }

            if (dead.getType() == EntityType.SHULKER) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.shulker"), null);
            }

            if (dead.getType() == EntityType.HUSK) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.husk"), null);
            }

            if (dead.getType() == EntityType.STRAY) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.stray"), null);
            }

            if (dead.getType() == EntityType.PHANTOM) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.phantom"), null);
            }

            if (dead.getType() == EntityType.BLAZE) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.blaze"), null);
            }

            if (dead.getType() == EntityType.CREEPER) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.creeper"), null);
            }

            if (dead.getType() == EntityType.GHAST) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.ghast"), null);
            }

            if (dead.getType() == EntityType.MAGMA_CUBE) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.magma_cube"), null);
            }

            if (dead.getType() == EntityType.SILVERFISH) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.silverfish"), null);
            }

            if (dead.getType() == EntityType.SKELETON) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.skeleton"), null);
            }

            if (dead.getType() == EntityType.SLIME) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.slime"), null);
            }

            if (dead.getType() == EntityType.ZOMBIE) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.zombie"), null);
            }

            if (dead.getType() == EntityType.ZOMBIE_VILLAGER) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.zombie_villager"), null);
            }

            if (dead.getType() == EntityType.DROWNED) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.drowned"), null);
            }

            if (dead.getType() == EntityType.WITHER_SKELETON) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.wither"), null);
            }

            if (dead.getType() == EntityType.WITCH) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.witch"), null);
            }

            if (dead.getType() == EntityType.HOGLIN) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.hoglin"), null);
            }

            if (dead.getType() == EntityType.ZOGLIN) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.zoglin"), null);
            }

            if (dead.getType() == EntityType.PIGLIN_BRUTE) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.piglin_brute"), null);
            }

            if (dead.getType() == EntityType.CAVE_SPIDER) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.cave_spider"), null);
            }

            if (dead.getType() == EntityType.ENDERMAN) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.enderman"), null);
            }

            if (dead.getType() == EntityType.PIGLIN) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.piglin"), null);
            }

            if (dead.getType() == EntityType.ZOMBIFIED_PIGLIN) {
                PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.zombified_piglin"), null);
            }
        }
    }

}
