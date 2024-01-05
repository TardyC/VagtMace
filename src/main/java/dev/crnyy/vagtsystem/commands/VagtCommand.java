package dev.crnyy.vagtsystem.commands;

import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.files.Message;
import dev.crnyy.vagtsystem.plugins.PlayerManager;
import dev.crnyy.vagtsystem.plugins.vagtcoins.VagtCoins;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.CVagtShopMenu;
import dev.crnyy.vagtsystem.plugins.vagtlevel.VagtLevelMenu;
import dev.crnyy.vagtsystem.plugins.vagtlevel.VagtLevelQuests;
import dev.crnyy.vagtsystem.plugins.vagtmenu.VagtMenu;
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
            } else if (args.length == 0) {
                VagtMenu menu = new VagtMenu();
                menu.openInventory(player);
            }
        }
        return false;
    }
}
