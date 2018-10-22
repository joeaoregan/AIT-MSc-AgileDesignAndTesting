/*
 * Mockito
 * 22/10/2018
 */
package com.ait.stock;

public class StockListener {
	private final StockBroker broker;

	public void takeAction(Stock stock) {
		double currentPrice = broker.getQoute(stock);
		if (currentPrice <= stock.boughtAt()) {	// If the price has dropped or remains the same
			broker.buy(stock, 100);				// buy 100 units
		} else {
			broker.sell(stock, 10);				// otherwise sell 10 unites
		}
	}

	public StockListener(StockBroker broker) {
		this.broker = broker;
	}
}
