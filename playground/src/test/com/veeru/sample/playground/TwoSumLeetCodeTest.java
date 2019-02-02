package com.veeru.sample.playground;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TwoSumLeetCodeTest {

	@Test
	void test() {
		TwoSumLeetCode ts = new TwoSumLeetCode();
		
		int[] result = ts.twoSumBrute(new int[] {2,7,7,7}, 9);
		assertArrayEquals(new int[] {0, 1}, result);
		
		result = ts.twoSumBrute(new int[] {2,7,7,7}, 14);
		assertArrayEquals(new int[] {1, 2}, result);
		
		result = ts.twoSumBrute(null, 9);
		assertArrayEquals(new int[] {0, 1}, result);
	}

}
