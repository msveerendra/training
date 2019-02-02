package com.veeru.sample.playground.hacker;
	import java.io.IOException;

	public class LeftRotateArray {

	    // Complete the rotLeft function below.
	    static int[] rotLeft(int[] a, int d) {
	            int length = a.length;
	            int[]  result = new int[length];
	        d = d % length;
	        for ( int i =0 ; i< a.length; i++){
	            int newIndex = i - d;
	            if (newIndex < 0) {
	            	newIndex = newIndex + length;
	            }
	            result[newIndex] = a[i];
	            
	        }
	        return result;
	    }


	    public static void main(String[] args) throws IOException {


	   

	        int n = 4;

	        int d = 5;

	        int[] a = new int[n];

	        for (int i = 0; i < n; i++) {
	            
	            a[i] = i+1;
	        }

	        int[] result = rotLeft(a, d);

	        for (int i = 0; i < result.length; i++) {
	            System.out.print(String.valueOf(result[i]));

	            if (i != result.length - 1) {
	            	System.out.print(" ");
	            }
	        }

	        System.out.println();

	        
	    }
	}

