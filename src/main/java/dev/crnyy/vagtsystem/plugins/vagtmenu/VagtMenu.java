package dev.crnyy.vagtsystem.plugins.vagtmenu;

import dev.crnyy.vagtsystem.plugins.PlayerManager;
import dev.crnyy.vagtsystem.plugins.vagtlevel.VagtLevelQuests;
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
    private PlayerManager playerManager;



    public VagtMenu(PlayerManager playermanager) {
        this.playerManager = playermanager;
    }



    @Utility
    public void items(final Player player) {
        ItemStack item;
        ItemStackManager itemStack = new ItemStackManager();
        LoreManager lore = new LoreManager();

        //Vagt
        item = itemStack.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 1, lore.loreMaker(""));
        for (int i = 0; i < 9; i++) {
            inv.setItem(i, item);
        }
        item = itemStack.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 0, lore.loreMaker(""));
        for (int i = 36; i < 45; i++) {
            inv.setItem(i, item);
        }
        //VagtLevel
        item = itemStack.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTM4MjYxODFjZTkwMTJiNjY1ODY1ZjNhYzAwNjYzMDdiNGQwMmRhMjgxNTQwMTA0ZTA0NjFmZmVmYTc0NTlmZCJ9fX0=", "§6§lVAGT §f§lLEVEL", lore.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Denne fører til",
                "§fVagt Level§7 Start Menu",
                "",
                "",
                "§7Kan tilgåes via §f/VagtLevel",
                "",
                "§8§m-------------------------"));
        inv.setItem(19, item);

        //VagtLøn
        item = itemStack.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjA5Mjk5YTExN2JlZTg4ZDMyNjJmNmFiOTgyMTFmYmEzNDRlY2FlMzliNDdlYzg0ODEyOTcwNmRlZGM4MWU0ZiJ9fX0=", "§6§lVAGT §f§lLØN", lore.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Denne fører til",
                "§fVagt Løn§7 Start Menu",
                "",
                "",
                "§7Kan tilgåes via §f/Vagtløn",
                "",
                "§8§m-------------------------"));
        inv.setItem(20, item);
        //Vagt ONTIME
        item = itemStack.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWY1ZDNhNThlZmE3ZTNlZTQ2YzA2YTEzMDAxNWY0YTJkMTkzZjdhMmIyNTUyNmQ0YmVjZTRlMzM4NWUzZWFiNSJ9fX0=", "§6§lVAGT §f§ONTIME", lore.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Denne fører til",
                "§fVagt Ontime§7 Start Menu",
                "",
                "",
                "§7Kan tilgåes via §f/VagtOntime",
                "",
                "§8§m-------------------------"));
        inv.setItem(21, item);
        //VagtWarp
        item = itemStack.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWY1ZDNhNThlZmE3ZTNlZTQ2YzA2YTEzMDAxNWY0YTJkMTkzZjdhMmIyNTUyNmQ0YmVjZTRlMzM4NWUzZWFiNSJ9fX0=", "§6§lVAGT §f§WARPS", lore.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Denne fører til",
                "§fVagt Warps§7 Start Menu",
                "",
                "",
                "§fKan kun bruges via Skilte",
                "",
                "§8§m-------------------------"));
        inv.setItem(22, item);

        //Vagt events
        item = itemStack.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTc0ZjkxMGNhN2VkNzNkOGM1ZmRjODQ3NmQxYmVkN2FlNGUxOGY4ZTFkZjZiODAwZDE2YjNiZTNkMzNlYmJmYyJ9fX0=", "§6§lVAGT §f§EVENTS", lore.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Denne fører til",
                "§fVagt Events§7 Start Menu",
                "",
                "",
                "§7Kan tilgåes via §fVagt Menu",
                "",
                "§8§m-------------------------"));
        inv.setItem(23, item);

        //Vagt Shop
        item = itemStack.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGQyMWRkZGNkZWI4ZTM0NjY3MWJlZGY0Y2FlYTlhZjQ3NzQxMDFmYjkxNmVmOGY0Mjg4YTc5YmMxNmU0NzE0In19fQ==", "§6§lVAGT §f§lSHOP", lore.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Denne fører til",
                "§fVagt Shop§7 Start Menu",
                "",
                "",
                "§7Kan tilgåes via §fVagt Menu",
                "",
                "§8§m-------------------------"));
        inv.setItem(24, item);

        //Vagt COINS
        item = itemStack.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2QyNGRjNTgwNjljMTIxMmI1MjlhNGFlNWQ0ZTczYmUwOTkwZDQ2ZmU5MzcxYjFmNzllODE2NGI0Mjg1OWFjOCJ9fX0=", "§6§lVAGT §f§lCOINS", lore.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Denne fører til",
                "§fVagt Coins§7 Start Menu",
                "",
                "§7Dine Coins§8: §f", //Coins hashmap ind her"",
                "",
                "",
                "§7Kan tilgåes via §fVagt Menu",
                "",
                "§8§m-------------------------"));
        inv.setItem(25, item);
    }

    public void openInventory(final Player player) {
        items(player);
        player.openInventory(inv);
    }


}


