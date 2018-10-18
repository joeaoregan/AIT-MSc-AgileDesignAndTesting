/*
 * Lec5 jUnit and TDD - S18
 * Testing Expected Exceptions
 */
package ait.adt.lec5.expected_exceptions;

public class Money2 {
	int amount;
	String currency;
	
	public Money2(int amount, String currency) {
		if (amount < 0) {
			throw new IllegalArgumentException("illegal amount: ["+amount+"]");
		}
		if(currency==null||currency.isEmpty()) {
			throw new IllegalArgumentException("illegal currency: ["+currency+"]");
		}
		this.amount = amount;
		this.currency = currency;
	}
}
