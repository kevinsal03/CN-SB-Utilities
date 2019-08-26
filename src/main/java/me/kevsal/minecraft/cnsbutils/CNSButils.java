package me.kevsal.minecraft.cnsbutils;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class CNSButils extends JavaPlugin {

    public static Economy econ = null;

    @Override
    public void onEnable(){
        // on plugin enable

        if (!setupEconomy() ) {
            Bukkit.getServer().getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        Bukkit.getServer().getLogger().info("CNSB Utilities Enabled");

        //register the version command
        this.getCommand("cnsb-version").setExecutor(new CommandSBVersion(this));


        /* TODO: Eventually remove test command before going to prod! */
        // Test Commands
        this.getCommand("sbtest-baltake").setExecutor(new CommandEconTest(this));

    }
    public void onDisable(){
        // on plugin disable
        Bukkit.getServer().getLogger().info("CNSB Utilities disabled");
    }

    private boolean setupEconomy() {
        if(Bukkit.getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }



}
