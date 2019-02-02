package com.veeru.sample.playground.datastructures;

import java.util.Stack;

public class CustomStack {
	
	private Stack<Integer> minStack = new Stack<Integer>();
	private Stack<Integer> regStack = new Stack<Integer>();
	
	public void push(Integer item) {
		
		if(regStack.isEmpty()) {
			regStack.push(item);
			minStack.push(item);
		
		}else {
			regStack.push(item);
			if(item < minStack.peek()) {
				minStack.pop();
				minStack.push(item);
			}
		}
		
		
	}
	
	public Integer pop() {
		 
		minStack.pop();
		return regStack.pop();
	}
	
	public Integer getMin() {
		return minStack.peek();
	}
	
	
	
	public static void main(String[] args) {
		CustomStack cStack = new CustomStack();
		cStack.push(10);
		cStack.push(11);
		cStack.push(12);
		cStack.push(9);
		cStack.push(14);
		cStack.push(15);
		
		System.out.println(cStack.getMin());
	}

}
