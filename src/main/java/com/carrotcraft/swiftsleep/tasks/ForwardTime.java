package com.carrotcraft.swiftsleep.tasks;

import com.carrotcraft.swiftsleep.Swiftsleep;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

public class ForwardTime extends BukkitRunnable {

    Swiftsleep plugin;

    private boolean nightTime;

    /** - Constructor */
    public ForwardTime(Swiftsleep plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {

        /** - Get the world the player is in */
        World _world = plugin.getServer().getWorld("world");

        /** - Get the world time */
        long time = _world.getTime();

        /** - Ensure the time is still night and continue */
        if(time >= 12010){

            /** - Increase the time by 200 ticks every tick */
            _world.setTime(time + 200);
        }
        else{

            /** - Cancel the task */
            this.cancel();
        }




    }
}
