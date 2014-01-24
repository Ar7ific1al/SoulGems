package com.github.ar7ific1al.souljars.commands.global;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import com.github.ar7ific1al.souljars.Plugin;
import com.github.ar7ific1al.souljars.souljarevents.SoulJarFillEvent;
import com.github.ar7ific1al.souljars.souljars.SoulJar;
import com.github.ar7ific1al.souljars.souljars.SoulJar.Type;
import com.github.ar7ific1al.souljars.utils.SJUtils;

public class BaseCommand implements CommandExecutor	{
	
	Plugin plugin;
	
	public BaseCommand(Plugin instance){
		plugin = instance;
		Plugin.logger.Log(ChatColor.LIGHT_PURPLE + "[SoulJars] BasicCommand Executor Registered.", plugin.getServer().getConsoleSender());
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (label.equalsIgnoreCase("souljars")){
			try{
				if (args.length == 0){	//	If arg lenth = 0 (no args)
					ArrayList<String> infoMessage = new ArrayList<String>();	//	Define a list of strings to color and send to the user using SGUtils.ColorMessage()
					infoMessage.add("&dSoulJars &eversion " + plugin.version + " by &c" + plugin.authors);
					infoMessage.add("&a    SoulJars aims to provide Skyrim-like Soul Jars to you for use in various manners.");
					infoMessage.add("&a    Visit &chttps://github.com/Ar7ific1al/SoulJars/wiki &a(WIP)");
					infoMessage.add("&a    for more information.");
					
					//	For each String "m" in helpMessage - Similar to C# foreach (object o in object)
					for(String m : infoMessage){
						sender.sendMessage(SJUtils.ColorMessage(m));
					}
				}
				else if (args.length == 1){		//	If arg lenth = 1 (1 args)
					if (args[0].equalsIgnoreCase("help")){		//	If arg 0 = "help"
						//	Define a list of strings to color and send to the user using SGutils.ColorMessage()
						ArrayList<String> helpMessage = new ArrayList<String>();
						helpMessage.add("&d-------------------[SoulJars Help]-------------------");
						helpMessage.add("");	//	Blank separator line :P
						helpMessage.add("&d-------------------[SoulJars Help]-------------------");
						
						//	For each String "m" in helpMessage - Similar to C# foreach (object o in object)
						for(String m : helpMessage){
							sender.sendMessage(SJUtils.ColorMessage(m));
						}
						//	#IGNORE
						SoulJar.giveEmptySoulJar((Player)sender);
						//	#ENDIGNORE
					}
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}
	
}
