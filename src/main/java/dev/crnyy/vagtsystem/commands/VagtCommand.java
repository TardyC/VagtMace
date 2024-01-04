package dev.crnyy.vagtsystem.commands;

import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.files.Message;
import dev.crnyy.vagtsystem.plugins.vagtmine.VagtMine;
import dev.crnyy.vagtsystem.utils.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VagtCommand implements CommandExecutor {

    private final Config config;
    private final Message message;
    public VagtCommand(Config config, Message message) {
        this.config = config;
        this.message = message;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("vagt")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("reload")) {
                    config.reloadConfig();
                    message.reloadConfig();
                }
            }
        }
        return false;
    }
}
