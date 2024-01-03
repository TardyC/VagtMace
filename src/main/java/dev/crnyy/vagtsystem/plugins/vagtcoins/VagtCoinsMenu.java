package dev.crnyy.vagtsystem.plugins.vagtcoins;

import dev.crnyy.vagtsystem.utils.ItemStackManager;
import dev.crnyy.vagtsystem.utils.LoreManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class VagtCoinsMenu {

    private Inventory menu = Bukkit.createInventory(null, 45, "Vagt Coins");

    private void items(Inventory inventory) {
        ItemStack item;
        ItemStackManager itemStackManager = new ItemStackManager();
        LoreManager loreManager = new LoreManager();
        for (int i = 0; i < 9; i++) {
            item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS, 1, 1, loreManager.loreMaker(""));
            inventory.setItem(i, item);
            item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS, 1, 0, loreManager.loreMaker(""));
            inventory.setItem(inventory.getSize() - 9 + i, item);
        }
    }


    public void open(Player player) {
        items(menu);
        player.openInventory(menu);
    }
}