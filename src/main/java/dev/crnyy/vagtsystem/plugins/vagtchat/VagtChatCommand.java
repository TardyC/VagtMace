package dev.crnyy.vagtsystem.plugins.vagtchat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VagtChatCommand implements CommandExecutor {

    public static List<UUID> chatController = new ArrayList<UUID>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("vagtchat")) {
            if (!(player.hasPermission("vagt"))) {
                player.sendMessage("Du har ikke adgang til dette.");
                return true;
            }
            if (chatController.contains(player.getUniqueId())) {
                player.sendMessage("Du har slået vagtchat fra!");
                chatController.remove(player.getUniqueId());
                return true;
            }
            player.sendMessage("Du har slået vagtchat til!");
            chatController.add(player.getUniqueId());
        }
        return false;
    }
}
