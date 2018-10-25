package com.ait.retailers;

public class Item {
	private final String barCode;
	private final String name;
	private final Double cost;
	private final Double basePrice;

	public String getBarCode() {
		return barCode;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return cost;
	}

	public Item(String barCode, String name, Double cost, Double basePrice) {
		super();
		this.barCode = barCode;
		this.name = name;
		this.cost = cost;
		this.basePrice = basePrice;
	}

	public Double getBasePrice() {
		return basePrice;
	}

}