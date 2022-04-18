package de.lamacraft.pointsystem.listeners;

import de.lamacraft.pointsystem.api.PointsAPI;
import de.lamacraft.pointsystem.utils.managers.FileManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
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

            switch (dead.getType()) {
                case EVOKER -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.evoker"), null);
                }
                case VINDICATOR -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.vindicator"), null);
                }
                case PILLAGER -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.pillager"), null);
                }
                case RAVAGER -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.ravager"), null);
                }
                case VEX -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.vex"), null);
                }
                case ENDERMITE -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.endermite"), null);
                }
                case GUARDIAN -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.guardian"), null);
                }
                case ELDER_GUARDIAN -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.elder_guardian"), null);
                }
                case SHULKER -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.shulker"), null);
                }
                case HUSK -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.husk"), null);
                }
                case STRAY -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.stray"), null);
                }
                case PHANTOM -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.phantom"), null);
                }
                case BLAZE -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.blaze"), null);
                }
                case CREEPER -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.creeper"), null);
                }
                case GHAST -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.ghast"), null);
                }
                case MAGMA_CUBE -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.magma_cube"), null);
                }
                case SILVERFISH -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.silverfish"), null);
                }
                case SKELETON -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.skeleton"), null);
                }
                case SLIME -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.slime"), null);
                }
                case ZOMBIE -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.zombie"), null);
                }
                case ZOMBIE_VILLAGER -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.zombie_villager"), null);
                }
                case DROWNED -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.drowned"), null);
                }
                case WITHER_SKELETON -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.wither"), null);
                }
                case WITCH -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.witch"), null);
                }
                case HOGLIN -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.hoglin"), null);
                }
                case ZOGLIN -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.zoglin"), null);
                }
                case PIGLIN_BRUTE -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.piglin_brute"), null);
                }
                case CAVE_SPIDER -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.cave_spider"), null);
                }
                case ENDERMAN -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.enderman"), null);
                }
                case PIGLIN -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.piglin"), null);
                }
                case ZOMBIFIED_PIGLIN -> {
                    assert p != null;
                    PointsAPI.addPoints(p.getUniqueId(), cfg.getInt("points.zombified_piglin"), null);
                }
            }
        }
    }

}
