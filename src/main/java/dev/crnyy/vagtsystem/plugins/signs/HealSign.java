package dev.crnyy.vagtsystem.plugins.signs;

import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.files.Message;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class HealSign implements Listener {
    private final Config config;
    private final Message message;

    public HealSign(Config config, Message message) {
        this.config = config;
        this.message = message;
    }
    @EventHandler
    public void onSignChange(SignChangeEvent e) {
        Player player = e.getPlayer();
        Sign sign = (Sign) e.getBlock().getState();
        String firstLine = e.getLine(0);
        if (firstLine.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("healsign.signtext.text")))) {
            e.setLine(0, ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("healsign.text.1st")));
            e.setLine(1, ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("healsign.text.2nd")));
            e.setLine(2, ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("healsign.text.3nd")));
            e.setLine(3, ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("healsign.text.4nd")));
        }



    }
    @EventHandler
    public void onSignClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Block block = e.getClickedBlock();
        if (block != null && block.getType() == Material.WALL_SIGN) {
            Sign sign = (Sign) block.getState();
            if (sign.getLine(0).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("healsign.text.1st")))) {
                if (sign.getLine(1).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("healsign.text.2nd")))) {
                    if (sign.getLine(2).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("healsign.text.3nd")))) {
                        if (sign.getLine(3).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("healsign.text.4nd")))) {
                            if (player.hasPermission("vagt")) {
                                player.setFoodLevel(20);
                                player.setHealth(20);
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("vagtsign.heal-sign-chat")));
                            }
                        }
                    }
                }
            }
        }
    }
}
