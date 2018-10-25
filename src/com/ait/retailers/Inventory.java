package com.ait.retailers;

import java.util.ArrayList;

public interface Inventory {
	public ArrayList<Item> getItemsExpireInAMonth();

	public void update(Item anItem, double newPrice);

	public int itemsUpdated();
}
