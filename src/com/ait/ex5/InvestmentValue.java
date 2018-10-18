/*
 * Exercise 5
 * Repeat Exercise 1 and Exercise 2 using parameterised tests.
 */
package com.ait.ex5;

public class InvestmentValue {
	
	public static double calculateInvestmentValue(int term, int startAmount) {
		double annualInterestRate = 0.02;
		if (startAmount >= 3000 && startAmount < 5000) {
			annualInterestRate = 0.05;
		} else if (startAmount >= 5000 && startAmount <= 10000) {
			annualInterestRate = 0.07;		
		}
		
		double totalAmount = startAmount;
		
		for (int i = 1; i <= term; i++) {
			double interest = totalAmount * annualInterestRate;
			totalAmount += interest;
		}
		
		return totalAmount;
	}
}
