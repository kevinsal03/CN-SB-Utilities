package me.kevsal.minecraft.cnsbutils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSBVersion implements CommandExecutor {

    private final CNSButils plugin;

    public CommandSBVersion(CNSButils plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof  Player) {
            Player p = (Player) sender;
            if (p.hasPermission("cnsb.version")) {
                p.sendMessage("Version: " + plugin.getDescription().getVersion());
            } else {
                p.sendMessage(ChatColor.RED + "Access denied.");
            }
        } else {
            sender.sendMessage("Must be a player.");
        }

        return false;
    }
}
