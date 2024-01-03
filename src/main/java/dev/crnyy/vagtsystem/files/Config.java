package dev.crnyy.vagtsystem.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Config {

    private final JavaPlugin plugin;
    private File file;
    private FileConfiguration customFile;
    private YamlConfiguration config;

    public Config(JavaPlugin plugin) {
        this.plugin = plugin;
        setup();
    }

    private void setup() {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdirs();
        }

        file = new File(plugin.getDataFolder(), "config.yml");

        if (!file.exists()) {
            plugin.saveResource("config.yml", false);
        }

        customFile = YamlConfiguration.loadConfiguration(file);

        try {
            config = YamlConfiguration.loadConfiguration(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getConfig() {
        return customFile;
    }

    public void saveConfig() {
        try {
            customFile.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reloadConfig() {
        customFile = YamlConfiguration.loadConfiguration(file);
    }

}
