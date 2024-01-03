package dev.crnyy.vagtsystem.plugins.vagtontime;

import dev.crnyy.vagtsystem.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VagtOntimeCommand implements CommandExecutor {

    private final Main plugin;
    private final VagtOntime ontime;
    public VagtOntimeCommand(Main plugin, VagtOntime ontime) {
        this.plugin = plugin;
        this.ontime = ontime;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("ontime")) {
            if (player.hasPermission("vagt")) {
                if (ontime.onTimeMap.containsKey(player.getUniqueId())) {
                    long currentTime = System.currentTimeMillis();
                    long elapsedTime = currentTime - ontime.onTimeMap.get(player.getUniqueId());
                    String formattedTime = ontime.getString(elapsedTime);
                    player.sendMessage("Ontime: " + formattedTime);
                }
            }
        }
        return false;
    }
}
