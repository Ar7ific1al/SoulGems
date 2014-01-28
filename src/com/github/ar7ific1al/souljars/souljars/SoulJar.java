package com.github.ar7ific1al.souljars.souljars;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.WordUtils;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.github.ar7ific1al.souljars.utils.SJUtils;
import com.rit.sucy.EnchantmentAPI;

public class SoulJar {
	
	private Type type;
	private ItemStack souljar;
	private ItemMeta meta;
	
	//	SoulJar Type enum; if it's not on this list, it's invalid!
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
	
	//	Get and set the Type associated with this SoulJar object
	public Type getType(){
		return type;
	}	
	public void setType(Type type){
		this.type = type;
	}
	
	//	Get the ItemStack associated with this SoulJar object
	public ItemStack getItemStack(){
		return this.souljar;
	}
	
	//	Constructor; create a single empty Soul Jar
	public SoulJar(){
		this.type = Type.EMPTY;
		this.souljar = new ItemStack(Material.GLASS_BOTTLE, 1);
		this.meta = souljar.getItemMeta();
		this.meta.setDisplayName(SJUtils.ColorMessage("&bSoul Jar"));
		List<String> lore = Arrays.asList(SJUtils.ColorMessage("&7Empty"));
		this.meta.setLore(lore);
		this.souljar.setItemMeta(this.meta);
		EnchantmentAPI.getEnchantment("Soul Snare").addToItem(this.souljar, 1);
	}
	
	//	Constructor; create 'count' empty Soul Jars
	public SoulJar(int count){
		this.type = Type.EMPTY;
		this.souljar = new ItemStack(Material.GLASS_BOTTLE, count);
		this.meta = souljar.getItemMeta();
		this.meta.setDisplayName(SJUtils.ColorMessage("&bSoul Jar"));
		List<String> lore = Arrays.asList(SJUtils.ColorMessage("&7Empty"));
		this.meta.setLore(lore);
		this.souljar.setItemMeta(this.meta);
		EnchantmentAPI.getEnchantment("Soul Snare").addToItem(this.souljar, 1);
	}
	
	//	Constructor; create a filled Soul Jar
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

		this.souljar = new ItemStack(Material.POTION, 1);
		this.meta = this.souljar.getItemMeta();
		this.meta.setDisplayName(SJUtils.ColorMessage("&bSoul Jar"));
		String soulName = entityType.toString();
		soulName = soulName.replaceAll("[_]", " ");
		soulName = WordUtils.capitalizeFully(soulName);
		List<String> lore = Arrays.asList(SJUtils.ColorMessage("&7" + soulName));
		this.meta.setLore(lore);
		this.souljar.setItemMeta(this.meta);
		EnchantmentAPI.getEnchantment("Soul Snare").addToItem(this.souljar, 5);
	}
	
	//	Give the player an empty Soul Jar; Careful, it can also be used when you should be giving a filled Soul Jar...
	public static void giveEmptySoulJar(Player player, int count){
		Inventory inv = player.getInventory();
		for(ItemStack stack : inv.getContents()){
			if (stack == null){
				SoulJar emptysouljar = new SoulJar(count);
				EnchantmentAPI.getEnchantment("Soul Snare").addToItem(emptysouljar.souljar, 1);
				inv.addItem(emptysouljar.souljar);
				break;
			}
		}
	}
	
	//	Give the player the current filled Soul Jar when called
	public void giveFilledSoulJar(Player player){
		Inventory inv = player.getInventory();
		for(ItemStack stack : inv.getContents()){
			if (stack == null){
				EnchantmentAPI.getEnchantment("Soul Snare").addToItem(this.souljar, 5);
				inv.addItem(this.souljar);
				break;
			}
		}
	}
	
	/**
	 * @param player	Used to access the inventory from which the empty Soul Jar will be taken
	 * @param count		Quite self explanatory, but it's how many empty Soul Jars to take
	 */
	public static void takeEmptySoulJar(Player player, int count){
		SoulJar emptySoulJar = new SoulJar(count);
		Inventory inventory = player.getInventory();
		int jarsFound = 0;
		for(ItemStack item : inventory.getContents()){	//	For each ItemStack in player's inventory
			if (item != null){	//	If the item stack is not a null stack (empty Inventory space)
				if (item.getType().equals(Material.GLASS_BOTTLE)){
					if (EnchantmentAPI.itemHasEnchantment(item, "Soul Snare")){
						jarsFound+= item.getAmount();
						break;
					}
				}
			}
		}
		if (jarsFound > 0){
			inventory.removeItem(emptySoulJar.souljar);
		}
	}
	
}
