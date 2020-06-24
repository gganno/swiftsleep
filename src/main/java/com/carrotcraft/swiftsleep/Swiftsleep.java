package com.carrotcraft.swiftsleep;

import com.carrotcraft.swiftsleep.events.BedEnter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Swiftsleep extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        /** - Register for bed enter event */
        getServer().getPluginManager().registerEvents(new BedEnter(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
