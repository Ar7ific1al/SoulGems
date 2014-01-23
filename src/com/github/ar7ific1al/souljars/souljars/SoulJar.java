package com.github.ar7ific1al.souljars.souljars;

public class SoulJar {
	
	private String name;
	
	private Type type;
	
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
		BAT
	}
	
	public Type getType(){
		return type;
	}
	
	public void setType(Type type){
		
	}
	
	public String getName(){
		return name;
	}
	
}
