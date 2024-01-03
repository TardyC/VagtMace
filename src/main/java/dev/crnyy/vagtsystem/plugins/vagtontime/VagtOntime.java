package dev.crnyy.vagtsystem.plugins.vagtontime;

import dev.crnyy.vagtsystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.Utility;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class VagtOntime implements Listener {

    private final Main plugin;
    public VagtOntime(Main plugin) {
        this.plugin = plugin;
    }

    public static Map<UUID, Long> onTimeMap = new HashMap<UUID, Long>();

    @EventHandler
    private void onJoinEvent(PlayerJoinEvent e) {
        final Player player = e.getPlayer();
        if (player.hasPermission("vagt")) {
            if (!onTimeMap.containsKey(player.getUniqueId())) {
                onTimeMap.put(player.getUniqueId(), System.currentTimeMillis());
            }
            new BukkitRunnable() {
                @Override
                public void run() {
                    for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                        updateOnlineTime(player);
                    }
                }
            }.runTaskTimer(plugin, 20L, 20L);
        }
    }

    @Utility
    public void updateOnlineTime(final Player player) {
        if (onTimeMap.containsKey(player.getUniqueId())) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - onTimeMap.get(player.getUniqueId());

            String formattedTime = getString(elapsedTime);
//            player.sendMessage("Din online tid: " + formattedTime);
        }
    }

    @Utility
    public String getString(long elapsedTime) {
        int seconds = (int) (elapsedTime / 1000) % 60;
        int minutes = (int) ((elapsedTime / (1000 * 60)) % 60);
        int hours = (int) ((elapsedTime / (1000 * 60 * 60)) % 24);
        int days = (int) (elapsedTime / (1000 * 60 * 60 * 24));
        return String.format("%d Dage %d Timer %d Minutter %d Sekunder", days, hours, minutes, seconds);
    }

}
