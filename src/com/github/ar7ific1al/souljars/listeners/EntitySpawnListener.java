package com.github.ar7ific1al.souljars.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import com.github.ar7ific1al.souljars.Plugin;

public class EntitySpawnListener implements Listener{

	Plugin plugin;
	
	public EntitySpawnListener(Plugin instance){
		plugin = instance;
	}
	
	@EventHandler
	public void onEntitySpawn(CreatureSpawnEvent event){
		
	}
	
}
