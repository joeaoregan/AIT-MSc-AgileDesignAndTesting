package ait.adt.sampass1.solution;
//package com.ait.loan;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.*;
import static junitparams.JUnitParamsRunner.$;

@RunWith(JUnitParamsRunner.class)
public class LoanCalculatorTest {

	private LoanCalculator loanCalc;

	private final String VALID_NAME = "Kate";
	private final String VALID_ACCOUNT_NUM = "123456";
	private final int VALID_TERM = 10;
	private final int VALID_LOAN_AMOUNT = 1000;

	// test invalid loan amount 499, 9001
	@Parameters
	private static final Object[] getInvalidLoanAmount() {
		return $($(499), $(9001));
	}

	// test invalid term durations 0, 31
	@Parameters
	private static final Object[] getInvalidTerm() {
		return $($(0), $(31));
	}

	// test invalid customer names 1 and 11 chars, spaces, numbers
	@Parameters
	private static final Object[] getInvalidCustomerName() {
		return $($("a"), $("qwertyuiopa"), $("a b d c"), $("ab23c"));
	}

	// test invalid account num starts with 0, 5 digits, 7 digits, 0 not starting
	@Parameters
	private static final Object[] getInvalidAccountNum() {
		return $($("012345"), $("12345"), $("1234567"), $("1200567"));
	}

	// testing loan amount 500, 501, 4998, 4999, 5000, 5001, 8999, 9000
	// test term 1, 2, 29, 30
	// test name 2,3,9,10 chars
	@Parameters
	private static final Object[] getValidInterestAmount() {
		return $($("Jo", "123456", 500, 1, 50), $("Dee", "238046", 501, 2, 100.2),
				$("MichelleA", "123456", 4998, 29, 14494.2), $("Jacqueline", "123456", 4999, 30, 14997),
				$("Jo", "980067", 5000, 1, 750), $("Dee", "145075", 5001, 2, 1500.3),
				$("MichelleA", "123456", 8999, 29, 39145.65), $("Jacqueline", "123456", 9000, 30, 40500));

	}

	@Before
	public void setUp() {
		loanCalc = new LoanCalculator();
	}

	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidLoanAmount")
	public void testInvalidLoanAmount(int loanAmount) {
		loanCalc.calculateInterest(VALID_NAME, VALID_ACCOUNT_NUM, VALID_TERM, loanAmount);
	}

	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidTerm")
	public void testInvalidTerm(int term) {
		loanCalc.calculateInterest(VALID_NAME, VALID_ACCOUNT_NUM, term, VALID_LOAN_AMOUNT);
	}

	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidCustomerName")
	public void testInvalidCustomerName(String customerName) {
		loanCalc.calculateInterest(customerName, VALID_ACCOUNT_NUM, VALID_TERM, VALID_LOAN_AMOUNT);
	}

	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidAccountNum")
	public void testInvalidAccountNum(String accountNum) {
		loanCalc.calculateInterest(VALID_NAME, accountNum, VALID_TERM, VALID_LOAN_AMOUNT);
	}

	@Test
	@Parameters(method = "getValidInterestAmount")
	public void testValidInterestAmount(String customerName, String accountNum, int loanAmount, int term,
			double interest) {
		assertEquals(interest, loanCalc.calculateInterest(customerName, accountNum, loanAmount, term), 0.01);
	}

}
