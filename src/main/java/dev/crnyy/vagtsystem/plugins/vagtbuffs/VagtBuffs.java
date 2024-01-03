package dev.crnyy.vagtsystem.plugins.vagtbuffs;

import dev.crnyy.vagtsystem.Main;
import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.files.Message;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class VagtBuffs implements Listener {
    private final Config config;
    private final Message message;

    public VagtBuffs(Config config, Message message) {
        this.config = config;
        this.message = message;
    }
    @EventHandler
    public void onBuffclick(PlayerInteractEvent e) {
        String configWorld = config.getConfig().getString("Worlds.C", "world");
        String bWorld = config.getConfig().getString("Worlds.B");
        String aWorld = config.getConfig().getString("Worlds.A");
        Player player = e.getPlayer();
        Block block = e.getClickedBlock();
        World world = e.getPlayer().getWorld();
        if (block != null && block.getType() == Material.WALL_SIGN) {
            Sign sign = (Sign) block.getState();
            if (sign.getLine(0).equalsIgnoreCase(message.getMessages().getString("buffsign.text.1st"))) {
                if (sign.getLine(1).equalsIgnoreCase(message.getMessages().getString("buffsign.text.2nd"))) {
                    if (sign.getLine(2).equalsIgnoreCase(message.getMessages().getString("buffsign.text.3nd"))) {
                        if (sign.getLine(3).equalsIgnoreCase(message.getMessages().getString("buffsign.text.4nd"))) {
                            if (player.getWorld().getName().equalsIgnoreCase(aWorld)) {
                                player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 10000, config.getConfig().getInt("Vagtbuffs.C.Absorption")));
                                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, config.getConfig().getInt("Vagtbuffs.C.Speed")));
                                player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10000, config.getConfig().getInt("Vagtbuffs.C.Strength")));
                                player.sendMessage(message.getMessages().getString("vagtsign.buffs"));
                            } else if (player.getWorld().getName().equalsIgnoreCase(bWorld)) {
                                player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 10000, config.getConfig().getInt("Vagtbuffs.B.Absorption")));
                                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, config.getConfig().getInt("Vagtbuffs.B.Speed")));
                                player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10000, config.getConfig().getInt("Vagtbuffs.B.Strength")));
                                player.sendMessage(message.getMessages().getString("vagtsign.buffs"));
                            } else if (player.getWorld().getName().equalsIgnoreCase(configWorld)) {
                                player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 10000, config.getConfig().getInt("Vagtbuffs.A.Absorption")));
                                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, config.getConfig().getInt("Vagtbuffs.A.Speed")));
                                player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10000, config.getConfig().getInt("Vagtbuffs.A.Strength")));
                                player.sendMessage(message.getMessages().getString("vagtsign.buffs"));
                            }
                        }
                    }

                }
            }


        }
    }
}

