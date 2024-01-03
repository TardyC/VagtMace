package dev.crnyy.vagtsystem.plugins.vagtlevel;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {
    private final VagtLevelQuests quests;
    public TestCommand(VagtLevelQuests quests) {
        this.quests = quests;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("irons")) {
            final Player player = (Player) sender;
            quests.setIronCollected(player, 32);
            player.sendMessage("du har afleveret 32");
            if (quests.getIronCollected(player) <= 32) {
                quests.ironIsCollected.put(player.getUniqueId(), true);
            }
        }
        return false;
    }
}
