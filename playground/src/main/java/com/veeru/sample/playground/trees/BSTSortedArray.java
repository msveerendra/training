package com.veeru.sample.playground.trees;

public class BSTSortedArray {
	
	private static TreeNode createBinaryTree(int[] array, int start, int end) {
		
		if (start > end) {
			return null;
		}
		int mid = (start+end)/2;
		TreeNode root = new TreeNode(array[mid]);
		root.leftNode = createBinaryTree(array, start, mid-1);
		root.rightNode = createBinaryTree(array, mid+1, end);
		return root;
		
	}

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8};
		System.out.println(createBinaryTree(array, 0, 7));

	}

}
