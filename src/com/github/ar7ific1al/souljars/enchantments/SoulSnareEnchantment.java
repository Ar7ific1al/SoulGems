package com.github.ar7ific1al.souljars.enchantments;

import org.bukkit.Material;

import com.rit.sucy.CustomEnchantment;

public class SoulSnareEnchantment extends CustomEnchantment{
	
	static final Material[] SOULSNARE_ITEMS = new Material[]{
		Material.GLASS_BOTTLE, Material.POTION
	};
	
	
	public SoulSnareEnchantment(){
		super("Soul Snare", SOULSNARE_ITEMS, 0);
		
		this.max = 5;
		
		this.base = 10;
		
		this.interval = 5;
	}
	
}
