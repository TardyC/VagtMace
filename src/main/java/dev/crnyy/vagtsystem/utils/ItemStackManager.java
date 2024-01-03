package dev.crnyy.vagtsystem.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Base64;
import java.util.UUID;
import java.util.List;

public class ItemStackManager {

    public ItemStack itemMaker(String displayName, Material material, int amount, int data, List<String> lore) {
        ItemStack item;
        if (material != null) {
            item = new ItemStack(material, amount, (short) data);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(displayName);
            meta.setLore(lore);
            item.setItemMeta(meta);
        } else {
            item = new ItemStack(Material.STAINED_GLASS, 1, (short) 14);
        }
        return item;
    }
    public ItemStack itemMMaker(final String name, final Material mat, final int amount, final int sh, final List<String> lore) {
        final ItemStack item = new ItemStack(mat, amount, (short)sh);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getHead(String texture, String name, List<String> lore) {
        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);

        if (texture.isEmpty())
            return head;

        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        headMeta.setDisplayName(name);
        headMeta.setLore(lore);

        profile.getProperties().put("textures", new Property("textures", texture));

        try {
            Field profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);

        } catch (IllegalArgumentException | NoSuchFieldException | SecurityException | IllegalAccessException error) {
            error.printStackTrace();
        }
        head.setItemMeta(headMeta);
        return head;
    }

}
