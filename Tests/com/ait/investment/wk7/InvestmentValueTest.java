/*
 * Joe O'Regan
 * A00258304
 * Week 5 - Exercise 7
 * L5S18-21
 * 11/10/2018
 */
package com.ait.investment.wk7;

import static org.junit.Assert.*;
import org.junit.Test;
import static junitparams.JUnitParamsRunner.$;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.runner.RunWith;

import com.ait.ex7.investment.InvestmentValue;

@RunWith(JUnitParamsRunner.class)
public class InvestmentValueTest {
	private final int VALID_TERM=4;
	private final int VALID_INVESTMENT=2000;
	
	InvestmentValue iv = new InvestmentValue();
	
	/* Test Valid Input */
	
	@Parameters
	private static final Object[] getValidInvestmentAmounts(){
		return $(
				$(1000,3,1061.21),       
				$(1001,4,1083.51),   
				$(2000,5,2208.16),
				$(2998,6,3376.23),
				//$(2999,6,3377.36),
				//$(2999,3,4098.947),
				$(2999,3,3471.717),
				$(5000,3,6125.215)
		);
	}
	
	/* Test Invalid Input */
	
	@Parameters
	private static final Object[] getInvalidInvestmentAmounts() {
		return new Integer[][] {{100},{200},{20000}};
	}
	
	@Parameters
	private static final Object[] getInvalidTermAmounts() {
		return new Integer[][] {{1},{2},{11},{12}};
	}
	
	
	
	@Test
	@Parameters(method="getValidInvestmentAmounts")
	public void testValidInvestmentAmounts(int investment, int term, double finalAmount) {
		assertEquals(finalAmount, InvestmentValue.calculateInvestmentValue(term,investment),0.01);
	}
	
	@Test
	@Parameters(method="getValidInvestmentAmounts")
	public void testValidTermLength(int investment, int term, double finalAmount) {
		assertEquals(finalAmount, InvestmentValue.calculateInvestmentValue(term,investment),0.01);
	}

	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidTermAmounts")
	public void testThrowIAEForInvalidTerm(int term) {
		InvestmentValue.calculateInvestmentValue(term, VALID_INVESTMENT);
	}
//	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidInvestmentAmounts")
	public void testThrowIAEForInvalidInvestmentAmount(int startAmount) {
		InvestmentValue.calculateInvestmentValue(VALID_TERM, startAmount);
	}
	
	

}
