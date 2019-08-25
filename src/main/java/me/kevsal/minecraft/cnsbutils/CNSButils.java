package me.kevsal.minecraft.cnsbutils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class CNSButils extends JavaPlugin {

    @Override
    public void onEnable(){
        // on plugin enable
        Bukkit.getServer().getLogger().info("CNSB Utilities Enabled");

        this.getCommand("sbutil-version").setExecutor(new CommandSBVersion(this));
    }
    public void onDisable(){
        // on plugin disable
        Bukkit.getServer().getLogger().info("CNSB Utilities disabled");
    }
}
