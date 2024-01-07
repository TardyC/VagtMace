package dev.crnyy.vagtsystem.placeholders;

import dev.crnyy.vagtsystem.Main;
import dev.crnyy.vagtsystem.plugins.PlayerManager;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class PlaceholderAPI extends PlaceholderExpansion {

    private final Main plugin;
    private final PlayerManager manager;
    public PlaceholderAPI(Main plugin, PlayerManager manager){
        this.plugin = plugin;
        this.manager = manager;
    }

    @Override
    public boolean persist(){
        return true;
    }

    @Override
    public boolean canRegister(){
        return true;
    }

    @Override
    public String getAuthor(){
        return "crnyy, Bowsseeee";
    }

    @Override
    public String getIdentifier(){
        return "VagtSystem";
    }

    @Override
    public String getVersion(){
        return "1.0.0";
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        final int level = manager.getLevel(player);
        if (player == null){
            return "";
        }
        if (identifier.equals("level")) {
            return String.valueOf(level);
        }

        return null;
    }

}
