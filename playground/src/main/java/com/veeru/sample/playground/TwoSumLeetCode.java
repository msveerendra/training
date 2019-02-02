package com.veeru.sample.playground;

public class TwoSumLeetCode {
	
	public int[] twoSumBrute(int[] input, int sum) {
		if(input != null && input.length>0)
		for(int i=0; i<input.length; i++) {
			for(int j=i+1; j<input.length; j++) {
				if(input[i]+input[j] == sum) {
					System.out.println("Matching set"+ String.valueOf(i) +", " +String.valueOf(j));
					return new int[] {i,j};
				}
			}
		}
		throw new IllegalArgumentException("No matching sum found for given array and sum");
	}

	public static void main(String[] args) {
		TwoSumLeetCode ts = new TwoSumLeetCode();
		ts.twoSumBrute(new int[] {2,7,7,7}, 9);

	}

}
