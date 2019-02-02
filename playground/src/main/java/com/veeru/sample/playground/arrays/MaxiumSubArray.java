package com.veeru.sample.playground.arrays;

public class MaxiumSubArray {
	
	public static int maxSubArray(int[] arr) {
		
		int max_end_here =0;
		int max_so_far =0;
		for(int i=0; i<arr.length; i++) {
			max_end_here += arr[i];
			if(max_end_here < 0) {
				max_end_here =0;
			}
			if(max_so_far < max_end_here) {
				max_so_far = max_end_here;
			}
		}
		return max_so_far;
	}
	
	public static int maxSubArray2(int[] arr) {
		
		int max_end_here = arr[0];
		int max_so_far = max_end_here;
		
		for(int i=1 ; i < arr.length; i++) {
			max_end_here = Math.max(max_end_here, max_end_here+arr[i]);
			max_so_far = Math.max(max_end_here, max_so_far);
		}
				
		return max_so_far;
	}

	public static void main(String[] args) {
		int arrA[] = { 1, 2, -3, -4, 2, 7, -2, 3 };

		System.out.println("Maximum subarray is  " + maxSubArray(arrA));
		int arrB[] = { -2, -3, -4, -2, -7, -2, -3,-11 };
		System.out.println("Maximum Subarray when all elements are negative : " + maxSubArray(arrB));

	}

}
