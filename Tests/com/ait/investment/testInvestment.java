package com.ait.investment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testInvestment {

	@Test
	void testInvest1() {
		assertEquals(3018, InvestmentValue.calculateInvestmentValue(3, 3000));
	}

}
