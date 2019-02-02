package com.veeru.sample.playground.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LevelOfMap {
	
	private static Map<String, List<String>> map;
	private static Map<String, String> vistedMap = new HashMap<String, String>();
	private static boolean rescursive = false;
	
	static {
		map = new HashMap<String, List<String>>();
		List childs = new ArrayList<String>();
		childs.add("B");
		childs.add("C");
		map.put("A", childs);
		
		childs = new ArrayList<String>();
		childs.add("D");
		childs.add("E");
		map.put("B", childs);
		
		childs = new ArrayList<String>();
		childs.add("A");
		childs.add("F");
		childs.add("G");
		map.put("C", childs);
		
		childs = new ArrayList<String>();
		childs.add("B");
		childs.add("C");
		childs.add("H");
		childs.add("I");
		map.put("D", childs);
		
		
	}
	
	
	public static void printValue(String node , int level) {
		System.out.println(node+" ->"+level);
	}
	
	public static void recursiveLevels(String input, int value) {
		printValue(input, value);
		vistedMap.put(input, String.valueOf(value));
		List<String> children = map.get(input);
		for(String child:children) {
			if(! vistedMap.containsKey(child)) {
				recursiveLevels(child, value+1);
			}
		}
	}

	public static void main(String[] args) {
		recursiveLevels("A", 1);

	}

}
