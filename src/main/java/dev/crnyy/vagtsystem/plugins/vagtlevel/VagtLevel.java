package dev.crnyy.vagtsystem.plugins.vagtlevel;

import dev.crnyy.vagtsystem.plugins.PlayerManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class VagtLevel implements Listener {

    private final PlayerManager manager;
    private final VagtLevelQuests quests;
    public VagtLevel(PlayerManager manager, VagtLevelQuests quests) {
        this.manager = manager;
        this.quests = quests;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        final Player player = e.getPlayer();
        if (!(player.hasPermission("vagt"))) {
            return;
        }
        if (!(manager.level.containsKey(player.getUniqueId()))) {
           manager.setLevel(player, 1);
        }
        if (!(quests.ironIsCollected.containsKey(player.getUniqueId()))) {
            quests.ironIsCollected.put(player.getUniqueId(), false);
            quests.ironCollected.put(player.getUniqueId(), 0);
        }
    }


    /**
     *
     * Quest system til level
     *
     *
     *
     */

}
