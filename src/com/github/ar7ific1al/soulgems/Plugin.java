package com.github.ar7ific1al.soulgems;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import net.minecraft.util.io.netty.handler.logging.LogLevel;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.ar7ific1al.soulgems.commands.global.BaseCommand;
import com.github.ar7ific1al.soulgems.utils.Log;

public class Plugin extends JavaPlugin{
	
	public static Log logger;
	
	public String version;

	public List<String> authors;
	
	public static File SettingsDir = new File("plugins/SoulGems/settings/");
	
	//public List<SoulGem> SoulGems = new ArrayList<SoulGem>();
	
	public static Random random = new Random();
	
	
	@SuppressWarnings("unused")
	@Override
	public void onEnable(){
		logger = new Log();
		PluginManager pm = Bukkit.getServer().getPluginManager();
		PluginDescriptionFile pdFile = this.getDescription();
		version = pdFile.getVersion();
		authors = pdFile.getAuthors();
		logger.Log(ChatColor.LIGHT_PURPLE + "[SoulGems] SoulGems v" + version + " by " + authors + " enabled.", Bukkit.getServer().getConsoleSender());
		
		if (!getDataFolder().exists()){
			getDataFolder().mkdir();
		}
		
		//	Define command ececutors
		BaseCommand baseCommands = new BaseCommand(this);
		
		//	Register commands
		getCommand("soulgems").setExecutor(baseCommands);
	}
	
	@Override
	public void onDisable(){
		logger.Log(ChatColor.LIGHT_PURPLE + "[SoulGems] SoulGems v" + version + " by " + authors + " disabled.", Bukkit.getServer().getConsoleSender());
	}
	
}
