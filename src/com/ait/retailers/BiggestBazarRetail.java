package com.ait.retailers;

import java.util.ArrayList;

public class BiggestBazarRetail {

	private Inventory inventory;
	private PublicAddressSystem publicAddressSystem;

	public BiggestBazarRetail(Inventory inventory,
			PublicAddressSystem publicAddressSystem) {
		this.inventory = inventory;
		this.publicAddressSystem = publicAddressSystem;
	}

	public int issueDiscountForItemsExpireIn30Days(double discountRate) {
		ArrayList<Item> headingExpiryItems = inventory.getItemsExpireInAMonth();
		for (Item anItem : headingExpiryItems) {
			double newPrice = anItem.getPrice() - anItem.getPrice()
					* discountRate;
			if (newPrice > anItem.getBasePrice()) {
				inventory.update(anItem, newPrice);
				publicAddressSystem.announce(new Offer(anItem, newPrice));
			}
		}
		return inventory.itemsUpdated();
	}

}
