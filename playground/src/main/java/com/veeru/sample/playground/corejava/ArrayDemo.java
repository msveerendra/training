package com.veeru.sample.playground.corejava;

public class ArrayDemo {

    public void basicArray() {
    	int[] intArray;
		intArray = new int[10];
		intArray[0] = 10;
		intArray[1] = 9;
		intArray[2] = 8;
		
		int len = intArray.length;
		System.out.println("Basic Array: "+ intArray[0]+" "+intArray[1]+" "+intArray[2]);
		
    }
    
    public void multiDimensionArray() {
    	String[][] multiArray = { {"Mr.", "Ms."}, {"Sreenivas", "Venkat"}, {"Naga", "Lakshmi"}};
    	System.out.println(multiArray[0][0] + multiArray[1][0]);
    	System.out.println(multiArray[0][0] + multiArray[1][1]);
    	System.out.println(multiArray[0][1] + multiArray[2][0]);
    	System.out.println(multiArray[0][1] + multiArray[2][1]);
    }
	public static void main(String[] args) {
		
		
		ArrayDemo demo = new ArrayDemo();
		demo.basicArray();
		demo.multiDimensionArray();
	}
	
	
}
