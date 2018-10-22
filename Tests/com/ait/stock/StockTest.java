/*
 * A00258304
 * 22/10/2018
 */
package com.ait.stock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class StockTest {

	private StockBroker stockBroker = mock(StockBroker.class);	// Create StockBroker instance using Mockito
	private StockListener stockListener;
	private Stock stock;
	
	@BeforeEach
	public void setup() {
		stockListener = new StockListener(stockBroker);
		stock = new Stock("stock1", 100.0);
	}
		
	@Test
	void testBuyStockWhenPriceGoesDown() {
		when(stockBroker.getQoute(stock)).thenReturn(90.0);
		stockListener.takeAction(stock);
		verify(stockBroker).buy(stock,100);
	}
	
	@Test
	void testSellStockWhenPriceGoesUp() {
		when(stockBroker.getQoute(stock)).thenReturn(125.0);
		stockListener.takeAction(stock);
		verify(stockBroker).sell(stock,10);
	}
}
