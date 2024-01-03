package dev.crnyy.vagtsystem.plugins;

import dev.crnyy.vagtsystem.utils.LoreManager;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ArmorManager {

    public Map<UUID, Integer> cHelmet = new HashMap<UUID, Integer>();
    public String player;

    public int cChestplate;

    public int cLeggings;

    public int cBoots;
    public int cSword;
    public int cBow;


    public ItemStack cHelmet(final Player player) {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.GOLD_HELMET, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§cVagt Hjelm");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Enchants§8:",
                "§8- §7Protection§8: §f"+cHelmet.get(player.getUniqueId()),
                "",
                "§8【 &7Købt af§8: §f" + player.getName() + " §8】",
                "§8【 &7Rank§8: §fC §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack cChestplate() {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§cVagt Brystplade");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Enchants§8:",
                "§8- §7Protection§8: §f"+cChestplate,
                "",
                "§8【 &7Købt af§8: §f" + player + " §8】",
                "§8【 &7Rank§8: §fC §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack cLeggings() {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.IRON_LEGGINGS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§cVagt Bukser");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Enchants§8:",
                "§8- §7Protection§8: §f"+cLeggings,
                "",
                "§8【 &7Købt af§8: §f" + player + " §8】",
                "§8【 &7Rank§8: §fC §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack cBoots() {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.IRON_BOOTS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§cVagt Sko");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Enchants§8:",
                "§8- §7Protection§8: §f"+cBoots,
                "",
                "§8【 &7Købt af§8: §f" + player + " §8】",
                "§8【 &7Rank§8: §fC §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack cSword() {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§cVagt Sværd");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Enchants§8:",
                "§8- §7Sharpness§8: §f"+cSword,
                "",
                "§8【 &7Købt af§8: §f" + player + " §8】",
                "§8【 &7Rank§8: §fC §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack cBow() {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§cVagt Bue");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Enchants§8:",
                "§8- §7Power§8: §f"+cBow,
                "",
                "§8【 &7Købt af§8: §f" + player + " §8】",
                "§8【 &7Rank§8: §fC §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack cStick() {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(Enchantment.KNOCKBACK, 2, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§cVagt Pind");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§7Enchants§8:",
                "§8- §7Knockback§8: §f2",
                "",
                "§8【 &7Købt af§8: §f" + player + " §8】",
                "§8【 &7Rank§8: §fC §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack cFood() {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.GRILLED_PORK, 16);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§cVagt Mad");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§8【 &7Købt af§8: §f" + player + " §8】",
                "§8【 &7Rank§8: §fC §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack cArrows() {
        LoreManager loreManager = new LoreManager();
        ItemStack item = new ItemStack(Material.ARROW, 16);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName("§cVagt Pile");
        meta.setLore(loreManager.loreMaker(
                "§8§m-------------------------",
                "",
                "§8【 &7Købt af§8: §f" + player + " §8】",
                "§8【 &7Rank§8: §fC §8】",
                "",
                "§cDette item er ulovligt!",
                "§8§m-------------------------"));
        item.setItemMeta(meta);
        return item;
    }
}
