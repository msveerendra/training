package com.veeru.sample.playground.corejava;

import java.util.Scanner;

public class ScannerBufferDiff {

	public static void main(String[] args) {
		 Scanner scn = new Scanner(System.in);
         System.out.println("Enter an integer");

         int a = scn.nextInt();
         scn.nextLine();
         System.out.println("Enter a String");

         String b = scn.nextLine();
         scn.nextLine();
         System.out.printf("You have entered:- " + a + " " + "and name as " + b);
         scn.nextLine();
	}

}
