package com.veeru.sample.playground.hacker;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TreasureHunt {
	
	public static BigDecimal getK(Long x, Long y, Long a, Long b) {
		BigDecimal k = new BigDecimal(x * a + y * b);
		k = k.divide(new BigDecimal(a * a + b * b), 12, RoundingMode.HALF_EVEN);
		System.out.println(k.toPlainString());
		return k;
	}

	public static BigDecimal getN(Long x, Long y, Long a, Long b) {
		BigDecimal n = new BigDecimal(y * a - x * b);
		n = n.divide(new BigDecimal(a * a + b * b), 12, RoundingMode.HALF_EVEN);
		System.out.println(n.toPlainString());
		return n;
	}

	


	public static void main(String[] args) {
		System.out.println(getK(481199252L,167959139L,24578L,20888L));
		System.out.println(getN(481199252L,167959139L,24578L,20888L));

	}

}
