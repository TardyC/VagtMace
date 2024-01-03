package dev.crnyy.vagtsystem.plugins.vagtchat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class VagtChat implements Listener {

    @Deprecated
    @EventHandler
    public void asyncPlayerChatEvent(PlayerChatEvent e) {
        final Player player = e.getPlayer();
        String message = e.getMessage();
        if (player.hasPermission("vagt")) {
            if (!(VagtChatCommand.chatController.contains(player.getUniqueId()))) {
                return;
            }
            e.setCancelled(true);
            for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                if (onlinePlayers.hasPermission("vagt")) {
                    onlinePlayers.sendMessage("§cVagtChat§8: §7" + player.getName() + "§8: §f" + message);
                }
            }
        }

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        final Player player = e.getPlayer();
        if (VagtChatCommand.chatController.contains(player.getUniqueId())) {
            VagtChatCommand.chatController.remove(player.getUniqueId());
        }
    }

}
