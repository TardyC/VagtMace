package dev.crnyy.vagtsystem.plugins.vagtmenu;

import dev.crnyy.vagtsystem.utils.ItemStackManager;
import dev.crnyy.vagtsystem.utils.LoreManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Utility;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class VagtMenu {
    private Inventory inv = Bukkit.createInventory(null, 45, "Vagt Menu");
    @Utility
    public void items(final Player player) {
        ItemStack item;
        ItemStackManager itemStackManager = new ItemStackManager();
        LoreManager loreManager = new LoreManager();
        item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 1, loreManager.loreMaker(""));
        inv.setItem(0, item);
        inv.setItem(1, item);
        inv.setItem(2, item);
        inv.setItem(3, item);
        inv.setItem(4, item);
        inv.setItem(5, item);
        inv.setItem(6, item);
        inv.setItem(7, item);
        inv.setItem(8, item);



        item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 0, loreManager.loreMaker(""));
        inv.setItem(36, item);
        inv.setItem(37, item);
        inv.setItem(38, item);
        inv.setItem(39, item);
        inv.setItem(40, item);
        inv.setItem(41, item);
        inv.setItem(42, item);
        inv.setItem(43, item);
        inv.setItem(44, item);
    }

    public void openInventory(String inventory, final Player player) {
        items(player);
        player.openInventory(inv);
    }

}
