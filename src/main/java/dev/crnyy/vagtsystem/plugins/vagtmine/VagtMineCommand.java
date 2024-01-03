package dev.crnyy.vagtsystem.plugins.vagtmine;

import dev.crnyy.vagtsystem.files.Config;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VagtMineCommand implements CommandExecutor {

    private final VagtMine mine;
    private final Config config;
    public VagtMineCommand(VagtMine mine, Config config) {
        this.mine = mine;
        this.config = config;
    }

    public int blocksRemaining;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player player = (Player) sender;
        ItemUtils item = new ItemUtils();
        if (cmd.getName().equalsIgnoreCase("spassermine")) {
            if (args.length == 1) {
                if (!(args[0].isEmpty())) {
                    final Player player1 = Bukkit.getPlayer(args[0]);
                    if (player1 == null) {
                        return true;
                    }
                    blocksRemaining = config.getConfig().getInt("Spassermine.Antal-start-blocks");
                    player.sendMessage("Du har sendt " + player1.getName() + " i spasserminen.");
                    player1.sendMessage("Du er blevet sendt i spasserminen!");
                    mine.blocksMined.put(player1.getUniqueId(), 0);
                    mine.playersCurrentlyInMine.add(player1.getUniqueId());
                    player1.getInventory().addItem(item.pickaxe(player, blocksRemaining));
                    return true;
                }
            }
            player.sendMessage("Du skal skrive spillerens navn!");
        }

        return false;
    }
}
