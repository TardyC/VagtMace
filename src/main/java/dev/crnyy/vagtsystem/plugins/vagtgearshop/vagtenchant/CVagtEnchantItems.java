package dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant;

import dev.crnyy.vagtsystem.utils.ItemStackManager;
import dev.crnyy.vagtsystem.utils.LoreManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Utility;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class CVagtEnchantItems {

    private static Inventory helmetInv = Bukkit.createInventory(null, 45, "Enchant Hjelm");
    private static Inventory chestplateInv = Bukkit.createInventory(null, 45, "Enchant Brystplade");
    private static Inventory leggingsInv = Bukkit.createInventory(null, 45, "Enchant Bukser");
    private static Inventory bootsInv = Bukkit.createInventory(null, 45, "Enchant Sko");
    private static Inventory swordInv = Bukkit.createInventory(null, 45, "Enchant Sværd");
    private static Inventory bowInv = Bukkit.createInventory(null, 45, "Enchant Bue");
    @Utility
    public void helmet(final Player player) {
        ItemStack item;
        ItemStackManager itemStackManager = new ItemStackManager();
        LoreManager loreManager = new LoreManager();
        final ItemStack headItem = player.getInventory().getHelmet();

        item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 1, loreManager.loreMaker(""));
        helmetInv.setItem(0, item);
        helmetInv.setItem(1, item);
        helmetInv.setItem(2, item);
        helmetInv.setItem(3, item);
        helmetInv.setItem(4, item);
        helmetInv.setItem(5, item);
        helmetInv.setItem(6, item);
        helmetInv.setItem(7, item);
        helmetInv.setItem(8, item);

        item = headItem.clone();
        helmetInv.setItem(22, item);

        item = itemStackManager.itemMaker("§c§lTILBAGE", Material.INK_SACK, 1, 1, loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Klik her for at gå tilbage.",
                "",
                "§8§m-------------------------"));
        helmetInv.setItem(36, item);

        item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 0, loreManager.loreMaker(""));
        helmetInv.setItem(37, item);
        helmetInv.setItem(38, item);
        helmetInv.setItem(39, item);
        helmetInv.setItem(40, item);
        helmetInv.setItem(41, item);
        helmetInv.setItem(42, item);
        helmetInv.setItem(43, item);
        helmetInv.setItem(44, item);
    }
    @Utility
    public void chestplate(final Player player) {
        ItemStack item;
        ItemStackManager itemStackManager = new ItemStackManager();
        LoreManager loreManager = new LoreManager();
        final ItemStack chestplateItem = player.getInventory().getChestplate();

        item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 1, loreManager.loreMaker(""));
        chestplateInv.setItem(0, item);
        chestplateInv.setItem(1, item);
        chestplateInv.setItem(2, item);
        chestplateInv.setItem(3, item);
        chestplateInv.setItem(4, item);
        chestplateInv.setItem(5, item);
        chestplateInv.setItem(6, item);
        chestplateInv.setItem(7, item);
        chestplateInv.setItem(8, item);

        item = chestplateItem.clone();
        chestplateInv.setItem(22, item);

        item = itemStackManager.itemMaker("§c§lTILBAGE", Material.INK_SACK, 1, 1, loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Klik her for at gå tilbage.",
                "",
                "§8§m-------------------------"));
        chestplateInv.setItem(36, item);

        item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 0, loreManager.loreMaker(""));
        chestplateInv.setItem(37, item);
        chestplateInv.setItem(38, item);
        chestplateInv.setItem(39, item);
        chestplateInv.setItem(40, item);
        chestplateInv.setItem(41, item);
        chestplateInv.setItem(42, item);
        chestplateInv.setItem(43, item);
        chestplateInv.setItem(44, item);
    }
    @Utility
    public void leggings(final Player player) {
        ItemStack item;
        ItemStackManager itemStackManager = new ItemStackManager();
        LoreManager loreManager = new LoreManager();
        final ItemStack leggingsItem = player.getInventory().getLeggings();

        item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 1, loreManager.loreMaker(""));
        leggingsInv.setItem(0, item);
        leggingsInv.setItem(1, item);
        leggingsInv.setItem(2, item);
        leggingsInv.setItem(3, item);
        leggingsInv.setItem(4, item);
        leggingsInv.setItem(5, item);
        leggingsInv.setItem(6, item);
        leggingsInv.setItem(7, item);
        leggingsInv.setItem(8, item);

        item = leggingsItem.clone();
        leggingsInv.setItem(22, item);

        item = itemStackManager.itemMaker("§c§lTILBAGE", Material.INK_SACK, 1, 1, loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Klik her for at gå tilbage.",
                "",
                "§8§m-------------------------"));
        leggingsInv.setItem(36, item);

        item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 0, loreManager.loreMaker(""));
        leggingsInv.setItem(37, item);
        leggingsInv.setItem(38, item);
        leggingsInv.setItem(39, item);
        leggingsInv.setItem(40, item);
        leggingsInv.setItem(41, item);
        leggingsInv.setItem(42, item);
        leggingsInv.setItem(43, item);
        leggingsInv.setItem(44, item);
    }
    @Utility
    public void boots(final Player player) {
        ItemStack item;
        ItemStackManager itemStackManager = new ItemStackManager();
        LoreManager loreManager = new LoreManager();
        final ItemStack bootsItem = player.getInventory().getBoots();

        item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 1, loreManager.loreMaker(""));
        bootsInv.setItem(0, item);
        bootsInv.setItem(1, item);
        bootsInv.setItem(2, item);
        bootsInv.setItem(3, item);
        bootsInv.setItem(4, item);
        bootsInv.setItem(5, item);
        bootsInv.setItem(6, item);
        bootsInv.setItem(7, item);
        bootsInv.setItem(8, item);

        item = bootsItem.clone();
        bootsInv.setItem(22, item);

        item = itemStackManager.itemMaker("§c§lTILBAGE", Material.INK_SACK, 1, 1, loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Klik her for at gå tilbage.",
                "",
                "§8§m-------------------------"));
        bootsInv.setItem(36, item);

        item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 0, loreManager.loreMaker(""));
        bootsInv.setItem(37, item);
        bootsInv.setItem(38, item);
        bootsInv.setItem(39, item);
        bootsInv.setItem(40, item);
        bootsInv.setItem(41, item);
        bootsInv.setItem(42, item);
        bootsInv.setItem(43, item);
        bootsInv.setItem(44, item);
    }
    @Utility
    public void sword(final Player player) {
        ItemStack item;
        ItemStackManager itemStackManager = new ItemStackManager();
        LoreManager loreManager = new LoreManager();
        item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 1, loreManager.loreMaker(""));
        swordInv.setItem(0, item);
        swordInv.setItem(1, item);
        swordInv.setItem(2, item);
        swordInv.setItem(3, item);
        swordInv.setItem(4, item);
        swordInv.setItem(5, item);
        swordInv.setItem(6, item);
        swordInv.setItem(7, item);
        swordInv.setItem(8, item);

        item = findItemWithName(player.getInventory(), Material.IRON_SWORD, "§cVagt Sværd");
        swordInv.setItem(22, item);

        item = itemStackManager.itemMaker("§c§lTILBAGE", Material.INK_SACK, 1, 1, loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Klik her for at gå tilbage.",
                "",
                "§8§m-------------------------"));
        swordInv.setItem(36, item);

        item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 0, loreManager.loreMaker(""));
        swordInv.setItem(37, item);
        swordInv.setItem(38, item);
        swordInv.setItem(39, item);
        swordInv.setItem(40, item);
        swordInv.setItem(41, item);
        swordInv.setItem(42, item);
        swordInv.setItem(43, item);
        swordInv.setItem(44, item);
    }
    @Utility
    public void bow(final Player player) {
        ItemStack item;
        ItemStackManager itemStackManager = new ItemStackManager();
        LoreManager loreManager = new LoreManager();
        item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 1, loreManager.loreMaker(""));
        bowInv.setItem(0, item);
        bowInv.setItem(1, item);
        bowInv.setItem(2, item);
        bowInv.setItem(3, item);
        bowInv.setItem(4, item);
        bowInv.setItem(5, item);
        bowInv.setItem(6, item);
        bowInv.setItem(7, item);
        bowInv.setItem(8, item);

        item = findItemWithName(player.getInventory(), Material.BOW, "§cVagt Bue");
        bowInv.setItem(22, item);

        item = itemStackManager.itemMaker("§c§lTILBAGE", Material.INK_SACK, 1, 1, loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Klik her for at gå tilbage.",
                "",
                "§8§m-------------------------"));
        bowInv.setItem(36, item);

        item = itemStackManager.itemMaker("§7", Material.STAINED_GLASS_PANE, 1, 0, loreManager.loreMaker(""));
        bowInv.setItem(37, item);
        bowInv.setItem(38, item);
        bowInv.setItem(39, item);
        bowInv.setItem(40, item);
        bowInv.setItem(41, item);
        bowInv.setItem(42, item);
        bowInv.setItem(43, item);
        bowInv.setItem(44, item);
    }

    public void openInventory(String inventory, final Player player) {
        switch (inventory) {
            case "helmet":
                helmet(player);
                player.openInventory(helmetInv);
                break;
            case "chestplate":
                chestplate(player);
                player.openInventory(chestplateInv);
                break;
            case "leggings":
                leggings(player);
                player.openInventory(leggingsInv);
                break;
            case "boots":
                boots(player);
                player.openInventory(bootsInv);
                break;
            case "sword":
                sword(player);
                player.openInventory(swordInv);
                break;
            case "bow":
                bow(player);
                player.openInventory(bowInv);
                break;
        }
    }


    private boolean hasItemWithName(PlayerInventory inventory, Material material, String itemName) {
        for (ItemStack itemStack : inventory.getContents()) {
            if (itemStack != null && itemStack.getType() == material && itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equals(itemName)) {
                return true;
            }
        }
        return false;
    }
    private ItemStack findItemWithName(PlayerInventory inventory, Material material, String itemName) {
        for (ItemStack itemStack : inventory.getContents()) {
            if (itemStack != null && itemStack.getType() == material && itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equals(itemName)) {
                return itemStack;
            }
        }
        return null;
    }

}
