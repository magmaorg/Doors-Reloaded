package de.jeff_media.doorsreloaded.commands;

import de.jeff_media.doorsreloaded.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {
    private final Main main;

    public ReloadCommand() {
        main = Main.getInstance();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if (!sender.hasPermission("doorsreloaded.reload")) {
            sender.sendMessage(command.getPermissionMessage());
            return true;
        }

        main.saveDefaultConfig();
        main.reloadConfig();

        sender.sendMessage(ChatColor.GREEN + "DoorsReloaded configuration has been reloaded.");

        return true;
    }
}
