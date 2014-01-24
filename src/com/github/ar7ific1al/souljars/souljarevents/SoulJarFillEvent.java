package com.github.ar7ific1al.souljars.souljarevents;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.github.ar7ific1al.souljars.souljars.SoulJar;

public class SoulJarFillEvent extends Event implements Cancellable {

	private Player player;
	private SoulJar souljar;
	private Entity entity;
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

	public SoulJarFillEvent(Player player, SoulJar souljar, Entity entity) {
		this.player = player;
		this.entity = entity;
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
				ItemMeta meta = stack.getItemMeta();
				if (meta.getLore().contains("\u00A77Empty") && meta.getDisplayName().contains("\u00A7bSoul Jar")){
							SoulJar.takeEmptySoulJar(player, 1);
							SoulJar filledSoulJar = new SoulJar(entity.getType());
							filledSoulJar.giveFilledSoulJar(player);
				}
			}
			else{
				this.setCancelled(true);
			}
		}
	}

}
