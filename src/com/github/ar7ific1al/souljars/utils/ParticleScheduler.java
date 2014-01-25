package com.github.ar7ific1al.souljars.utils;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

import com.github.ar7ific1al.souljars.utils.particlelib.ParticleEffectData;

public class ParticleScheduler implements Runnable{
	
	private LivingEntity entity = null;
	private ParticleEffectData particleData = null;
	private int runCount = 0;
	
	public ParticleScheduler(LivingEntity e, ParticleEffectData d){
		entity = e;
		particleData = d;
	}
	
	public void run(){
		World w = Bukkit.getServer().getWorld(entity.getWorld().getUID());
		for(Entity e : w.getEntities()){
			if (e.getUniqueId() == entity.getUniqueId()){
				particleData.displayEffect(e.getLocation());
				runCount++;
			}
			if (runCount > 25){
				
			}
		}
	}
	
}
