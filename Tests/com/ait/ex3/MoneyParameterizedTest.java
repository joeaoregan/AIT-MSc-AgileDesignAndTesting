package com.ait.ex3;

import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
//import org.junit.runner.RunWith;

//import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

//@RunWith(JUnitParamsRunner.class)
public class MoneyParameterizedTest {

	@Parameters
	private static final Object[] getMoney() {
		return new Object[] {
				new Object[] {10,"USD"},
				new Object[] {20, "EUR"},
				new Object[] {15, "GBP"},
		};
	}

	@ParameterizedTest
	@MethodSource("getMoney")
	public void testConstructorShouldSetAmountAndMoney(int amount, String currency) {
		Money money = new Money(amount, currency);
		assertEquals(currency, money.getCurrency());
		assertEquals(amount, money.getAmount());
	}
	
	@ParameterizedTest
	@MethodSource("getMoney")
	public void testAmountAndCurrencyEqual(int amount, String currency) {
		Money money = new Money(amount, currency);
		assertEquals(currency, money.getCurrency());
		assertEquals(amount, money.getAmount());
	}
	
	@ParameterizedTest
	@MethodSource("getMoney")
	public void testCurrencyEqualAndAmountsNotEqual() {
		
	}
}
