package dev.crnyy.vagtsystem;

import dev.crnyy.vagtsystem.commands.VagtCommand;
import dev.crnyy.vagtsystem.files.Message;
import dev.crnyy.vagtsystem.plugins.signs.HealSign;
import dev.crnyy.vagtsystem.plugins.vagtbuffs.VagtBuffs;
import dev.crnyy.vagtsystem.plugins.vagtcoins.VagtCoinsMenu;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.SignManager;
import dev.crnyy.vagtsystem.files.Config;
import dev.crnyy.vagtsystem.files.Data;
import dev.crnyy.vagtsystem.placeholders.PlaceholderAPI;
import dev.crnyy.vagtsystem.plugins.ArmorManager;
import dev.crnyy.vagtsystem.plugins.PlayerManager;
import dev.crnyy.vagtsystem.plugins.repair.Repair;
import dev.crnyy.vagtsystem.plugins.vagtchat.VagtChat;
import dev.crnyy.vagtsystem.plugins.vagtchat.VagtChatCommand;
import dev.crnyy.vagtsystem.plugins.vagtcoins.VagtCoinsCommand;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.CVagtEnchantItemsListener;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.vagtenchant.CVagtEnchantListener;
import dev.crnyy.vagtsystem.plugins.vagtgearshop.CVagtShopListener;
import dev.crnyy.vagtsystem.plugins.vagtlevel.TestCommand;
import dev.crnyy.vagtsystem.plugins.vagtlevel.VagtLevel;
import dev.crnyy.vagtsystem.plugins.vagtlevel.VagtLevelCommand;
import dev.crnyy.vagtsystem.plugins.vagtlevel.VagtLevelQuests;
import dev.crnyy.vagtsystem.plugins.vagtmine.VagtMine;
import dev.crnyy.vagtsystem.plugins.vagtmine.VagtMineCommand;
import dev.crnyy.vagtsystem.plugins.vagtontime.VagtOntime;
import dev.crnyy.vagtsystem.plugins.vagtontime.VagtOntimeCommand;
import dev.crnyy.vagtsystem.utils.Messages;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Economy economy;
    private Config config;
    private Message message;

    @Override
    public void onEnable() {
        PlayerManager manager = new PlayerManager();
        if (!setupEconomy() ) {
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null){
            new PlaceholderAPI(this, manager).register();
        }

        this.config = new Config(this);
        this.message = new Message(this);


        this.getServer().getPluginManager().registerEvents(new SignManager(message), this);
        this.getCommand("vagt").setExecutor(new VagtCommand(config, message));

        //VagtGearShop og EnchantShop
        this.getServer().getPluginManager().registerEvents(new CVagtShopListener(this, new Messages(message), config), this);
        this.getServer().getPluginManager().registerEvents(new CVagtEnchantListener(), this);
        this.getServer().getPluginManager().registerEvents(new CVagtEnchantItemsListener(new ArmorManager()), this);

        //VagtChat
        this.getServer().getPluginManager().registerEvents(new VagtChat(new Messages(message)), this);
        this.getCommand("vagtchat").setExecutor(new VagtChatCommand());

        //VagtLevel
        this.getServer().getPluginManager().registerEvents(new VagtLevel(manager, new VagtLevelQuests()), this);
        this.getCommand("vagtlevel").setExecutor(new VagtLevelCommand(manager));
        this.getCommand("irons").setExecutor(new TestCommand(new VagtLevelQuests()));

        //VagtMine
        this.getCommand("spassermine").setExecutor(new VagtMineCommand(new VagtMine(), config));

        //VagtCoins
        this.getCommand("vagtcoins").setExecutor(new VagtCoinsCommand(manager, new VagtCoinsMenu()));

        //VagtOntime
        VagtOntime ontime = new VagtOntime(this);
        this.getCommand("ontime").setExecutor(new VagtOntimeCommand(this, ontime));
        this.getServer().getPluginManager().registerEvents(ontime, this);

        //Repair
        this.getServer().getPluginManager().registerEvents(new Repair(config, message, new Messages(message)), this); //Skal lige kigges på om config skal ind under?
        //VagtBuffs
        this.getServer().getPluginManager().registerEvents(new VagtBuffs(config, message), this);

        //Signs
        this.getServer().getPluginManager().registerEvents(new HealSign(config, message), this);

        //Files
        loadDataFile();
    }

    @Override
    public void onDisable() {

        saveDataFile();
        config.saveConfig();
    }

    private boolean setupEconomy() {
        final RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }

    public static Economy getEconomy() {

        return economy;
    }

    public void loadDataFile() {
        Data.setup();
    }

    public void saveDataFile() {
        Data.save();
    }
}
