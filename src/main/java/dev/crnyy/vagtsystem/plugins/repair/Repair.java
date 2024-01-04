package dev.crnyy.vagtsystem.plugins.repair;

import dev.crnyy.vagtsystem.Main;
import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.files.Message;
import dev.crnyy.vagtsystem.utils.Messages;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import net.milkbowl.vault.economy.Economy;

public class Repair implements Listener {
    private final Economy economy = Main.economy;
    private final Config config;
    private final Message message;
    private final Messages messsages;
    public Repair(Config config, Message message, Messages messsages) {
        this.config = config;
        this.message = message;
        this.messsages = messsages;
    }
    public int price;
    @EventHandler
    public void onSignChange(SignChangeEvent e) {
        Player player = e.getPlayer();
        Sign sign = (Sign) e.getBlock().getState();
        String firstLine = e.getLine(0);
        if (firstLine.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("repairsign.signtext.text")))) {
            e.setLine(0, ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("repairsign.text.1st")));
            e.setLine(1, ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("repairsign.text.2nd")));
            e.setLine(2, ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("repairsign.text.3nd")));
            e.setLine(3, ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("repairsign.text.4nd")));
        }



    }

    @EventHandler
    public void onSignClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Block block = e.getClickedBlock();
        if (block != null && block.getType() == Material.WALL_SIGN) {
            Sign sign = (Sign) block.getState();
            if (sign.getLine(0).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("repairsign.text.1st")))) {
                if (sign.getLine(1).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("repairsign.text.2nd")))) {
                    if (sign.getLine(2).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("repairsign.text.3nd")))) {
                        if (sign.getLine(3).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("repairsign.text.4nd")))) {
                            price = config.getConfig().getInt("Repair.Repair-price");
                            final double balance = economy.getBalance(player);
                            ItemStack itemInHand = player.getInventory().getItemInHand();
                            if (itemInHand.getType() != Material.AIR) {
                                if (!itemInHand.getType().isBlock()) {
                                    if (balance >= price) {
                                        if (itemInHand.getDurability() > 0) {
                                            itemInHand.setDurability((short) 0);
                                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messsages.repairSignrepaired("price", price)));
                                            economy.withdrawPlayer(player, price);
                                        } else {
                                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', message.getMessages().getString("repair.damage")));
                                        }
                                    } else {
                                        player.sendMessage(messsages.repairSignnotmoney(ChatColor.translateAlternateColorCodes('&', "price"), price));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
