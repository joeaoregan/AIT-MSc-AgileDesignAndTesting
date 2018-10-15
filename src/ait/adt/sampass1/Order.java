/*
 * Joe O'Regan
 * A00258304
 * 15/10/2018
 * Sample Assessment 2 Part 1
 */
package ait.adt.sampass1;

public class Order {
	public double calculateOrderTotal(int numCartridge) {
		double unitPrice = 10.0;
		
		if (numCartridge < 5) {
			throw new IllegalArgumentException(
				"Min order quantity is 5");
		} else if (numCartridge > 500) {
			throw new IllegalArgumentException(
					"Max order quantity is 500");
		}
		
		if (numCartridge < 100) {
			unitPrice = 10.0;
		} else {
			unitPrice = 9.0;
		}
		 
		return numCartridge * unitPrice;
	}
}
