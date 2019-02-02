package com.veeru.sample.playground.trees;

import java.util.Stack;

public class TreeTravasal {
	
	public static void preOrderTravesal(Node root) {
	
		if(root != null) {
			System.out.println(root.data);
			preOrderTravesal(root.left);
			preOrderTravesal(root.right);
		}
			
	}
	
	public static void preOrderTravesalItr(Node root) {
		if(root != null) {
			return;
		}
		
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		
		while(! stack.empty()) {
			System.out.println(stack.pop().data);
			
			if(root.right != null) {
				stack.push(root.right);
			}
			
			if(root.left != null) {
				stack.push(root.left);
			}
			
		}
		
	}
	
	public static void inOrderTravesalItr(Node root) {
		if(root != null) {
			return;
		}
		
		Stack<Node> stack = new Stack<Node>();
		Node currentNode = root;
		
		
		while(!stack.empty() || currentNode != null) {
			
			if(currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.left;
				
			}else {
				System.out.println(stack.pop().data);
				stack.push(currentNode.right);
			}
		}
		
	}
	
	
	public static void inOrderTravesal(Node root) {
		if(root != null ) {
			inOrderTravesal(root.left);
			System.out.println(root.data);
			inOrderTravesal(root.right);
		}
	}
	
	public static void postOrderTravesal(Node node) {
		if(node != null) {
			postOrderTravesal(node.left);
			postOrderTravesal(node.right);
			System.out.println(node.data);
		}
	}
	
	public static void postOrderTraveslaItr(Node root) {
		if(root != null) {
			return;
		}
		
		Stack<Node> stack = new Stack<Node>();
		Node currentNode = root;
		
		while(true) {
			if(currentNode != null) {
				if(currentNode.right != null) {
					stack.push(currentNode.right);
				}
				stack.push(currentNode);
				currentNode = currentNode.left;
				continue;
			}
			
			if(stack.empty()) {
				return;
			}
			
			currentNode = stack.pop();
			if(currentNode.right != null && !stack.empty() && currentNode.right == stack.peek()) {
				
			}
				
		}
	}

	public static void main(String[] args) {
		// Constructing tree
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.right = new Node(15);
		root.right.right.right.left = new Node(18);
		root.left.left.right = new Node(9);
		root.left.left.right.left = new Node(10);
		
		preOrderTravesal(root);

	}

}
