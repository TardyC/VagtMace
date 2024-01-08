package dev.crnyy.vagtsystem.plugins.vagtwarps;

import dev.crnyy.vagtsystem.plugins.ArmorManager;
import dev.crnyy.vagtsystem.plugins.vagtmenu.VagtMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class VagtWarpMenuListener implements Listener {
    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        final Player player = (Player) e.getWhoClicked();
        final ArmorManager am = new ArmorManager();
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
        if (topInventory.getName().equals("§6§lVAGT§f§l WARP§7 - Hovede Menu")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
        }
        if (e.getClickedInventory().getName().equals("§6§lVAGT§f§l WARP§7 - Hovede Menu")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getSlot() == 19) {
                CVagtWarpMenu menu = new CVagtWarpMenu();
                menu.openInventory(player);
                e.setCancelled(true);
            }
            if (e.getSlot() == 22) {
                BVagtWarpMenu menu = new BVagtWarpMenu();
                menu.openInventory(player);
                e.setCancelled(true);
            }
            if (e.getSlot() == 25) {
                AVagtWarpMenu menu = new AVagtWarpMenu();
                menu.openInventory(player);
                e.setCancelled(true);
            }
            if (e.getSlot() == 36) {
                VagtMenu menu = new VagtMenu();
                menu.openInventory(player);
            }
        }
        if (e.getClickedInventory().getName().equals("§6§lVAGT§f§l WARP§7 - §cC§7 Menu")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getSlot() == 36) {
                StartVagtMenu menu = new StartVagtMenu();
                menu.openInventory(player);
                e.setCancelled(true);
            }
        }
        if (topInventory.getName().equals("§6§lVAGT§f§l WARP§7 - §cC§7 Menu")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
        }
        if (e.getClickedInventory().getName().equals("§6§lVAGT§f§l WARP§7 - §bB§7 Menu")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getSlot() == 36) {
                StartVagtMenu menu = new StartVagtMenu();
                menu.openInventory(player);
                e.setCancelled(true);
            }
        }
        if (topInventory.getName().equals("§6§lVAGT§f§l WARP§7 - §bB§7 Menu")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
        }
        if (e.getClickedInventory().getName().equals("§6§lVAGT§f§l WARP§7 - §aA§7 Menu")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getSlot() == 36) {
                StartVagtMenu menu = new StartVagtMenu();
                menu.openInventory(player);
                e.setCancelled(true);
            }
        }
        if (topInventory.getName().equals("§6§lVAGT§f§l WARP§7 - §aA§7 Menu")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
        }

    }


}
