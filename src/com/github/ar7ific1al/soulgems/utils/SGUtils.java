package com.github.ar7ific1al.soulgems.utils;

import java.util.ArrayList;
import java.util.List;


public class SGUtils {
	
	public static String ColorMessage(String input){
		
		String output = "";
		
		output = input.replaceAll("&([0-9a-f])", "\u00A7$1");
		
		return output;
		
	}
	
}
