package com.veeru.sample.playground.hacker;

public class Febonnaci {
	
	
	public static int generateFeboMemo(int n, int[] memo) {
		if(n ==0 || n==1) {
			return n;
		}
		
		if(memo[n]==0) {
			memo[n] = generateFeboMemo(n-1, memo)+ generateFeboMemo(n-2, memo);
		}
		
		return memo[n];
	}
	
	public static int generateFeb(int n) {
		int[] memo = new int[n+1];
		return generateFeboMemo(n,memo);
	}
	
	public static int bottomToTopApproach(int n) {
		int[] memo = new int[n+1];
		if(n ==0 || n==1) {
			return n;
		}
		
		memo[0] = 0;
		memo[1] = 1;
		for(int i=2; i<n; i++) {
			memo[i] = memo[i-1]+memo[i-2];
		}
		
		return memo[n-1]+ memo[n-2];
				
	}

	public static void main(String[] args) {
		System.out.println(generateFeb(10));
		System.out.println(bottomToTopApproach(10));

	}

}
