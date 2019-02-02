package com.veeru.sample.playground.corejava;

public class ControlFlowDemo {
	
	public void switchDemo() {
		 int month = 2;
	        int year = 2000;
	        int numDays = 0;

	        switch (month) {
	            case 1: case 3: case 5:
	            case 7: case 8: case 10:
	            case 12:
	                numDays = 31;
	                break;
	            case 4: case 6:
	            case 9: case 11:
	                numDays = 30;
	                break;
	            case 2:
	                if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0))
	                    numDays = 29;
	                else
	                    numDays = 28;
	                break;
	            default:
	                System.out.println("Invalid month.");
	                break;
	        }
	        System.out.println("Number of Days = "+ numDays);
	    }

	public int swithcStringDemo(String month) {
		int monthNumber = 0;
		if(month == null) {
			return 0;
		}
		
		switch (month.toLowerCase()) {
		case "january": 
			monthNumber =1;
			break;
		case "february":
			monthNumber = 2;
			break;
		case "march":
			monthNumber = 3;
			break;
		case "april":
			monthNumber = 4;
			break;
		case "may":
			monthNumber = 5;
			break;
		case "june":
			monthNumber = 6;
			break;
		case "july":
			monthNumber = 7;
			break;
		case "august":
			monthNumber = 8;
			break;
		case "september":
			monthNumber = 9;
			break;
		case "october":
			monthNumber = 10;
			break;
		case "november":
			monthNumber = 11;
			break;
		case "december":
			monthNumber = 12;
			break;
	
		default:
			monthNumber =0;
			break;
		}
		
		return monthNumber;
	}
	public static void main(String[] args) {
		ControlFlowDemo demo = new ControlFlowDemo();
		demo.switchDemo();
		System.out.println(demo.swithcStringDemo("april"));
		System.out.println(demo.swithcStringDemo("march"));
		System.out.println(demo.swithcStringDemo("Decmber"));
		System.out.println(demo.swithcStringDemo(null));
		
		
		

	}

}
