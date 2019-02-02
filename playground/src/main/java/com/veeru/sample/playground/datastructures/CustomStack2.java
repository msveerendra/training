package com.veeru.sample.playground.datastructures;

import java.util.Stack;

public class CustomStack2 {
	
	Integer minEle;
	private Stack<Integer> regStack = new Stack<Integer>();
	
	public void push(Integer item) {
		
		if(regStack.isEmpty()) {
			regStack.push(item);
			minEle = item;
		
		}else {
			regStack.push(item);
			if(item < minEle) {
				regStack.push( 2*item - minEle);
				minEle = item;
			}
		}
		
		
	}
	
	public Integer pop() {
		 
		int item = regStack.pop();
		if(item < minEle ) {
			minEle = 2*minEle - item;
		}
		return minEle;
	}
	
	public Integer getMin() {
		return minEle;
	}
	
	
	
	public static void main(String[] args) {
		CustomStack2 cStack = new CustomStack2();
		cStack.push(10);
		cStack.push(11);
		cStack.push(12);
//		cStack.push(9);
		cStack.push(14);
		cStack.push(15);
		
		System.out.println(cStack.getMin());
	}

}
