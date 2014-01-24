package com.github.ar7ific1al.souljars.souljars;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.WordUtils;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.github.ar7ific1al.souljars.utils.SJUtils;

public class SoulJar {
	
	private String name;
	private Type type;
	private int value;
	private ItemStack souljar;
	
	public enum Type{
		ZOMBIE,
		CREEPER,
		SKELETON,
		SPIDER,
		CAVESPIDER,
		SLIME,
		SILVERFISH,
		WITCH,
		ENDERMAN,
		GIANT,
		GHAST,
		PIGZOMBIE,
		BLAZE,
		WITHER,
		WITHERSKELETON,
		MAGMASLIME,
		ENDERDRAGON,
		PIG,
		CHICKEN,
		COW,
		MOOSHROOM,
		SHEEP,
		SQUID,
		WOLF,
		HORSE,
		BAT,
		SNOWMAN,
		OCELOT,
		IRONGOLEM,
		VILLAGER,
		HUMAN,
		EMPTY
	}
	
	public Type getType(){
		return type;
	}	
	public void setType(Type type){
		this.type = type;
	}
		
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public SoulJar(){
		this.type = Type.EMPTY;
	}
	
	public SoulJar(EntityType entityType){
		switch(entityType){
		case CREEPER:
			this.type = Type.CREEPER;
			break;
		case SKELETON:
			this.type = Type.SKELETON;
			break;
		case SPIDER:
			this.type = Type.SPIDER;
			break;
		case ZOMBIE:
			this.type = Type.ZOMBIE;
			break;
		case SLIME:
			this.type = Type.SLIME;
			break;
		case GHAST:
			this.type = Type.GHAST;
			break;
		case PIG_ZOMBIE:
			this.type = Type.PIGZOMBIE;
			break;
		case ENDERMAN:
			this.type = Type.ENDERMAN;
			break;
		case CAVE_SPIDER:
			this.type = Type.CAVESPIDER;
			break;
		case SILVERFISH:
			this.type = Type.SILVERFISH;
			break;
		case BLAZE:
			this.type = Type.BLAZE;
			break;
		case MAGMA_CUBE:
			this.type = Type.MAGMASLIME;
			break;
		case ENDER_DRAGON:
			this.type = Type.ENDERDRAGON;
			break;
		case WITHER:
			this.type = Type.WITHER;
			break;
		case BAT:
			this.type = Type.BAT;
			break;
		case WITCH:
			this.type = Type.WITCH;
			break;
		case PIG:
			this.type = Type.PIG;
			break;
		case SHEEP:
			this.type = Type.SHEEP;
			break;
		case COW:
			this.type = Type.COW;
			break;
		case CHICKEN:
			this.type = Type.CHICKEN;
			break;
		case SQUID:
			this.type = Type.SQUID;
			break;
		case WOLF:
			this.type = Type.WOLF;
			break;
		case MUSHROOM_COW:
			this.type = Type.MOOSHROOM;
			break;
		case SNOWMAN:
			this.type = Type.SNOWMAN;
			break;
		case OCELOT:
			this.type = Type.OCELOT;
			break;
		case IRON_GOLEM:
			this.type = Type.IRONGOLEM;
			break;
		case VILLAGER:
			this.type = Type.VILLAGER;
			break;
		case PLAYER:
			this.type = Type.HUMAN;
			break;
		}
	}
	
	public static void giveEmptySoulJar(Player player){
		Inventory inv = player.getInventory();
		for(ItemStack stack : inv.getContents()){
			if (stack == null){
				ItemStack emptySoulJar = new ItemStack(Material.GLASS_BOTTLE, 1, (short) 0);
				ItemMeta meta = emptySoulJar.getItemMeta();
				List<String> lore = Arrays.asList(SJUtils.ColorMessage("&7Empty"));
				meta.setDisplayName(SJUtils.ColorMessage("&bSoul Jar"));
				meta.setLore(lore);
				emptySoulJar.setItemMeta(meta);
				inv.addItem(emptySoulJar);
				break;
			}
		}
	}
	
	public static void giveFilledSoulJar(Player player, Entity entity){
		Inventory inv = player.getInventory();
		for(ItemStack stack : inv.getContents()){
			if (stack == null){
				ItemStack filledSoulJar = new ItemStack(Material.POTION, 1, (short) 0);
				ItemMeta meta = filledSoulJar.getItemMeta();
				String entityName = entity.getType().toString().replaceAll("_", " ");
				entityName = WordUtils.capitalizeFully(entity.getType().toString());
				List<String> lore = Arrays.asList(SJUtils.ColorMessage("&7" + entityName + " Soul"));
				meta.setDisplayName(SJUtils.ColorMessage("&bSoul Jar"));
				meta.setLore(lore);
				filledSoulJar.setItemMeta(meta);
				inv.addItem(filledSoulJar);
				break;
			}
		}
	}
	
}
