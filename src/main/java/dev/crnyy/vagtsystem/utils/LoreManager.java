package dev.crnyy.vagtsystem.utils;

import org.bukkit.ChatColor;

import java.util.ArrayList;

public class LoreManager {
    public ArrayList<String> loreMaker(final String... str) {
        final ArrayList<String> lore = new ArrayList<String>();
        for (final String s : str) {
            lore.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        return lore;
    }

}
