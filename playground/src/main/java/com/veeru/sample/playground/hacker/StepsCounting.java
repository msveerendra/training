package com.veeru.sample.playground.hacker;

import java.util.Arrays;

public class StepsCounting {
	
	public static int countWays(int n) {
		int[] memo = new int[n+1];
//		if(n < 0) {
//			return 0;
//		}else if (n == 0) {
//			return 1;
//		}else {
//			return countWays(n-1)+countWays(n-2)+countWays(n-3);
//		}
		Arrays.fill(memo, -1);
		return countWaysMemo(n, memo);
	}
	
	public static int countWaysMemo(int n, int[] memo) {
		
		if(n < 0) {
			return 0;
		}else if (n == 0) {
			return 1;
		}else if(memo[n] > -1){
			return memo[n];
		}
		else {
			memo[n] = countWaysMemo(n-1, memo)+countWaysMemo(n-2, memo)+countWaysMemo(n-3, memo);
		
			return memo[n];
		}
	}

	public static void main(String[] args) {
	   System.out.println("Start");	
       System.out.println("Differnt ways to step up for count of 10 steps: "+countWays(36));
       System.out.println("End");	

	}

}
