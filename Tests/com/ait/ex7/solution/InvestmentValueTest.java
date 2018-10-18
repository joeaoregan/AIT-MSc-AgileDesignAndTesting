package com.ait.ex7.solution;
//package com.ait.investment;

import com.ait.ex7.investment.InvestmentValue;

import static org.junit.Assert.*;
import org.junit.Test;
import static junitparams.JUnitParamsRunner.$;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class InvestmentValueTest {
	private final int VALID_TERM=4;
	private final int VALID_INVESTMENT=2000;
	
	@Parameters
	private static final Object[] getValidInvestmentAmounts(){
		return $(
				$(1000,3,1061.21),       
				$(1001,4,1083.51),   
				$(2000,5,2208.16),
				$(2998,6,3376.23),
				$(2999,6,3377.36),
				$(3000,7,4221.30),
				$(3001,8,4433.84),
				$(4000,9,6205.31),
				$(4998,10,8141.22),
				$(4999,10,8142.84),
				$(5000,3,6125.22),
				$(5001,4,6555.29),
				$(7000,5,9817.86),
				$(9999,6,15005.80),
				$(10000,7,16057.81)
		);
	}
	
	@Parameters
	private static final Object[] getInValidInvestmentAmounts(){
		return $(
				$(999),       
				$(10001)
		);
	}
	
	@Parameters
	private static final Object[] getInValidTerm(){
		return $(
				$(2),       
				$(11)
		);
	}
	
	@Test
	@Parameters(method="getValidInvestmentAmounts")
	public void testValidInvestmentAmounts(int investment, int term, double finalAmount) {
		assertEquals(finalAmount, InvestmentValue.calculateInvestmentValue(term,investment),0.01);
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method="getInValidInvestmentAmounts")
	public void testInValidInvestmentAmounts(int investment) {
		InvestmentValue.calculateInvestmentValue(VALID_TERM,investment);
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method="getInValidTerm")
	public void testInValidTermAmounts(int term) {
		InvestmentValue.calculateInvestmentValue(term,VALID_INVESTMENT);
	}

}
