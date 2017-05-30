package com.example.matrixcontainer;

import java.math.BigDecimal;

public class DNumber {

	/**
	 * return minimum of 2 integers
	 * 
	 * @param x1
	 * @param x2
	 * @return minimum of x1 and x2
	 */
	public int minof(int x1, int x2) {
		return x1 > x2 ? x2 : x1;
	}

	/**
	 * get n bits decimal
	 * 
	 * @param input
	 * @param bit
	 * @return the double value
	 */
	public double decimalbit(double input, int bit) {

		BigDecimal bigd = new BigDecimal(input);

		bigd = bigd.setScale(bit, BigDecimal.ROUND_HALF_UP);

		return bigd.doubleValue();

	}

}
