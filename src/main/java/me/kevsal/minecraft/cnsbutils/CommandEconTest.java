package me.kevsal.minecraft.cnsbutils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandEconTest implements CommandExecutor {

    private final CNSButils plugin;

    public CommandEconTest(CNSButils plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            //check for args
            if(args.length != 1) {
                return false;
            }

            //get the amount the balance is to be changed by
            int balChange = Integer.parseInt(args[0]);

            if (balChange <= 0) {
                p.sendMessage("Must be a positive number and not 0.");
                return true;
            }


            //check if player has enough money
            double bal = plugin.econ.getBalance(p);

            if (bal - balChange < 0) {
                p.sendMessage(ChatColor.RED + "Not enough money!");

                return true;
            } else {
                //update the balance
                plugin.econ.withdrawPlayer(p, balChange);

            }

            p.sendMessage("Adjusted balance by: -" + balChange);

        } else {
            sender.sendMessage("Must be player.");
        }



        return true;
    }
}
