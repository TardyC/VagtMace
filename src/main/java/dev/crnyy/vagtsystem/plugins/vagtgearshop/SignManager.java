package dev.crnyy.vagtsystem.plugins.vagtgearshop;

import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.CVagtEnchantMenu;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.CVagtShopMenu;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class SignManager implements Listener {

    public String cVagtShopLine1 = "Vagt Shop";
    public String cVagtEnchantLine1 = "Vagt Enchant";

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block clickedBlock = event.getClickedBlock();
        CVagtShopMenu menu = new CVagtShopMenu();
        CVagtEnchantMenu enchantMenu = new CVagtEnchantMenu();
        if (clickedBlock != null && clickedBlock.getType() == Material.WALL_SIGN) {
            Sign sign = (Sign) clickedBlock.getState();
            if (sign.getLine(0).equalsIgnoreCase(cVagtShopLine1)) {
                menu.openInventory(player);
            } else if (sign.getLine(0).equalsIgnoreCase(cVagtEnchantLine1)) {
                enchantMenu.openInventory(player);
            }

        }
    }
}
