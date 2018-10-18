/*
 * A00258304
 */
package com.ait.delivery;

public class DeliveryCharge {
	final static double MIN_ORDER_ACCEPTED = 0.01;
	final static double MAX_ORDER_ACCEPTED = 10000.0;
	
	public double calculateCharge(double orderAmount) {
		double deliveryCharge = 0.0;

		if (orderAmount < MIN_ORDER_ACCEPTED || orderAmount > MAX_ORDER_ACCEPTED) {
			throw new IllegalArgumentException("Illegal Order Amount: " + orderAmount);
		} else {
			if (orderAmount < 100.0) {
				deliveryCharge = 8.99;
			} else if (orderAmount >= 100.0 && orderAmount <= 199.99) {
				deliveryCharge = 3.99;
			}
		}

		return deliveryCharge;
	}
}
