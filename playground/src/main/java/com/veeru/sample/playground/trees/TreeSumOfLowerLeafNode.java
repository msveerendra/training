package com.veeru.sample.playground.trees;

public class TreeSumOfLowerLeafNode {

	// function to find the sum of nodes at
	// maximum depth arguments are node and
	// max, where max is to match the depth
	// of node at every call to node, if
	// max will be equal to 1, means
	// we are at deepest node.
	public static int sumMaxLevelRec(Node node, int max) {
		// base case
		if (node == null)
			return 0;

		// max == 1 to track the node
		// at deepest level
		if (max == 1)
			return node.data;

		// recursive call to left and right nodes
		return sumMaxLevelRec(node.left, max - 1) + sumMaxLevelRec(node.right, max - 1);
	}

	public static int sumMaxLevel(Node root) {

		// call to function to calculate
		// max depth
		int MaxDepth = maxDepth(root);

		return sumMaxLevelRec(root, MaxDepth);
	}

	// maxDepth function to find the
	// max depth of the tree
	public static int maxDepth(Node node) {
		// base case
		if (node == null)
			return 0;

		// either leftDepth of rightDepth is	
		// greater add 1 to include height
		// of node at which call is
		return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
	}

	// Driver code
	public static void main(String[] args) {

		/*
		 * 1 / \ 2 3 / \ / \ 4 5 6 7
		 */

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

		// call to calculate required sum
		System.out.println(sumMaxLevel(root));
	}
}
