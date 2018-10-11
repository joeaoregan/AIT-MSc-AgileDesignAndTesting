/*
 * Intro to Exceptions S10
 * 11/10/2018
 */
package com.ait.exceptions;

public class FutureValueException {
	public double calculateFutureValue(double monthlyPayment, double monthlyInterestRate, int months) {
		if (monthlyPayment <= 0)
			throw new IllegalArgumentException("Monthly payment must be > 0");
		if (monthlyInterestRate <= 0)
			throw new IllegalArgumentException("Interest rate must be > 0");
		if (months <= 0)
			throw new IllegalArgumentException("Months must be > 0");

		// code to calculate and return future value goes here
		return 0.0;
	}

}
