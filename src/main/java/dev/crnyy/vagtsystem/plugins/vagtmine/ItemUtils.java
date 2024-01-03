package dev.crnyy.vagtsystem.plugins.vagtmine;

import dev.crnyy.vagtsystem.utils.LoreManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtils {

    public ItemStack pickaxe(final Player player, int remain) {
        LoreManager lore = new LoreManager();
        ItemStack item = new ItemStack(Material.WOOD_PICKAXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.spigot().setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        meta.setDisplayName("§6Spasser §fPickaxe");
        meta.setLore(lore.loreMaker(
                "",
                "§7Du mangler stadig,",
                "§7at mine dig frem!",
                "",
                "§8【 §7Spiller§8: §f" + player.getName() + " §8】",
                "§8【 §7Tilbage§8: §f" + remain + " §8】",
                ""));
        item.setItemMeta(meta);
        return item;
    }

}