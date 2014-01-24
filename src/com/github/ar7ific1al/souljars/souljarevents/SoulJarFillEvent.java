package com.github.ar7ific1al.souljars.souljarevents;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.github.ar7ific1al.souljars.souljars.SoulJar;
import com.github.ar7ific1al.souljars.souljars.SoulJar.Type;
import com.github.ar7ific1al.souljars.utils.SJUtils;

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
	
	private Player getPlayer(){
		return this.player;
	}
	private SoulJar getSoulJar(){
		return this.souljar;
	}
	private Entity getEntity(){
		return this.entity;
	}

	public SoulJarFillEvent(Player player, SoulJar souljar, Entity entity) {
		this.player = player;
		this.souljar = souljar;
		this.isCancelled = false;
		Inventory inventory = player.getInventory();
		try{
			for(ItemStack stack : inventory){
				if (stack.getType().equals(Material.GLASS_BOTTLE)){
					ItemStack emptyjar = stack;
					ItemMeta meta = stack.getItemMeta();
					if (meta.getLore().contains("\u00A77Empty") && meta.getDisplayName().contains("\u00A7bSoul Jar")){
						for(ItemStack content : inventory.getContents()){
							if (content == null){
								if (emptyjar.getAmount() > 1){
									emptyjar.setAmount(emptyjar.getAmount() - 1);
								}
								else{
									inventory.remove(emptyjar);
								}
								SoulJar filledSoulJar = new SoulJar();
								SoulJar.giveFilledSoulJar(player, entity);
								break;
							}
						}
						break;
					}
				}
				else{
					this.setCancelled(true);
				}
			}
		}catch(Exception e){
			
		}
	}

}
