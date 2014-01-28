package com.github.ar7ific1al.souljars;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import com.github.ar7ific1al.souljars.commands.global.BaseCommand;
import com.github.ar7ific1al.souljars.enchantments.SoulSapEnchantment;
import com.github.ar7ific1al.souljars.enchantments.SoulSnareEnchantment;
import com.github.ar7ific1al.souljars.listeners.EntityDeathListener;
import com.github.ar7ific1al.souljars.utils.Log;
import com.github.ar7ific1al.souljars.utils.particlelib.ParticleEffectData;
import com.rit.sucy.EnchantPlugin;
import com.rit.sucy.EnchantmentAPI;

public class Plugin extends EnchantPlugin{

	public static Log logger;

	public String version;

	public List<String> authors;

	public static File SettingsDir = new File("plugins/SoulJars/settings/");

	// public List<SoulJar> SoulJars = new ArrayList<SoulJar>();
	public static final HashMap<Entity, ParticleEffectData> PARTICLES = new HashMap<Entity, ParticleEffectData>();

	public static Random random = new Random();

	@Override
	public void onEnable() {
		logger = new Log();
		PluginManager pm = Bukkit.getServer().getPluginManager();
		PluginDescriptionFile pdFile = this.getDescription();
		version = pdFile.getVersion();
		authors = pdFile.getAuthors();
		Log.LogMessage(ChatColor.LIGHT_PURPLE + "[SoulJars] SoulJars v"
				+ version + " by " + authors + " enabled.", Bukkit.getServer()
				.getConsoleSender());

		if (!getDataFolder().exists()) {
			getDataFolder().mkdir();
		}

		// Define command ececutors
		BaseCommand baseCommands = new BaseCommand(this);

		// Define listeners
		EntityDeathListener deathListener = new EntityDeathListener(this);

		// Register commands
		getCommand("souljars").setExecutor(baseCommands);

		// Register listeners
		pm.registerEvents(deathListener, this);

	}

	@Override
	public void onDisable() {
		Log.LogMessage(ChatColor.LIGHT_PURPLE + "[SoulJars] SoulJars v"
				+ version + " by " + authors + " disabled.", Bukkit.getServer()
				.getConsoleSender());
	}
	
	@Override
	public void registerEnchantments(){
		EnchantmentAPI.registerCustomEnchantment(new SoulSapEnchantment());
		EnchantmentAPI.registerCustomEnchantment(new SoulSnareEnchantment());
	}

}
