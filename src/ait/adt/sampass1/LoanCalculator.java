package ait.adt.sampass1;

public class LoanCalculator {
	public double calculateInterest(String customerName, String accountNo, int loanAmount, int term) {
		// test name
		if (customerName.length() < 2 || customerName.length() > 10) {
			throw new IllegalArgumentException("Illegal name [" + customerName+ "] name must have 2 to 10 characters");
		}
		for (int i = 0; i < customerName.length(); i++) {
			char ch = customerName.charAt(i);
			if (!Character.isLetter(ch)) {
				throw new IllegalArgumentException("Illegal character [" + customerName+ "] name must only letters");
			}
		}
		// test a/c no.
		if (accountNo.length() != 6) {
			throw new IllegalArgumentException("Illegal account size [" + customerName+ "] not enough digits in account number");
		}
		for (int i = 0; i < accountNo.length(); i++) {
			char ch = accountNo.charAt(0);
			if (!Character.isDigit(ch)) {
				throw new IllegalArgumentException("Illegal account size [" + customerName+ "] account number should contain only digits");
			}
			if (accountNo.charAt(0) == '0') {
				throw new IllegalArgumentException("Illegal account size [" + customerName+ "] account number should not begin with 0");
			}
		}
		
		if (loanAmount < 500 || loanAmount > 9000) {
			throw new IllegalArgumentException("Illegal loan amount [" + loanAmount+ "] amount ranges from 500 to 9000");
		}
		
		if (term < 1 || term > 30) {
			throw new IllegalArgumentException("Illegal term length ["+term+"]");
		}
		
		double interestRate = 0.0;
		
		if (loanAmount >= 500 && loanAmount <= 4999) {
			interestRate = 0.1;
		} else if (loanAmount >= 5000 && loanAmount <= 9000) {
			interestRate = 0.15;
		}
				
		return loanAmount * interestRate * term;
	}
}
