/*
 * Joe O'Regan
 * A00258304
 * Exercise 1 - Unit Testing with No Collaborators Investment Calculator
 */
package com.ait.ex1.investment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InvestmentValueTestEx1 {

	InvestmentValue iv = new InvestmentValue();
	
	@Test
	void testValidAmountLessThan3000() {
		assertEquals(1061.21, iv.calculateInvestmentValue(3,1000), 1.01);
	}

	@Test
	void testValidAmountBetween3000And5000() {
		assertEquals(4410, iv.calculateInvestmentValue(2,4000));
	}
	@Test
	void testValidAmountOver5000() {
		assertEquals(7012.76, iv.calculateInvestmentValue(5,5000), 1.01);
	}
}
