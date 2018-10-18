/*
 * Lec5 jUnit and TDD - S15
 * Parameterized Tests
 */
package ait.adt.lec5.expected_exceptions;

import static org.junit.Assert.*;
import org.junit.Test;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class MoneyParameterizedTest {

	@Parameters
	private static final Object[] getMoney() {
		return new Object[] { new Object[] { 10, "USD" }, new Object[] { 20, "EUR" } };
	}

	@Test
	@Parameters(method = "getMoney")
	public void testConstructorShouldSetAmountAndMoney(int amount, String currency) {
		Money money = new Money(amount, currency);
		assertEquals(amount, money.getAmount());
		assertEquals(currency, money.getCurrency());
	}
}
