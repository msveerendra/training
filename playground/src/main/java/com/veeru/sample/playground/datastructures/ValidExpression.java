package com.veeru.sample.playground.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidExpression {
	private static Stack<Character> stack = new Stack<Character>();
	private static final Map<Character,Character> charMap = new HashMap<Character,Character>();
	
	static {
		charMap.put('{', '}');
		charMap.put('(', ')');
		charMap.put('[', ']');
	}
	
	public static boolean isValidExp(String str) {
		
		char[] cArr = str.toCharArray();
		for (int i=0 ; i< cArr.length; i++) {
			if(charMap.get(cArr[i]) != null) {
				stack.push(cArr[i]);
			}else {
				if(! (charMap.get(stack.pop()).equals(cArr[i]))){
					return false;
				}
			}
		}
		
		if(stack.empty()) {
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isValidExp("[]{([]])}"));

	}

}
