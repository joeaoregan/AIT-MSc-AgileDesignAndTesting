package com.ait.payment;


public interface PayPalFacade {

	void sendAdvice(double amount, String accountId);

}
