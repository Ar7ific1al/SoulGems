package com.github.ar7ific1al.souljars.utils.particlelib;

/**
 * BlockCrackData class compliments of DarkBladee12
 * http://forums.bukkit.org/threads/lib-1-7-particleeffect-v1-3.154406/
 */

import org.bukkit.Location;
import org.bukkit.entity.Player;


public class BlockCrackData extends ParticleEffectData {
	private static final String FORMAT = "\\d+@\\d+(@\\d+(\\.\\d+)?){3}@\\d+";
	private int id;
	private byte data;

	public BlockCrackData(int id, byte data, float offsetX, float offsetY, float offsetZ, int amount) {
		super(offsetX, offsetY, offsetZ, amount);
		this.id = id;
		this.data = data;
	}

	public static BlockCrackData fromString(String s) throws IllegalArgumentException {
		if (!s.matches(FORMAT))
			throw new IllegalArgumentException("Invalid format");
		String[] p = s.split("@");
		return new BlockCrackData(Integer.parseInt(p[0]), Byte.parseByte(p[1]), Float.parseFloat(p[2]), Float.parseFloat(p[3]), Float.parseFloat(p[4]), Integer.parseInt(p[5]));
	}

	@Override
	public void displayEffect(Location loc, Player... players) {
		ParticleEffect.displayBlockCrack(loc, id, data, offsetX, offsetY, offsetZ, amount, players);
	}

	@Override
	public void displayEffect(Location loc) {
		ParticleEffect.displayBlockCrack(loc, id, data, offsetX, offsetY, offsetZ, amount);
	}

	@Override
	public void displayEffect(Location loc, double range) {
		ParticleEffect.displayBlockCrack(loc, range, id, data, offsetX, offsetY, offsetZ, amount);
	}

	public int getId() {
		return this.id;
	}

	public byte getData() {
		return this.data;
	}

	@Override
	public String toString() {
		return id + "@" + data + "@" + super.toString();
	}
}