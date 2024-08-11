package de.jeff_media.doorsreloaded.listeners;

import com.google.common.base.Enums;

import de.jeff_media.doorsreloaded.Main;
import de.jeff_media.doorsreloaded.config.Config;

import org.bukkit.*;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Door;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class DoorListener implements Listener {
    private static void playKnockSound(Block block) {
        Main main = Main.getInstance();
        Sound sound =
                block.getType() == Material.IRON_DOOR
                        ? Enums.getIfPresent(
                                        Sound.class,
                                        main.getConfig().getString(Config.SOUND_KNOCK_IRON))
                                .or(Sound.ENTITY_ZOMBIE_ATTACK_IRON_DOOR)
                        : Enums.getIfPresent(
                                        Sound.class,
                                        main.getConfig().getString(Config.SOUND_KNOCK_WOOD))
                                .or(Sound.ITEM_SHIELD_BLOCK);
        SoundCategory category =
                Enums.getIfPresent(
                                SoundCategory.class,
                                main.getConfig().getString(Config.SOUND_KNOCK_CATEGORY))
                        .or(SoundCategory.BLOCKS);
        block.getWorld()
                .playSound(
                        block.getLocation(),
                        sound,
                        category,
                        (float) main.getConfig().getDouble(Config.SOUND_KNOCK_VOLUME),
                        (float) main.getConfig().getDouble(Config.SOUND_KNOCK_PITCH));
    }

    @EventHandler
    public void onDoorKnock(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        GameMode gameMode = player.getGameMode();
        if (gameMode == GameMode.CREATIVE || gameMode == GameMode.SPECTATOR) {
            return;
        }

        if (event.getAction() != Action.LEFT_CLICK_BLOCK) {
            return;
        }

        if (event.getHand() != EquipmentSlot.HAND) {
            return;
        }

        if (player.getInventory().getItemInMainHand().getType() != Material.AIR) {
            return;
        }

        Block block = event.getClickedBlock();
        if (!(block.getBlockData() instanceof Door)) {
            return;
        }

        playKnockSound(block);
    }
}
