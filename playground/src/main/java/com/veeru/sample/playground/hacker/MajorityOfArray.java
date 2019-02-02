package com.veeru.sample.playground.hacker;

import java.util.HashMap;
import java.util.Map;

public class MajorityOfArray {
	
	public static void majorityElement(int[] input) {
		
		int maj_index = 0 ;
		int count =0;
		
		for ( int i=1;i< input.length; i++) {
			if(input[maj_index]== input[i]) {
				count ++;
			}else {
				count --;
			}
			
			if(count ==0) {
				maj_index = i;
				count =1;
			}
				
		}
		
		for(int i =0 ; i < input.length; i++) {
			 count =0;
			 for( i=0 ; i < input.length; i++) {
				if (input[i] == input[maj_index]) {
					count++;
					if(count > input.length/2) {
						System.out.println("Majority number found: "+ input[maj_index]);
					}
				}
			 }
			 if(count <= input.length/2) {
					System.out.println("Majority number found: "+ input[maj_index]);
				}
		}
	}

	public static void main(String[] args) {
		int[] arr = {1,2,2,2,2,4};
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0 ; i < arr.length; i++) {
			Integer objInt = new Integer(arr[i]);
			if(map.get(objInt) == null) {
				Integer count = new Integer(1);
				
			     map.put(objInt, count);
			}else {
				Integer count = map.get(objInt);
				count = count + 1;
				map.put(objInt, count);
				if(count > arr.length/2) {
					System.out.println("Majority Number: "+ objInt.intValue());
					break;
				}
			}
				
		}
		
		System.out.println("Sorry");

	}

}
