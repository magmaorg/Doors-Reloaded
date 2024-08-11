package de.jeff_media.doorsreloaded.config;

import de.jeff_media.doorsreloaded.Main;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    public static final String SOUND_KNOCK_WOOD = "sound-knock-wood";
    public static final String SOUND_KNOCK_IRON = "sound-knock-iron";
    public static final String SOUND_KNOCK_VOLUME = "sound-knock-volume";
    public static final String SOUND_KNOCK_PITCH = "sound-knock-pitch";
    public static final String SOUND_KNOCK_CATEGORY = "sound-knock-category";

    public static void init() {
        Main main = Main.getInstance();
        FileConfiguration conf = main.getConfig();
        conf.addDefault(SOUND_KNOCK_IRON, "ENTITY_ZOMBIE_ATTACK_IRON_DOOR");
        conf.addDefault(SOUND_KNOCK_WOOD, "ENTITY_ZOMBIE_ATTACK_WOODEN_DOOR");
        conf.addDefault(SOUND_KNOCK_CATEGORY, "BLOCKS");
        conf.addDefault(SOUND_KNOCK_VOLUME, 1.0);
        conf.addDefault(SOUND_KNOCK_PITCH, 1.0);
    }
}
