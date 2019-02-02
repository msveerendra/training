package com.veeru.sample.playground.hacker;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution2 {

	private static String findTreasure(String[] input) {

		int x = 0;
		int y = 0;
		String currDire = "N";

		try {
			if (input == null || input.length == 0) {
				return "0, 0";
			}
			for (int i = 0; i < input.length - 1;) {
				if (i == 0) {
					y += Integer.parseInt(input[i]);
					currDire = "N";
					i++;
				} else {
					String currMove = input[i];

					int next = Integer.parseInt(input[i + 1]);

					if (currMove.equals("r") && currDire.equalsIgnoreCase("N")) {
						currDire = "E";
						x += next;
					} else if (currMove.equals("l") && currDire.equalsIgnoreCase("N")) {
						currDire = "W";
						x -= next;
					} else if (currMove.equals("r") && currDire.equalsIgnoreCase("E")) {
						currDire = "S";
						y -= next;
					} else if (currMove.equals("l") && currDire.equalsIgnoreCase("E")) {
						currDire = "N";
						y += next;
					} else if (currMove.equals("l") && currDire.equalsIgnoreCase("W")) {
						currDire = "S";
						y -= next;
					} else if (currMove.equals("r") && currDire.equalsIgnoreCase("W")) {
						currDire = "N";
						y += next;
					}else if (currMove.equals("r") && currDire.equalsIgnoreCase("S")) {
						currDire = "W";
						x -= next;
					}else if (currMove.equals("l") && currDire.equalsIgnoreCase("S")) {
						currDire = "E";
						x += next;
					}
					i += 2;

				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return "0, 0";
		}
		return x + ", " + y;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String[] tokens = (in.nextLine()).split(" ");
		System.out.println(findTreasure(tokens));
		

	}

}
