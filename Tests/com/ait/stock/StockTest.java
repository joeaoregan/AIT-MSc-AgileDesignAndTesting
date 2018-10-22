/*
 * A00258304
 * 22/10/2018
 */
package com.ait.stock;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class StockTest {

	private StockBroker stockBroker = mock(StockBroker.class);	// Create StockBroker instance using Mockito
//	private StockListener stockListener = mock(StockListener.class);
	private StockListener stockListener = new StockListener(stockBroker);
	private Stock stock = new Stock("stock1", 100.0);
//	private Stock stock2 = new Stock("stock1", 50.0);
	//private StockListener stockListener2 = mock(StockListener.class);
	
	@Test
	void testStock() {
		assertTrue(stockBroker instanceof StockBroker);
	}
	
	
//	@Test
//	void stockListenerTest() {	
//		stockListener.takeAction(stock);
//		verify(stockBroker).buy(stock,100);
//		
//		when(stockBroker.getQoute(stock)).thenReturn(120.0);
//		stockListener.takeAction(stock);
//		verify(stockBroker).sell(stock,10);
//	}
	
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
