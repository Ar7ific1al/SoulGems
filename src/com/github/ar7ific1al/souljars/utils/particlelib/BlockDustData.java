package com.github.ar7ific1al.souljars.utils.particlelib;

/**
 * BlockDustData class compliments of DarkBladee12
 * http://forums.bukkit.org/threads/lib-1-7-particleeffect-v1-3.154406/
 */

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class BlockDustData extends ParticleEffectData {
	private static final String FORMAT = "\\d+@\\d+(@\\d+(\\.\\d+)?){3}@\\d+@\\d+(\\.\\d+)?";
	private int id;
	private byte data;
	private float speed;

	public BlockDustData(int id, byte data, float offsetX, float offsetY, float offsetZ, int amount, float speed) {
		super(offsetX, offsetY, offsetZ, amount);
		this.id = id;
		this.data = data;
		this.speed = speed;
	}

	public static BlockDustData fromString(String s) throws IllegalArgumentException {
		if (!s.matches(FORMAT))
			throw new IllegalArgumentException("Invalid format");
		String[] p = s.split("@");
		return new BlockDustData(Integer.parseInt(p[0]), Byte.parseByte(p[1]), Float.parseFloat(p[2]), Float.parseFloat(p[3]), Float.parseFloat(p[4]), Integer.parseInt(p[5]), Float.parseFloat(p[6]));
	}

	@Override
	public void displayEffect(Location loc, Player... players) {
		ParticleEffect.displayBlockDust(loc, id, data, offsetX, offsetY, offsetZ, speed, amount, players);
	}

	@Override
	public void displayEffect(Location loc) {
		ParticleEffect.displayBlockDust(loc, id, data, offsetX, offsetY, offsetZ, speed, amount);
	}

	@Override
	public void displayEffect(Location loc, double range) {
		ParticleEffect.displayBlockDust(loc, range, id, data, offsetX, offsetY, offsetZ, speed, amount);
	}

	public int getId() {
		return this.id;
	}

	public byte getData() {
		return this.data;
	}

	public float getSpeed() {
		return this.speed;
	}

	@Override
	public String toString() {
		return id + "@" + data + "@" + super.toString() + "@" + speed;
	}
}