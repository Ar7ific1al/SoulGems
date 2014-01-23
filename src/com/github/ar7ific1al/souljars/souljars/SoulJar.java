package com.github.ar7ific1al.souljars.souljars;

import java.util.Arrays;
import java.util.List;

public class SoulJar {
	
	private String name;
	private Type type;
	private int value;
	
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
		SHEEP,
		HORSE,
		BAT,
		VILLAGER,
		HUMAN
	}
		
	public boolean isValidJarValue(int val){
		int min = 1000;
		int max = 6000;
		
		if (val >= min && val <= max){
			if (this.value % 64 == 0){
				return false;
			}
			else{
				return true;
			}
		}
		return false;
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
	
	
	
}
