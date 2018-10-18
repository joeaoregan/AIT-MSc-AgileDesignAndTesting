/*
 * Lec5 jUnit and TDD - S19
 * Testing Expected Exceptions
 */
package ait.adt.lec5.expected_exceptions;

import org.junit.Test;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class MoneyIEATest {
	private final static int VALID_AMOUNT = 5;
	private final static String VALID_CURRENCY = "USD";

	@Parameters
	private static final Object[] getInvalidAmount() {
		return new Integer[][] {{-12387}, {-5},{-1}};
	}
	@Test(expected=IllegalArgumentException.class)
	@Parameters(method = "getInvalidAmount")
	public void testConstructorShouldThrowIAEForInvalidAmount(int invalidAmount) {
		new Money2(invalidAmount, VALID_CURRENCY);
	}
	
	/* S21 */
	@Parameters
	private static final Object[] getInvalidCurrency() {
		return new String[][] {{null},{""}};
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidCurrency")
	public void testConstructorShouldThrowIAEForInvalidCurrency(String invalidCurrency) {
		new Money2(VALID_AMOUNT, invalidCurrency);
	}
	
//	@Parameters
//	private static final Object[] getValidAmount() {
//		return new Integer[][] {{10}, {20},{30}};
//	}
//	@Test(expected=IllegalArgumentException.class)
//	@Parameters(method = "getValidAmount")
//	public void testConstructorShouldThrowIAEForInvalidCurrency(int validAmount) {
//		new Money2(validAmount, null);
//		new Money2(validAmount, "");
//	}
}
