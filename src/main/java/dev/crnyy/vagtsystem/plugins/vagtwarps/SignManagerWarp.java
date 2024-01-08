package dev.crnyy.vagtsystem.plugins.vagtwarps;

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

public class SignManagerWarp implements Listener {
    private final Message message;

    public SignManagerWarp(Message message) {
        this.message = message;
    }


    @EventHandler
    public void onSignChange(SignChangeEvent e) {
        Player player = e.getPlayer();
        Sign sign = (Sign) e.getBlock().getState();
        String firstLine = e.getLine(0);
        if (firstLine.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("vagtwarpsign.signtext.text")))) {
            if (player.hasPermission("vagt")) {
                e.setLine(0, ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("vagtwarpsign.text.1st")));
                e.setLine(1, ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("vagtwarpsign.text.2nd")));
                e.setLine(2, ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("vagtwarpsign.text.3nd")));
                e.setLine(3, ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("vagtwarpsign.text.4nd")));
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block clickedBlock = event.getClickedBlock();
        StartVagtMenu menu = new StartVagtMenu();
        if (clickedBlock != null && clickedBlock.getType() == Material.WALL_SIGN) {
            Sign sign = (Sign) clickedBlock.getState();
            if (sign.getLine(0).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("vagtwarpsign.text.1st")))) {
                if (sign.getLine(1).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("vagtwarpsign.text.2nd")))) {
                    if (sign.getLine(2).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("vagtwarpsign.text.3nd")))) {
                        if (sign.getLine(3).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("vagtwarpsign.text.4nd")))) {
                            if (player.hasPermission("vagt")) {
                                menu.openInventory(player);
                            }
                        }
                    }
                }
            }
        }
    }
}
