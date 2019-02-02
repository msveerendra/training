package com.veeru.sample.playground.datastructures;

import java.util.Stack;

public class RemoveMidOfStack {
	
	private static Stack<Integer> stack = new Stack<Integer>();
	

	
	private static void removeMid(Stack<Integer> stack, int size, int curr) {
		
		if(stack.isEmpty() || curr==size) {
			return;
		}
		Integer item =  stack.pop();
	
		removeMid(stack, size, curr+1);
		
		if(curr != size/2) {
			stack.push(item);
		}
		
	}

	public static void main(String[] args) {
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack);
		
		removeMid(stack, stack.size(), 0);
		
		System.out.println(stack);
}
}
