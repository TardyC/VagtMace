package dev.crnyy.vagtsystem.plugins.vagtwarps;

import dev.crnyy.vagtsystem.utils.ItemStackManager;
import dev.crnyy.vagtsystem.utils.LoreManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Utility;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class StartVagtMenu {


    private Inventory vagtwarp = Bukkit.createInventory(null, 45, "§6§lVAGT§f§l WARP§7 - Hovede Menu");

    @Utility
    public void items(final Player player) {
        ItemStack item;
        ItemStackManager itemStackManager = new ItemStackManager();
        LoreManager loreManager = new LoreManager();

        item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 1, loreManager.loreMaker(""));
        for (int i = 0; i < 9; i++) {
            vagtwarp.setItem(i, item);
        }
        item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 0, loreManager.loreMaker(""));
        for (int i = 36; i < 45; i++) {
            vagtwarp.setItem(i, item);
        }
        item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWFjMGRhOTQ5NGI5NzRiZGJjYjc4ODYxZGY5NmFhNWFhYTVkYTM1YzY1ODcyMTcxOGFiMjZkYzJmZjY3ZDg3In19fQ==", "§c§lC §f§lWARPS", loreManager.loreMaker(
                "§8§m-----------------------------",
                "",
                "§7Denne fører til",
                "§fWarp §cC §7MENUEN",
                "",
                "",
                "§7Kan kun tilgåes via denne menu",
                "",
                "§8§m-----------------------------"));

        vagtwarp.setItem(19, item);

        item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzQ3ODk5ZDUxMWJhM2EzYmZlMTQ1NDFhNmE0Yjc3YjAzM2U0NGFjZDk1Njg5NmU3YjY1Njc0MjliZjE4ZDgzYyJ9fX0=", "§b§lB §f§lWARPS", loreManager.loreMaker(
                "§8§m-----------------------------",
                "",
                "§7Denne fører til",
                "§fWarp §bB §7MENUEN",
                "",
                "",
                "§7Kan kun tilgåes via denne menu",
                "",
                "§8§m-----------------------------"));

        vagtwarp.setItem(22, item);

        item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjBhZmQ3NzdkNTU3YTIwN2JhYzdhYWQ4NDIxZmRmNzg4ZDY2ODU4NzNjNDk1MTVkNTUyOTFlOTMwNjk5ZiJ9fX0=", "§a§lA §f§lWARPS", loreManager.loreMaker(
                "§8§m-----------------------------",
                "",
                "§7Denne fører til",
                "§fWarp §aA §7MENUEN",
                "",
                "",
                "§7Kan kun tilgåes via denne menu",
                "",
                "§8§m-----------------------------"));

        vagtwarp.setItem(25, item);

        item = itemStackManager.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODU1MGI3Zjc0ZTllZDc2MzNhYTI3NGVhMzBjYzNkMmU4N2FiYjM2ZDRkMWY0Y2E2MDhjZDQ0NTkwY2NlMGIifX19", "§c§lTILBAGE", loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Klik her for at gå tilbage.",
                "",
                "§8§m-------------------------"));
        vagtwarp.setItem(36, item);
    }

    public void openInventory(final Player player) {
        items(player);
        player.openInventory(vagtwarp);
    }
}
