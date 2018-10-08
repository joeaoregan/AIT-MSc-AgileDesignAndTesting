/*
 * Joe O'Regan
 * A00258304
 * 08/10/2018
 * 
 * Money.java
 * Testing: ex3
 */
package com.ait.ex3;

public class Money {
	private final int amount;
	private final String currency;
	
	public Money(int amount, String currency) {
		this.amount=amount;
		this.currency=currency;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public boolean equals(Object anObject) {
		if (anObject instanceof Money) {
			Money money = (Money) anObject;
			return money.getCurrency().equals(this.currency)&& 
					this.amount==money.getAmount();
		}
		return false;
	}
}
