package ait.adt.sampass1.solution;
//package com.ait.loan;

public class LoanCalculator {

	private static final double RATE_A = 0.1, RATE_B = 0.15;

	public double calculateInterest(String customerName, String accountNum, int loanAmount, int term) {
     
    
   
		if ((customerName.length() < 2) || (customerName.length() > 10)) {
			throw new IllegalArgumentException("illegal name: " + customerName);
		}
		
		if ((customerName.length() >= 2) && (customerName.length() <= 10)) {
			for (int i = 0; i < customerName.length(); i++) {
				char ch = customerName.charAt(i);
				if (!Character.isLetter(ch)) {
					throw new IllegalArgumentException("illegal name: " + customerName);
				}
			}
		}
		if ((accountNum.length() != 6) || (accountNum.charAt(1) == 0)) {
			throw new IllegalArgumentException("illegal acount number: " + accountNum);
		}
		
		if ((loanAmount < 500) || (loanAmount > 9000)) {
			throw new IllegalArgumentException("illegal loan amount: " + loanAmount);
		}
		if (term < 1 || term > 30) {
			throw new IllegalArgumentException("illegal term: " + term);
		}
		
		
		double interest =0;
		
		if (loanAmount < 5000){
			interest = loanAmount * term* RATE_A;
		}
		else{
			interest = loanAmount * term* RATE_B;
		}

		return interest;
	}

}
