package ait.adt.sampass1;

import static junitparams.JUnitParamsRunner.$;

import org.junit.Before;
import org.junit.Test;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class LoanCalculatorTest {
	
	LoanCalculator lc;
	
	@Before
	public void setup() {
		lc = new LoanCalculator();
	}

	@Parameters
	private static final Object[] getValidNameLength() {
		return $($("NameOne","123456",500,1), $("NameTwo","234567",9000,30));
	}

	@Parameters
	private static final Object[] getInvalidNameLength() {
		return $($("nn","123456",500,1), $("NameTooLarge","234567",9000,30));
	}

	@Parameters
	private static final Object[] getInvalidNameSpaces() {
		return $($("Mr Joe","Sir Joe",500,1), $("NameTooLarge","234567",9000,30));
	}

	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getValidNameLength")
	public void testValidNameLength(String name, String account, int amount, int term) {
		assertEquals(0.0, lc.calculateInterest(name, account, amount, term));
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidNameLength")
	public void testInvalidNameLength(String name, String account, int amount, int term) {
		lc.calculateInterest(name, account, amount, term);
	}

	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidNameSpaces")
	public void testInvalidNameSpaces(String name, String account, int amount, int term) {
//		assertEquals(0.0, lc.calculateInterest(name, account, amount, term));
		lc.calculateInterest(name, account, amount, term);
	}

	@Parameters
	private static final Object[] getInvalidAccountLength() {
		return $($("NameOne","12345",500,1), $("NameTwo","1234567",9000,30));
	}
	
	@Parameters
	private static final Object[] getInvalidAccount() {
		return $($("NameOne","a12345",500,1), $("NameTwo","1234z6",9000,30));
	}
	@Parameters
	private static final Object[] getInvalidAccountStart() {
		return $($("NameOne","012345",500,1), $("NameTwo","023456",9000,30));
	}

	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidAccountLength")
	public void testInvalidAccountLength(String name, String account, int amount, int term) {
		lc.calculateInterest(name, account, amount, term);
	}
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidAccount")
	public void testInvalidAccount(String name, String account, int amount, int term) {
		lc.calculateInterest(name, account, amount, term);
	}

	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidAccountStart")
	public void testInvalidAccountStart(String name, String account, int amount, int term) {
		lc.calculateInterest(name, account, amount, term);
	}


	@Parameters
	private static final Object[] getInvalidLoanAmount() {
		return $($("NameOne","123456",200,1), $("NameTwo","234567",10000,30));
	}
	@Parameters
	private static final Object[] getInvalidTerm() {
		return $($("NameOne","123456",500,-1), $("NameTwo","234567",9000,33));
	}
	@Parameters
	private static final Object[] getInterestRate() {
		return $($("NameOne","123456",1000,2,200.0), $("NameTwo","234567",5000,3,2250.0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidLoanAmount")
	public void testInvalidLoanAmount(String name, String account, int amount, int term) {
		lc.calculateInterest(name, account, amount, term);
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidTerm")
	public void testInvalidTermLength(String name, String account, int amount, int term) {
		lc.calculateInterest(name, account, amount, term);
	}
	
//	@Test(expected = IllegalArgumentException.class)
//	@Parameters(method = "getInterestRate")
//	public void testValidInterestRate(String name, String account, int amount, int term, double interest) {
//		assertEquals(interest, lc.calculateInterest(name, account, amount, term));
//	}
}
