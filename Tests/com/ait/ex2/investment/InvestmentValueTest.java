/*
 * Joe O'Regan
 * A00258304
 * Exercise 1 - Unit Testing with No Collaborators Investment Calculator
 */
package com.ait.ex2.investment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InvestmentValueTest {

	InvestmentValue iv;
	
	@BeforeEach
	public void setup() {
		iv = new InvestmentValue();
	}
	
	@Test
	void testValidAmountLessThan3000() {
		//assertEquals(1061.21, iv.calculateInvestmentValue(3,1000), 1.01);
		assertEquals(1061.21, InvestmentValue.calculateInvestmentValue(3,1000), 1.01);	// call static function
	}

	@Test
	void testValidAmountBetween3000And5000() {
		//assertEquals(4410, iv.calculateInvestmentValue(2,4000));
		assertEquals(4410, InvestmentValue.calculateInvestmentValue(2,4000));
	}
	@Test
	void testValidAmountOver5000() {
		//assertEquals(7012.76, iv.calculateInvestmentValue(5,5000), 1.01);
		assertEquals(7012.76, InvestmentValue.calculateInvestmentValue(5,5000), 1.01);
	}
}
