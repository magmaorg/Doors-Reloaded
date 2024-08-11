package de.jeff_media.doorsreloaded;

import de.jeff_media.doorsreloaded.commands.ReloadCommand;
import de.jeff_media.doorsreloaded.config.Config;
import de.jeff_media.doorsreloaded.listeners.DoorListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        Config.init();
        saveDefaultConfig();
        reloadConfig();
        Bukkit.getPluginManager().registerEvents(new DoorListener(), this);
        getCommand("doorsreloaded").setExecutor(new ReloadCommand());
    }
}
