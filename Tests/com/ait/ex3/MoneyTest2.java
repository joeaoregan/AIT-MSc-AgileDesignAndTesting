/*
 * Joe O'Regan
 * A00258304
 * 08/10/2018 (Up to date)
 * 
 * Ex5c - Ex3 Paramaterized Tests
 * MoneyTest2.java
 */
package com.ait.ex3;

import static org.junit.Assert.*;
import org.junit.Test;
import static junitparams.JUnitParamsRunner.$;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class MoneyTest2 {

	@Parameters
	private static final Object[] getEqual() {
		return $($(10, "USD"), $(20, "EUR"), $(15, "GBP"));
	}

	@Parameters
	private static final Object[] getAmountNotEqual() {
		return $($(10, 20, "USD"), $(20, 15, "EUR"), $(15, 10, "GBP"));
	}

	@Parameters
	private static final Object[] getCurrencyNotEqual() {
		return $($(10, "USD", "EUR"), $(20, "EUR", "GBP"), $(15, "GBP", "USD"));
	}

	@Test
	@Parameters(method = "getEqual")
	public void testConstructorShouldSetAmountAndCurrency(int amount, String currency) {
		Money money = new Money(amount, currency);
		assertEquals(money.getAmount(), amount);
		assertEquals(money.getCurrency(), currency);
	}

	@Test
	@Parameters(method = "getEqual")
	public void testEqualValues(int amount, String currency) {
		Money moneyOne = new Money(amount, currency);
		Money moneyTwo = new Money(amount, currency);
		assertTrue(moneyOne.equals(moneyTwo));
	}

	@Test
	@Parameters(method = "getAmountNotEqual")
	public void testCurrencyEqualAndAmountsNotEqual(int amount1, int amount2, String currency) {
		Money money1 = new Money(amount1, currency);
		Money money2 = new Money(amount2, currency);

		assertFalse(money1.equals(money2));
	}

	@Test
	@Parameters(method = "getCurrencyNotEqual")
	public void testAmountsEqualAndCurrencyNotEqual(int amount, String currency1, String currency2) {
		Money money1 = new Money(amount, currency1);
		Money money2 = new Money(amount, currency2);

		assertFalse(money1.equals(money2));
	}
}
