package com.veeru.sample.playground.datastructures;

import java.util.Stack;

public class SortStack {
	
	
	private static void sortStack(Stack<Integer> stack) {
		
		if (!stack.isEmpty()) {
			int item = stack.pop();
		   sortStack(stack);
		   sortedInsert(stack, item);
		}
		
	}

	private static void sortedInsert(Stack<Integer> stack, int item) {
		if(stack.isEmpty() || item > stack.peek()) {
			stack.push(item);
			return;
		}
		int element = stack.pop();
		sortedInsert(stack, item);
		stack.push(element);
		
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		System.out.println(stack);
		
		sortStack(stack);
		
		System.out.println(stack);

	}

}
