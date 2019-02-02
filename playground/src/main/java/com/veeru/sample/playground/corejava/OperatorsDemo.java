package com.veeru.sample.playground.corejava;

public class OperatorsDemo {
	
	public void prePostOperators() {
		int i = 3;
		i++;
		System.out.println(i);
		++i;
		System.out.println(i);
		
		System.out.println(++i);
		System.out.println(i++);
		System.out.println(i);
		
		
	}
	
	public void comarisonDemo() {
		int value1 = 1;
		int value2 = 2;
		
		if (value1 == value2) {
			System.out.println("value1 == value2");
		}
		
		if (value1 != value2) {
			System.out.println("value1 != value2");
		}
	}
	
	public void conditionalDemo() {
		int value1 = 1;
		int value2 = 2;
		int result;
		boolean condition = true;
		
		result = condition ? value1:value2; 
		System.out.println("reslut: "+ result);
	}
	
	public void instanceofDemo() {
		Parent parentObj = new Parent();
		Child childObj = new Child();
		Child nullObj = null;
		
		System.out.println("parentobj instance of Parent: " + (parentObj instanceof Parent));
		System.out.println("parentobj instance of Child: " + (parentObj instanceof Child));
		
		System.out.println("childObj instance of Child: " + (childObj instanceof Child));
		System.out.println("childObj instance of Parent: " + (childObj instanceof Parent));
		
		System.out.println("childObj instance of MyInterface: " + (childObj instanceof MyInterface));
		
		System.out.println("nullObj instance of Child: " + (nullObj instanceof Child));
		
	}
	
	public void bitDemo() {
		int bitmask = 0x000F;
        int val = 0x2222;
        // prints "2"
        System.out.println(val & bitmask);
	}

	public static void main(String[] args) {
		OperatorsDemo oprDemo = new OperatorsDemo();
		oprDemo.prePostOperators();
		oprDemo.comarisonDemo();
		oprDemo.conditionalDemo();
		oprDemo.instanceofDemo();
		oprDemo.bitDemo();

	}

	
	
	class Parent {}
	class Child extends Parent implements MyInterface {}
	interface MyInterface {}
}
