/*
 * Solution
 */
package com.ait.money;

public class Money{
	private final int amount;
	private final String currency;
	
	public Money(int amount, String currency){
		if (amount<=0){
			throw new IllegalArgumentException(
					"illegal amount: ["+amount +"]");
		}
		if (!(currency.equals("USD"))&&!(currency.equals("EUR"))&&!(currency.equals("GBP"))){
			throw new IllegalArgumentException(
					"illegal currency: ["+currency +"]");
		}
		this.amount=amount;
		this.currency=currency;
	}
	
	public int getAmount(){
		return amount;
	}
	
	public String getCurrency(){
		return currency;
	}
	
	public boolean equals(Object anObject){
		if (anObject instanceof Money){
			Money money = (Money) anObject;
			return money.getCurrency().equals(this.currency)&&
					this.amount==money.getAmount();		}
		return false;
	}
	
}

