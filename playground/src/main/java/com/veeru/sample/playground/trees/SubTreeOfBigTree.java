package com.veeru.sample.playground.trees;

public class SubTreeOfBigTree {
	
	
	private static boolean checkSmallTreeInBigTree(TreeNode bigTreeRoot, TreeNode smallTreeRoot) {
		
		if(smallTreeRoot == null) {
			return true;
		}
		
		if(bigTreeRoot == null) {
			return false;
		}
		
		if(bigTreeRoot.data == smallTreeRoot.data) {
			return checkCompleteMatch(bigTreeRoot, smallTreeRoot) ;
		}
		
		return checkSmallTreeInBigTree(bigTreeRoot.leftNode, smallTreeRoot) || checkSmallTreeInBigTree(bigTreeRoot.rightNode, smallTreeRoot) ; 
		

	}
	
	private static boolean checkCompleteMatch(TreeNode bigTreeRoot, TreeNode smallTreeRoot) {
		if( (bigTreeRoot == null) && (smallTreeRoot == null)) {
			return true;
		}
		
		if( (bigTreeRoot==null) || (smallTreeRoot==null)) {
			return false;
		}
		
		if(bigTreeRoot.data == smallTreeRoot.data) {
			return checkCompleteMatch(bigTreeRoot.leftNode, smallTreeRoot.leftNode) && checkCompleteMatch(bigTreeRoot.rightNode, smallTreeRoot.rightNode);
		}
		
		return false;
	}

	public static void main(String[] args) {
		TreeNode t0 = new TreeNode(0);
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		t0.leftNode = t1;
		t0.rightNode = t2;
		
		t1.leftNode = t3;
		t1.rightNode= t4;
		
		t2.leftNode=t5;
		
		t3.rightNode=t6;
		
		t5.rightNode=t7;
		
		t6.rightNode=t8;
		
		TreeNode bigTreeRoot = t0;
		
		
		TreeNode s1 = new TreeNode(1);
		
		TreeNode s3 = new TreeNode(3);
		TreeNode s4 = new TreeNode(4);

		TreeNode s6 = new TreeNode(6);

		TreeNode s8 = new TreeNode(8);
		
		s1.leftNode = s3;
		s1.rightNode= s4;
		s3.rightNode= s6;
		s6.rightNode= s8;
		
		
		TreeNode smallTreeRoot = s1;
		
		System.out.println(checkSmallTreeInBigTree(bigTreeRoot, smallTreeRoot));
				

	}

}
