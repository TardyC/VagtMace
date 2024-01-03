package dev.crnyy.vagtsystem.plugins.repair;

import dev.crnyy.vagtsystem.Main;
import dev.crnyy.vagtsystem.files.Config;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import net.milkbowl.vault.economy.Economy;

public class Repair implements Listener {
    private final Economy economy = Main.economy;
    private final Config config;
    public Repair(Config config) {
        this.config = config;
    }

    public int price;

    @EventHandler
    public void onSignClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Block block = e.getClickedBlock();
        if (block != null && block.getType() == Material.WALL_SIGN) {
            Sign sign = (Sign) block.getState();
            if (sign.getLine(0).equalsIgnoreCase("Repair")) {
                price = config.getConfig().getInt("Repair.Repair-price");
                final double balance = economy.getBalance(player);
                ItemStack itemInHand = player.getInventory().getItemInHand();
                if (itemInHand.getType() != Material.AIR) {
                    if (balance >= price) {
                        if (itemInHand.getDurability() > 0) {
                            itemInHand.setDurability((short) 0);
                            player.sendMessage(String.valueOf(price));
                            economy.withdrawPlayer(player, price);
                        } else {
                            player.sendMessage("Dit item har ikke taget damage");
                        }
                    } else {
                        player.sendMessage("Dette koster " + price + " at repair dit item");
                    }
                }
            }
        }
    }

}
