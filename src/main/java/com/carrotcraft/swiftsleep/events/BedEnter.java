package com.carrotcraft.swiftsleep.events;

import com.carrotcraft.swiftsleep.Swiftsleep;
import com.carrotcraft.swiftsleep.tasks.ForwardTime;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.scheduler.BukkitTask;

import static org.bukkit.Bukkit.getServer;

public class BedEnter implements Listener {

    Swiftsleep plugin;

    public BedEnter(Swiftsleep plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onEnterBed(PlayerBedEnterEvent e){
        if(e.isCancelled()){
            return;
        }

        /** - Check if the player entered the bed successfully */
        if(e.getBedEnterResult() == PlayerBedEnterEvent.BedEnterResult.OK) {

            /** - love you */
            long time;

            /** - Raining boolean */
            boolean raining;

            /** - Get the player */
            Player _player = e.getPlayer();

            /** - Get the world the player is in */
            World _world = _player.getWorld();

            /** - Get the world time */
            time = _world.getTime();

            /** - Get if the world is raining */
            raining = _world.hasStorm();

            /** - Check if time is night for clear and rainy weather */
            if (((time >= 12010) && raining) || ((time >= 12542))) { //todo: redundant already check for ability to enter bed

                /** - Broadcast to the rest of the players that someone is skipping the night */
                getServer().broadcastMessage(ChatColor.DARK_GRAY + _player.getName() + ChatColor.WHITE + " is skipping the night");

                /** - Schedule a task to skip the night */
                BukkitTask skipNight = new ForwardTime(plugin).runTaskTimer(plugin, 40, 1);
            }
        }
        return;
    }
}
