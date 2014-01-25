package com.github.ar7ific1al.souljars.utils.particlelib;

/**
 * IconCrackData class compliments of DarkBladee12
 * http://forums.bukkit.org/threads/lib-1-7-particleeffect-v1-3.154406/
 */

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class IconCrackData extends ParticleEffectData {
	private static final String FORMAT = "\\d+(@\\d+(\\.\\d+)?){3}@\\d+@\\d+(\\.\\d+)?";
	private int id;
	private float speed;

	public IconCrackData(int id, float offsetX, float offsetY, float offsetZ, int amount, float speed) {
		super(offsetX, offsetY, offsetZ, amount);
		this.id = id;
		this.speed = speed;
	}

	public static IconCrackData fromString(String s) throws IllegalArgumentException {
		if (!s.matches(FORMAT))
			throw new IllegalArgumentException("Invalid format");
		String[] p = s.split("@");
		return new IconCrackData(Integer.parseInt(p[0]), Float.parseFloat(p[1]), Float.parseFloat(p[2]), Float.parseFloat(p[3]), Integer.parseInt(p[4]), Float.parseFloat(p[5]));
	}

	@Override
	public void displayEffect(Location loc, Player... players) {
		ParticleEffect.displayIconCrack(loc, id, offsetX, offsetY, offsetZ, speed, amount, players);
	}

	@Override
	public void displayEffect(Location loc) {
		ParticleEffect.displayIconCrack(loc, id, offsetX, offsetY, offsetZ, speed, amount);
	}

	@Override
	public void displayEffect(Location loc, double range) {
		ParticleEffect.displayIconCrack(loc, range, id, offsetX, offsetY, offsetZ, speed, amount);
	}

	public int getId() {
		return this.id;
	}

	public float getSpeed() {
		return this.speed;
	}

	@Override
	public String toString() {
		return id + "@" + super.toString() + "@" + speed;
	}
}