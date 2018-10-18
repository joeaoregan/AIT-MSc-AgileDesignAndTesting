package com.ait.money.test;
import static org.junit.Assert.*;
import org.junit.Test;
import static junitparams.JUnitParamsRunner.$;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.runner.RunWith;

import com.ait.money.Money;

@RunWith(JUnitParamsRunner.class)
public class MoneyTestParam {
	private final int VALID_AMOUNT=5;
	private final String VALID_CURRENCY="USD";
	
	@Parameters
	private static final Object[] getInvalidCurrency(){
		return $(
				$(""),       
				$("a%b"),   
				$("ABC")
		);
	}
	
	@Parameters
	private static final Object[] getInvalidAmount(){
		return $(
				$(0),       
				$(-1),   
				$(-100)
		);
	}
	
	@Parameters
	private static final Object[] getEqual(){
		return $(
				$(10,"USD"),       
				$(20,"EUR"),   
				$(15,"GBP")
		);
	}
	
	@Parameters
	private static final Object[] getAmountsNotEqual(){
		return $(
				$(10,20,"USD"),       
				$(15,20,"EUR"),   
				$(10,15,"GBP")
		);
	}
	
	@Parameters
	private static final Object[] getCurrencyNotEqual(){
		return $(
				$(10,"EUR","USD"),       
				$(20,"EUR","GBP"),   
				$(15,"GBP","USD")
		);
	}
	//This shows that it is possible to send objects as parameters but not really needed.
	@Parameters
	private static final Object[] getObjects(){
		return $(
				$(new Car()),       
				$(new Cat()),   
				$(new Dog())
		);
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method="getInvalidCurrency")
	public void testInvalidCurrency(String currency) {
		new Money(VALID_AMOUNT,currency);
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method="getInvalidAmount")
	public void testInvalidAmount(int amount) {
		new Money(amount,VALID_CURRENCY);
	}
	
	@Test
	@Parameters(method="getEqual")
	public void testEqualValues(int amount, String currency) {
		Money moneyOne=new Money(amount,currency);
		Money moneyTwo=new Money(amount,currency);
		assertTrue(moneyOne.equals(moneyTwo));
	}
	
	@Test
	@Parameters(method="getAmountsNotEqual")
	public void testCurrencyEqualAndAmountsNotEqual(int amountOne,int amountTwo, String currency) {
		Money moneyOne=new Money(amountOne,currency);
		Money moneyTwo=new Money(amountTwo,currency);
		assertFalse(moneyOne.equals(moneyTwo));
	}
	
	@Test
	@Parameters(method="getCurrencyNotEqual")
	public void testAmountsEqualAndCurrencyNotEqual(int amount,String currencyOne, String currencyTwo) {
		Money moneyOne=new Money(amount,currencyOne);
		Money moneyTwo=new Money(amount,currencyTwo);
		assertFalse(moneyOne.equals(moneyTwo));
	}
	
	@Test
	@Parameters(method="getObjects")
	public void testNotMoney(Object object) {
		Money money=new Money(VALID_AMOUNT,VALID_CURRENCY);
		assertFalse(money.equals(object));
	}
	
	
	
}