package com.github.ar7ific1al.souljars.utils.particlelib;

/**
 * NormalEffectData class compliments of DarkBladee12
 * http://forums.bukkit.org/threads/lib-1-7-particleeffect-v1-3.154406/
 */

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class NormalEffectData extends ParticleEffectData {
	private static final String FORMAT = "\\w+(@\\d+(\\.\\d+)?){3}@\\d+@\\d+(\\.\\d+)?";
	private ParticleEffect effect;
	private float speed;

	public NormalEffectData(ParticleEffect effect, float offsetX, float offsetY, float offsetZ, int amount, float speed) {
		super(offsetX, offsetY, offsetZ, amount);
		this.effect = effect;
		this.speed = speed;
	}

	public static NormalEffectData fromString(String s) throws IllegalArgumentException {
		if (!s.matches(FORMAT))
			throw new IllegalArgumentException("Invalid format");
		String[] p = s.split("@");
		ParticleEffect effect = ParticleEffect.fromName(p[0]);
		if (effect == null)
			throw new IllegalArgumentException("Contains an invalid particle effect name");
		return new NormalEffectData(effect, Float.parseFloat(p[1]), Float.parseFloat(p[2]), Float.parseFloat(p[3]), Integer.parseInt(p[4]), Float.parseFloat(p[5]));
	}

	@Override
	public void displayEffect(Location loc, Player... players) {
		effect.display(loc, offsetX, offsetY, offsetZ, speed, amount, players);
	}

	@Override
	public void displayEffect(Location loc) {
		effect.display(loc, offsetX, offsetY, offsetZ, speed, amount);
	}

	@Override
	public void displayEffect(Location loc, double range) {
		effect.display(loc, range, offsetX, offsetY, offsetZ, speed, amount);
	}

	public ParticleEffect getEffect() {
		return this.effect;
	}

	public float getSpeed() {
		return this.speed;
	}

	@Override
	public String toString() {
		return effect.getName() + "@" + super.toString() + "@" + speed;
	}
}