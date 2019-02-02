package com.veeru.sample.playground.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class FindThreeElementSumArray {
	
	public static void find3(int[] x) {
		HashSet<Integer> set = new HashSet<Integer>();
		 for (int i = 0; i <x.length ; i++) {
	            int a = x[i];
	            set = new HashSet<Integer>();

	            for (int j=i+1; j<x.length; j++) {
	                int b = x[j];
	                int c = -(a+b);
	                if(set.contains(c)){
	                    System.out.println("Found 3 elements whose sum is = 0");
	                    System.out.println("Elements are " + a + " " + b + " " + c);
	                    return;
	                }else
	                    set.add(b);
	            }
	        }
	}
	
	
    public static void find2(int[] a) {
    	Arrays.sort(a);
    	for(int i=0; i < a.length; i++) {
    		int val = a[i];
    		int start = i+1;
    		int end = a.length-1;
    		
    		int sum = -val;
    		while(start < end) {
    			int twoSum = a[start]+a[end];
    			if(twoSum == sum) {
    				System.out.println(a[i]+" "+a[start]+" "+a[end]);
    				return;
    			}else if(twoSum < sum) {
    				start++;
    			}else {
    				end--;
    			}
    			
    		}
    	}
    }
	
	public static void find(int[] a) {
		
		for(int i=0; i< a.length; i++) {
			for(int j=i+1; j< a.length; j++) {
				for(int k=j+1; k< a.length; k++) {
					if(a[i]+a[j]+a[k] == 0) {
						System.out.println("Elements are " + a[i] + " " + a[j]+ " " + a[k]);
						return;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
//		int a [] = { 3,-1,-7,-4,-5,9,10};
		int a [] = { 0,-1,0,-4,0,9,10};
        find3(a);

	}

}
