package com.veeru.sample.playground.corejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DependenciesMap {
	
	/*
	 * A -> B C
	 * B -> D, E, A
	 * C -> E, F, B
	 * E -> F, C
	 * 
	 *Input   
	 * A = 1
	 *output
	 * A = 1
	 * B = 2 
	 * C = 2
	 * D = 3
	 * E = 3
	 * F = 3
	 * 
	 */
	
	static Map<String, List<String>> dependencies = new HashMap<String, List<String>>();
	static Map<String, String> vistedMap = new HashMap<String, String>();
	
	static {
		
		dependencies.put("A", Arrays.asList("B","C"));
		dependencies.put("B", Arrays.asList("D","E","A"));
		dependencies.put("C", Arrays.asList("E","F","B"));
		dependencies.put("E", Arrays.asList("F","C"));
		
	}
	
	
	public static void setValue(String node, int value) {
		System.out.println(node + " "+ value );

	}
	
	public static void setValueRecursive(String node, int value) {
		if(! vistedMap.containsKey(node)) {
			setValue(node, value);
			vistedMap.put(node, node);
		}
		
			List<String> children = dependencies.get(node);
			if(children != null && children.size()>0) {
				int childValue = value+1;
				for(String child : children) {
					if(! vistedMap.containsKey(child)) {
						setValue(child, childValue);
						vistedMap.put(child, child);
						
					}
				}
				for(String child : children) {
					
					if(! vistedMap.containsKey(child)) {
						setValueRecursive(child, childValue);
						
					}
				}
			}
				
			
		

	}

	public static void main(String[] args) {
		setValueRecursive("A", 1);
	}

}
