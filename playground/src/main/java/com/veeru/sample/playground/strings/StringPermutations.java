package com.veeru.sample.playground.strings;

import java.util.HashSet;

public class StringPermutations {
	
	private static HashSet<String> allPermutations(String str){
		HashSet<String> permutations = new HashSet<String>();
		if(str == null || str.length()==0) {
			permutations.add("");
			return permutations;
		}
		
		char firstChar = str.charAt(0);
		String remStr = str.substring(1);
		HashSet<String> words = new HashSet<String>();
		words = allPermutations(remStr);
		
		for(String word: words) {
			for(int i=0 ; i <= word.length();i++) {
				String preFix = word.substring(0, i);
				String suffix = word.substring(i);
				permutations.add(preFix+firstChar+suffix);
			}
		}
		
		return permutations;
		
	}

	public static void main(String[] args) {
		String str = "abcdef";
		System.out.println(allPermutations(str).toString());
		System.out.println(str);
		testString(str);
		System.out.println(str);
		

	}
	
	public static void testString(String str) {
		str = str+"hello";
		System.out.println(str);
	}

}
