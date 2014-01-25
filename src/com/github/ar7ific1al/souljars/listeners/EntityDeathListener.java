package com.github.ar7ific1al.souljars.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import com.github.ar7ific1al.souljars.Plugin;
import com.github.ar7ific1al.souljars.souljarevents.SoulJarFillEvent;
import com.github.ar7ific1al.souljars.souljars.SoulJar;
import com.github.ar7ific1al.souljars.utils.Log;
import com.rit.sucy.EnchantmentAPI;

public class EntityDeathListener implements Listener{
	
	Plugin plugin;
	
	public EntityDeathListener(Plugin instance){
		plugin = instance;
		Log.LogMessage(ChatColor.LIGHT_PURPLE + "[SoulGems' Entity Death Listener Registered.", Bukkit.getConsoleSender());
	}
	
	@EventHandler
	public void onEntityDeath(EntityDeathEvent event){
		Entity entity = event.getEntity();
		if (!entity.getType().equals(EntityType.PLAYER)){
			if (entity.getLastDamageCause() instanceof EntityDamageByEntityEvent){
				EntityDamageByEntityEvent damageEvent = (EntityDamageByEntityEvent) entity.getLastDamageCause();
				if (damageEvent.getDamager() instanceof Player || damageEvent.getDamager() instanceof Projectile){
					Player player = null;
					Projectile projectile;
					if (damageEvent.getDamager() instanceof Player){
						player = (Player) damageEvent.getDamager();
					}
					else if (damageEvent.getDamager() instanceof Projectile){
						projectile = (Projectile) damageEvent.getDamager();
						if (projectile.getShooter() instanceof Player){
							player = (Player) projectile.getShooter();
						}
						else{
							return;
						}
					}
					if (EnchantmentAPI.itemHasEnchantment(player.getItemInHand(), "Soul Sap")){
						SoulJarFillEvent soulJarFillEvent = new SoulJarFillEvent(player, new SoulJar(), event.getEntity());
						plugin.getServer().getPluginManager().callEvent(soulJarFillEvent);
					}
				}
			}
		}
	}

}
