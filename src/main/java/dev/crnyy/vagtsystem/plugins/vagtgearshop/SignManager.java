package dev.crnyy.vagtsystem.plugins.vagtgearshop;

import dev.crnyy.vagtsystem.files.Message;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.CVagtEnchantMenu;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class SignManager implements Listener {
    private final Message message;

    public SignManager(Message message) {
        this.message = message;
    }



    @EventHandler
    public void onSignChange(SignChangeEvent e) {
        Player player = e.getPlayer();
        Sign sign = (Sign) e.getBlock().getState();
        String firstLine = e.getLine(0);
        if (firstLine.equalsIgnoreCase(message.getMessages().getString("enchantsign.signtext.text"))) {
            e.setLine(0, message.getMessages().getString("enchantsign.text.1st"));
            e.setLine(1, message.getMessages().getString("enchantsign.text.2nd"));
            e.setLine(2, message.getMessages().getString("enchantsign.text.3nd"));
            e.setLine(3, message.getMessages().getString("enchantsign.text.4nd"));

        } else if (firstLine.equalsIgnoreCase(message.getMessages().getString("shopsign.signtext.text"))) {
            e.setLine(0, message.getMessages().getString("shopsign.text.1st"));
            e.setLine(1, message.getMessages().getString("shopsign.text.2nd"));
            e.setLine(2, message.getMessages().getString("shopsign.text.3nd"));
            e.setLine(3, message.getMessages().getString("shopsign.text.4nd"));
        }
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block clickedBlock = event.getClickedBlock();
        CVagtShopMenu menu = new CVagtShopMenu();
        CVagtEnchantMenu enchantMenu = new CVagtEnchantMenu();
        if (clickedBlock != null && clickedBlock.getType() == Material.WALL_SIGN) {
            Sign sign = (Sign) clickedBlock.getState();
            if (sign.getLine(0).equalsIgnoreCase(message.getMessages().getString("shopsign.text.1st"))) {
                if (sign.getLine(1).equalsIgnoreCase(message.getMessages().getString("shopsign.text.2nd"))) {
                    if (sign.getLine(2).equalsIgnoreCase(message.getMessages().getString("shopsign.text.3nd"))) {
                        if (sign.getLine(3).equalsIgnoreCase(message.getMessages().getString("shopsign.text.4nd"))) {
                            menu.openInventory(player);
                        }
                    }
                }
            } if (sign.getLine(0).equalsIgnoreCase(message.getMessages().getString("enchantsign.text.1st"))) {
                if (sign.getLine(1).equalsIgnoreCase(message.getMessages().getString("enchantsign.text.2nd"))) {
                    if (sign.getLine(2).equalsIgnoreCase(message.getMessages().getString("enchantsign.text.3nd"))) {
                        if (sign.getLine(3).equalsIgnoreCase(message.getMessages().getString("enchantsign.text.4nd"))) {
                            enchantMenu.openInventory(player);
                        }
                    }
                }
            }

        }
    }
}
