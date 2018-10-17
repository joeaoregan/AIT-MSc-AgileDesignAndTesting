package com.ait.ex1.investment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ait.ex1.investment.InvestmentValue;

class testInvestment {
	
	InvestmentValue investmentValue = new InvestmentValue();
	
	@Test
	void testInvest1() {
		assertEquals(2122.416, InvestmentValue.calculateInvestmentValue(3, 2000));
		assertEquals(3472.875, InvestmentValue.calculateInvestmentValue(3, 3000));
		assertEquals(6125.215, InvestmentValue.calculateInvestmentValue(3, 5000));
	}

}
