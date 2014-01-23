package com.github.ar7ific1al.souljars.souljarevents;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.github.ar7ific1al.souljars.souljars.SoulJar;

public class SoulJarFillEvent extends Event implements Cancellable {

	private Player player;
	private SoulJar souljar;
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

	public SoulJarFillEvent(Player player, SoulJar souljar) {
		this.player = player;
		this.souljar = souljar;
		this.isCancelled = false;
	}

}
