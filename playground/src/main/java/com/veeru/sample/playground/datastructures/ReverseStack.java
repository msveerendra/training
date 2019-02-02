package com.veeru.sample.playground.datastructures;

import java.util.Stack;

public class ReverseStack {
	
	private static Stack<Integer> stack = new Stack<Integer>();
	
	private static void insertFromBottom(Integer element) {
		
		if(stack.isEmpty()) {
			stack.push(element);
		}else {
			Integer ele = stack.peek();
			stack.pop();
			insertFromBottom(element);
			stack.push(ele);
		}
		
	}
	
	private static void reverse() {
		
		if(stack.size() >0) {
			Integer element = stack.peek();
			stack.pop();
			reverse();
			insertFromBottom(element);
		}
		
	}

	public static void main(String[] args) {
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack);
		
		reverse();
		
		System.out.println(stack);
}
}
