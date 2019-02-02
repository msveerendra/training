package com.sreeni.samples.playground.workday;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author sreeni
 * Process a date ranges inputs with weights and represent a data structure to calculate total weight of a given date 
 * 
 * Sample Date ranges: with weights
 *  1/15/2015 -- 2/15/2015 = 5
 *  1/20/2015 -- 3/23/2015 = 3
 *  1/02/2015 -- 3/15/2015 = 15
 *  2/15/2015 -- 9/15/2015 = 7
 *  9/05/2015 -- 12/15/2015 = 10
 *   
 * inputs:		output:
 * 1/25/2015 = 5+3+15 = 23 
 * 
 *
 */

public class DateTotalWeightCalculator {
	
    public static String DATE_FORMAT = "MM/dd/yyyy"	;
	
	public static long getTimeForDate(String inputDate) {
		
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		Date date = null;
		try {
			date = sdf.parse(inputDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date.getTime();

	}

	public static void main(String args[]) {
		
		DateRangeTree<Integer> dateRangeTree = new DateRangeTree<Integer>();

		dateRangeTree.addDateRange(getTimeForDate("1/15/2015"), getTimeForDate("2/15/2015"), 5);
		dateRangeTree.addDateRange(getTimeForDate("1/20/2015"), getTimeForDate("2/23/2015"), 3);
		dateRangeTree.addDateRange(getTimeForDate("1/02/2015"), getTimeForDate("3/15/2015"), 15);
		dateRangeTree.addDateRange(getTimeForDate("2/15/2015"), getTimeForDate("9/15/2015"), 7);
		dateRangeTree.addDateRange(getTimeForDate("9/05/2015"), getTimeForDate("12/15/2015"), 10);

		List<Integer> result1 = dateRangeTree.get(getTimeForDate("1/25/2015"));

		int totalWeight =0;
		for (int r : result1) {
			totalWeight = totalWeight+r;
		}
		System.out.println("Total Weight for 1/25/2015 :"+totalWeight);

	}
}