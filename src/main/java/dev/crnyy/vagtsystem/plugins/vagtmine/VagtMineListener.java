package dev.crnyy.vagtsystem.plugins.vagtmine;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class VagtMineListener implements Listener {

    private final VagtMine mine;
    public VagtMineListener(VagtMine mine) {
        this.mine = mine;
    }

    @EventHandler
    public void onPlayerCommandExecute(PlayerCommandPreprocessEvent e) {

    }
    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent e) {




    }
}
