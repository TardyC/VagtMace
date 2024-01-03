package dev.crnyy.vagtsystem.plugins.vagtlevel;

import dev.crnyy.vagtsystem.plugins.PlayerManager;
import dev.crnyy.vagtsystem.plugins.vagtchat.VagtChatCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VagtLevelCommand implements CommandExecutor {

    private final PlayerManager manager;
    public VagtLevelCommand(PlayerManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("vagtlevel")) {
            if (args.length == 3) {
                if (args[0].equalsIgnoreCase("set") || args[0].equalsIgnoreCase("sæt")) {
                    Player argPlayer = Bukkit.getPlayer(args[1]);
                    if (argPlayer == null) {
                        player.sendMessage("Spilleren eksistere ikke!");
                        return true;
                    }
                    if (!(args[1].isEmpty())) {
                        if (!(args[2].isEmpty())) {
                            if (!(isInt(args[2]))) {
                                player.sendMessage("Du skal skrive et tal!");
                                return true;
                            }
                            int arg = Integer.parseInt(args[2]);
                            player.sendMessage("Du har sat " + argPlayer.getName() + "'s level til " + arg);
                            manager.setLevel(player, arg);
                            return true;
                        }
                    }
                } else if (args[0].equalsIgnoreCase("add") || args[0].equalsIgnoreCase("tilføj")) {
                    Player argPlayer = Bukkit.getPlayer(args[1]);
                    if (argPlayer == null) {
                        player.sendMessage("Spilleren eksistere ikke!");
                        return true;
                    }
                    if (!(args[1].isEmpty())) {
                        if (!(args[2].isEmpty())) {
                            if (!(isInt(args[2]))) {
                                player.sendMessage("Du skal skrive et tal!");
                                return true;
                            }
                            int arg = Integer.parseInt(args[2]);
                            int level = manager.getLevel(player);
                            player.sendMessage("Du har tilføjet " + arg + " levels til " + argPlayer.getName());
                            manager.setLevel(player, level+arg);
                            return true;
                        }
                    }
                }
            } else if (args.length == 2) {
                if (args[0].equalsIgnoreCase("remove") || args[0].equalsIgnoreCase("fjern")) {
                    Player argPlayer = Bukkit.getPlayer(args[1]);
                    if (argPlayer == null) {
                        player.sendMessage("Spilleren eksistere ikke!");
                        return true;
                    }
                    if (!(args[1].isEmpty())) {
                        player.sendMessage("Du har fjernet " + argPlayer.getName() + "'s level!");
                        manager.setLevel(player, 1);
                        return true;
                    }
                }
            } else if (args.length == 1) {
                if (!(player.isOp())) {
                    return true;
                }
                if (args[0].equalsIgnoreCase("set") || args[0].equalsIgnoreCase("sæt")) {
                    player.sendMessage("§8- §8/§7Vagtlevel set§8/§7sæt §8(§7Spiller§8) §8(§7Antal§8)");
                    return true;
                } else if (args[0].equalsIgnoreCase("add") || args[0].equalsIgnoreCase("tilføj")) {
                    player.sendMessage("§8- §8/§7Vagtlevel add§8/§7tilføj §8(§7Spiller§8) §8(§7Antal§8)");
                    return true;
                } else if (args[0].equalsIgnoreCase("remove") || args[0].equalsIgnoreCase("fjern")) {
                    player.sendMessage("§8- §8/§7Vagtlevel remove§8/§7fjern §8(§7Spiller§8)");
                    return true;
                }
                player.sendMessage("§7Commands§8:");
                player.sendMessage("§8- §8/§7Vagtlevel set§8/§7sæt §8(§7Spiller§8) §8(§7Antal§8)");
                player.sendMessage("§8- §8/§7Vagtlevel add§8/§7tilføj §8(§7Spiller§8) §8(§7Antal§8)");
                player.sendMessage("§8- §8/§7Vagtlevel remove§8/§7fjern §8(§7Spiller§8)");
            } else if (args.length == 0) {
                VagtLevelMenu menu = new VagtLevelMenu(new PlayerManager(), new VagtLevelQuests());
                menu.openInventory(player);
                player.sendMessage("Du er i level " + manager.level.get(player.getUniqueId()));
            }
        }
        return false;
    }

    public static boolean isInt(String str) {
        try {
            @SuppressWarnings("unused")
            int x = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
