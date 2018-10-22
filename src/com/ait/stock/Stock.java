/*
 * Mockito
 * 22/10/2018
 */
package com.ait.stock;

public class Stock {
	private String id;
	private Double lastValue;

	public Stock(String id, Double lastValue) {
		super();
		this.id = id;
		this.lastValue = lastValue;
	}

	public String getId() {
		return id;
	}

	public Double boughtAt() {
		return lastValue;
	}

	public void changePrice(Double newPrice) {
		this.lastValue = newPrice;
	}
}
