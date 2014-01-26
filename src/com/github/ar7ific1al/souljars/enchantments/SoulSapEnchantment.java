package com.github.ar7ific1al.souljars.enchantments;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import com.github.ar7ific1al.souljars.souljarevents.SoulJarFillEvent;
import com.github.ar7ific1al.souljars.souljars.SoulJar;
import com.github.ar7ific1al.souljars.utils.particlelib.ParticleEffect;
import com.rit.sucy.CustomEnchantment;
import com.rit.sucy.EnchantmentAPI;

public class SoulSapEnchantment extends CustomEnchantment{
	
	static final Material[] SOULSAP_ITEMS = new Material[]{
		Material.WOOD_SWORD, Material.STONE_SWORD, Material.IRON_SWORD, Material.GOLD_SWORD, Material.DIAMOND_SWORD
	};
	
	public SoulSapEnchantment(){
		super("Soul Sap", SOULSAP_ITEMS, 1);
		
		this.max = 8;
		
		this.base = 5;
		
		this.interval = 3;
	}
	
	@Override
	public void applyEffect(LivingEntity user, LivingEntity target, int enchantLevel, EntityDamageByEntityEvent event){
		if (event.getDamage() < target.getHealth()){
			ParticleEffect.TOWN_AURA.display(target.getLocation(), 0.3f, 0.75f, 0.3f, 0, 300);
		}
	}
}
