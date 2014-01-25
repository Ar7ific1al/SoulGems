package com.github.ar7ific1al.souljars.utils.particlelib;

/**
 * ParticleEffectData class compliments of DarkBladee12
 * http://forums.bukkit.org/threads/lib-1-7-particleeffect-v1-3.154406/
 */

import org.bukkit.Location;
import org.bukkit.entity.Player;

public abstract class ParticleEffectData {
	protected float offsetX, offsetY, offsetZ;
	protected int amount;

	public ParticleEffectData(float offsetX, float offsetY, float offsetZ, int amount) {
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		this.offsetZ = offsetZ;
		this.amount = amount;
	}

	public abstract void displayEffect(Location loc, Player... players);

	public abstract void displayEffect(Location loc);

	public abstract void displayEffect(Location loc, double range);

	public float getOffsetX() {
		return this.offsetX;
	}

	public float getOffsetY() {
		return this.offsetY;
	}

	public float getOffsetZ() {
		return this.offsetZ;
	}

	public int getAmount() {
		return this.amount;
	}

	@Override
	public String toString() {
		return offsetX + "@" + offsetY + "@" + offsetZ + "@" + amount;
	}
}