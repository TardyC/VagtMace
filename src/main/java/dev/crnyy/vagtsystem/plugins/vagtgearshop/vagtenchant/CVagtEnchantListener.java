package dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant;

import dev.crnyy.vagtsystem.Main;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class CVagtEnchantListener implements Listener {

    private Economy economy = Main.economy;
    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        final Player player = (Player) e.getWhoClicked();
        final double balance = economy.getBalance(player);
        CVagtEnchantItems items = new CVagtEnchantItems();
        final InventoryView view = player.getOpenInventory();
        final Inventory topInventory = view.getTopInventory();
        if (view == null) {
            return;
        }
        if (player == null) {
            return;
        }
        if (e.getClickedInventory() == null) {
            return;
        }
        if (topInventory == null) {
            return;
        }
        if (topInventory.getName().equals("Vagt Enchant")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
        }
        if (e.getClickedInventory().getName().equals("Vagt Enchant")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            switch (e.getCurrentItem().getType()) {
                case GOLD_HELMET:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cVagt Hjelm")) {
                            e.setCancelled(true);
                            items.openInventory("helmet", player);
                        }
                    }
                    break;
                case IRON_CHESTPLATE:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cVagt Brystplade")) {
                            e.setCancelled(true);
                            items.openInventory("chestplate", player);
                        }
                    }
                    break;
                case IRON_LEGGINGS:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cVagt Bukser")) {
                            e.setCancelled(true);
                            items.openInventory("leggings", player);
                        }
                    }
                    break;
                case IRON_BOOTS:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cVagt Sko")) {
                            e.setCancelled(true);
                            items.openInventory("boots", player);
                        }
                    }
                    break;
                case IRON_SWORD:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cVagt Sværd")) {
                            e.setCancelled(true);
                            items.openInventory("sword", player);
                        }
                    }
                    break;
                case BOW:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cVagt Bue")) {
                            e.setCancelled(true);
                            items.openInventory("bow", player);
                        }
                    }
                    break;
            }
        }
    }


}
