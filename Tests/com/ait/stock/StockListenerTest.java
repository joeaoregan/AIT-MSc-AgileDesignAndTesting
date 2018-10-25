package com.ait.stock;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class StockListenerTest {
	private StockListener stockListener;
	private Stock stock;
	private StockBroker stockBroker=mock(StockBroker.class);

	@Test
	public void testBuyStockwhenPriceGoesdown() {
		when(stockBroker.getQoute(stock)).thenReturn(90.0);
		stockListener=new StockListener(stockBroker);
		stock = new Stock("FDI",100.0);
		stockListener.takeAction(stock);
		verify(stockBroker).buy(stock, 100);
	}

}
