package dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant;

import dev.crnyy.vagtsystem.Main;
import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.files.Message;
import dev.crnyy.vagtsystem.plugins.ArmorManager;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.UUID;

public class CVagtEnchantItemsListener implements Listener {

    private final ArmorManager armorManager;
    private final Config config;
    private final Message message;
    public  CVagtEnchantItemsListener(ArmorManager armorManager, Config config, Message message) {
        this.armorManager = armorManager;
        this.config = config;
        this.message = message;
    }

    private Economy economy = Main.economy;


    /**
     * Skal fixes, lore kan kun ændres 1 gang, hashmap fix!
     * @param e
     */
    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        final Player player = (Player) e.getWhoClicked();
        final double balance = economy.getBalance(player);
        CVagtEnchantItems items = new CVagtEnchantItems();
        CVagtEnchantMenu menu = new CVagtEnchantMenu();
        final InventoryView view = player.getOpenInventory();
        final Inventory topInventory = view.getTopInventory();
        if (view == null) {
            return;
        }
        if (player == null) {
            return;
        }
        if (e.getClickedInventory() == null) {
            return;
        }
        if (topInventory == null) {
            return;
        }
        if (topInventory.getName().equals("Enchant Hjelm") || topInventory.getName().equals("Enchant Brystplade") || topInventory.getName().equals("Enchant Bukser") || topInventory.getName().equals("Enchant Sko") || topInventory.getName().equals("Enchant Sværd") || topInventory.getName().equals("Enchant Bue")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
        }
        if (e.getClickedInventory().getName().equals("Enchant Hjelm") || e.getClickedInventory().getName().equals("Enchant Brystplade") || e.getClickedInventory().getName().equals("Enchant Bukser") || e.getClickedInventory().getName().equals("Enchant Sko") || e.getClickedInventory().getName().equals("Enchant Sværd") || e.getClickedInventory().getName().equals("Enchant Bue")) {
            if (e.getCursor().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() != Material.AIR) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() == Material.INK_SACK) {
                if (e.getCurrentItem().hasItemMeta()) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lTILBAGE")) {
                        e.setCancelled(true);
                        menu.openInventory(player);
                    }
                }
            }
            switch (e.getCurrentItem().getType()) {
                case GOLD_HELMET:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cVagt Hjelm")) {
                            e.setCancelled(true);
                            ItemStack helmet = player.getInventory().getHelmet();
                            if (helmet == null || helmet.getItemMeta() == null) {
                                return;
                            }
                            ItemMeta itemMeta = helmet.getItemMeta();
                            List<String> currentLore = itemMeta.getLore();
                            String lore1 = currentLore.get(3);
                            String lore2 = lore1.replaceAll("[^0-9]", "");
                            int protection = Integer.parseInt(lore2);
                            if (currentLore == null) {
                                return;
                            }
                            UUID playerId = player.getUniqueId();
                            if (!armorManager.cHelmet.containsKey(player.getUniqueId())) {
                                armorManager.cHelmet.put(player.getUniqueId(), 0);
                            }
                            //int protection = armorManager.cHelmet.get(player.getUniqueId());
                            if (protection < 4) {
                                int cost = calculateEnchantCost(protection);
                                if (balance >= cost) {
                                    protection++;
                                    currentLore.set(3, "§8- §7Protection§8: §f" + protection);
                                    itemMeta.setLore(currentLore);
                                    helmet.setItemMeta(itemMeta);
                                    player.getInventory().setHelmet(helmet);
                                    e.setCurrentItem(helmet);
                                    player.sendMessage("Du købte protection " + protection);
                                    economy.withdrawPlayer(player, cost);
                                    armorManager.cHelmet.put(player.getUniqueId(), protection);
                                } else {
                                    player.sendMessage("Du har ikke nok penge til dette.");
                                    player.closeInventory();
                                }
                            } else {
                                player.sendMessage("Du har allerede maks proctection!");
                                player.closeInventory();
                                armorManager.cHelmet.remove(player.getUniqueId());
                            }
                        }
                    }
                    break;

                case IRON_CHESTPLATE:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cVagt Brystplade")) {
                            e.setCancelled(true);

                        }
                    }
                    break;
                case IRON_LEGGINGS:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cVagt Bukser")) {
                            e.setCancelled(true);

                        }
                    }
                    break;
                case IRON_BOOTS:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cVagt Sko")) {
                            e.setCancelled(true);

                        }
                    }
                    break;
                case IRON_SWORD:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cVagt Sværd")) {
                            e.setCancelled(true);

                        }
                    }
                    break;
                case BOW:
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cVagt Bue")) {
                            e.setCancelled(true);

                        }
                    }
                    break;
            }
        }
    }
    private int calculateEnchantCost(int protectionLevel) {
        switch (protectionLevel) {
            case 1:
                return config.getConfig().getInt("VagtEnchant.C.protection-1");
            case 2:
                return config.getConfig().getInt("VagtEnchant.C.protection-2");
            case 3:
                return config.getConfig().getInt("VagtEnchant.C.protection-3");
            case 4:
                return config.getConfig().getInt("VagtEnchant.C.protection-4");
        }
        return protectionLevel;
    }
}
