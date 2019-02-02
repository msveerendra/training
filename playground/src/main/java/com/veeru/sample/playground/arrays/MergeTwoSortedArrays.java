package com.veeru.sample.playground.arrays;

public class MergeTwoSortedArrays {
	
	public static void mergerArrays(int[] arr1, int[]arr2) {
		
		int size1 = arr1.length;
		int size2 = arr2.length;
		int[] arr3 = new int[size1+size2];
		int i =0 ,j =0,k= 0;
		
		while(k < arr3.length) {
			
			if(i < size1 || j < size2) {
				if(arr1[i] < arr2[j]) {
					arr3[k] = arr1[i];
					i = i+1;
				}else {
					arr3[k] = arr2[j];
					j = j+1;
							
				}
				k= k+1;
				
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
