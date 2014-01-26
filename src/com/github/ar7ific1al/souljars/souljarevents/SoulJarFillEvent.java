package com.github.ar7ific1al.souljars.souljarevents;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.github.ar7ific1al.souljars.souljars.SoulJar;
import com.github.ar7ific1al.souljars.utils.particlelib.ParticleEffect;
import com.rit.sucy.EnchantmentAPI;

public class SoulJarFillEvent extends Event implements Cancellable {

	private Player player;
	private SoulJar souljar;
	private Entity entity;
	private Location entityLocation;
	private boolean isCancelled;

	@Override
	public boolean isCancelled() {
		return this.isCancelled;
	}

	@Override
	public void setCancelled(boolean arg0) {
		this.isCancelled = arg0;
	}

	private static final HandlerList handlers = new HandlerList();

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
	
	@SuppressWarnings("unused")
	private Player getPlayer(){
		return this.player;
	}
	@SuppressWarnings("unused")
	private SoulJar getSoulJar(){
		return this.souljar;
	}
	@SuppressWarnings("unused")
	private Entity getEntity(){
		return this.entity;
	}
	
	@SuppressWarnings("unused")
	private Location getLocation(){
		return this.entityLocation;
	}

	public SoulJarFillEvent(Player player, SoulJar souljar, Entity entity) {
		this.player = player;
		this.entity = entity;
		this.entityLocation = entity.getLocation();
		this.souljar = souljar;
		this.isCancelled = false;
		Inventory inventory = player.getInventory();
		if (inventory.containsAtLeast(this.souljar.getItemStack(), 1)){
			boolean hasEmptySlot = false;
			for(ItemStack is : inventory.getContents()){
				if (is == null){
					hasEmptySlot = true;
				}
			}
			if (hasEmptySlot){
				ItemStack stack = this.souljar.getItemStack();
				if (EnchantmentAPI.itemHasEnchantment(stack, "Soul Snare")){
					SoulJar.takeEmptySoulJar(player, 1);
					SoulJar filledSoulJar = new SoulJar(entity.getType());
					filledSoulJar.giveFilledSoulJar(player);
					entity.getWorld().playSound(entity.getLocation(), Sound.ZOMBIE_REMEDY, 0.75f, 2f);
					ParticleEffect.WITCH_MAGIC.display(entity.getLocation(), 0.3f, 0.75f, 0.3f, 25, 200);
				}
			}
			else{
				this.setCancelled(true);
			}
		}
		else{
			ParticleEffect.SPELL.display(entity.getLocation(), 0.15f, 0.75f, 0.15f, 1, 150);
			this.setCancelled(true);
		}
	}

}
