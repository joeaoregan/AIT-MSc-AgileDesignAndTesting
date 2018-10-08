/*
 * Joe O'Regan
 * A00258304
 * 08/10/2018
 * 
 * Testing: Ex3
 * MoneyTest.java
 */
package com.ait.ex3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoneyTest {
	Money money1;
	Money money2;
	Money money3;

	@BeforeEach
	void setup() {
		money1 = new Money(10, "USD");
		money2 = new Money(20, "EUR");
		money3 = new Money(15, "GBP");
	}

	@Test
	void testConstructorShouldSetAmountAndCurrency() {
		Money money1 = new Money(10, "USD");
		Money money2 = new Money(20, "EUR");
		Money money3 = new Money(15, "GBP");

		assertEquals(10, money1.getAmount());
		assertEquals("USD", money1.getCurrency());
		assertEquals(20, money2.getAmount());
		assertEquals("EUR", money2.getCurrency());
		assertEquals(15, money3.getAmount());
		assertEquals("GBP", money3.getCurrency());
	}

	@Test
	void testAmountAndCurrencyEqual() {
		assertEquals(10, money1.getAmount());
		assertEquals("USD", money1.getCurrency());
		assertEquals(20, money2.getAmount());
		assertEquals("EUR", money2.getCurrency());
		assertEquals(15, money3.getAmount());
		assertEquals("GBP", money3.getCurrency());
	}

	@Test
	void testCurrencyEqualAndAmountsNotEqual() {
		assertNotEquals(20, money1.getAmount());
		assertEquals("USD", money1.getCurrency());
		assertNotEquals(15, money2.getAmount());
		assertEquals("EUR", money2.getCurrency());
		assertNotEquals(10, money3.getAmount());
		assertEquals("GBP", money3.getCurrency());
	}

	@Test
	void testAmountsEqualAndCurrencyNotEqual() {
		assertEquals(10, money1.getAmount());
		assertNotEquals("EUR", money1.getCurrency());
		assertEquals(20, money2.getAmount());
		assertNotEquals("GBP", money2.getCurrency());
		assertEquals(15, money3.getAmount());
		assertNotEquals("USD", money3.getCurrency());
	}

}
