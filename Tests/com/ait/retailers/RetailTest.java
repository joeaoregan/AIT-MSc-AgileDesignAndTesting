/*
 * A00258304
 * 25/10/2018
 */
package com.ait.retailers;

//import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyDouble;
//import static org.mockito.Mockito.times;
import org.mockito.internal.verification.Times;
import static org.junit.Assert.*;

import java.util.ArrayList;

//import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Joe O'Regan
 * A00258304
 * 25/10/2018
 */
class RetailTest {

	private BiggestBazarRetail bbr;
	private Inventory inventory;
	private PublicAddressSystem pas;
	private Item item1;
	private Item item2;
	private Item item3;

	ArrayList<Item> expiringItems;

	@BeforeEach
	public void setup() {
		expiringItems = new ArrayList<Item>();
		inventory = mock(Inventory.class);
		pas = mock(PublicAddressSystem.class);
		bbr = new BiggestBazarRetail(inventory, pas);

		item1 = new Item("barcode1", "item name 1", 10.0, 5.0);
		item2 = new Item("barcode2", "item name 2", 10.0, 10.0);
		item3 = new Item("barcode3", "item name 3", 20.0, 10.0);
	}

	@Test
	void testDiscountOrderedOnOneItem() {
		expiringItems.add(item1);
		when(inventory.getItemsExpireInAMonth()).thenReturn(expiringItems);
		
		bbr.issueDiscountForItemsExpireIn30Days(0.1);
		when(inventory.itemsUpdated()).thenReturn(1);

		verify(inventory).itemsUpdated();
		verify(inventory).update(item1, 9.0);	// verify update method is called with discounted price
		verify(pas).announce(isA(Offer.class));	// isA() is a method in Mockito
		
	}
	
	@Test
	void testNoItemDiscountIfDiscountedPriceLessThanBasePrice() {
		expiringItems.add(item2);		
		when(inventory.getItemsExpireInAMonth()).thenReturn(expiringItems);
		when(inventory.itemsUpdated()).thenReturn(1);
		
		int numItems = bbr.issueDiscountForItemsExpireIn30Days(0.1);
		
		verify(pas, never()).announce(isA(Offer.class));
//		verify(inventory, never()).update(item1, 9.0);	
		verify(inventory, new Times(0)).update(item1, 9.0);	
		assertEquals(1,numItems);
	}
	
	@Test
	void testTwoItemsQualifyForDiscount() {
		expiringItems.add(item1);
		expiringItems.add(item2);	
		expiringItems.add(item3);	
		when(inventory.getItemsExpireInAMonth()).thenReturn(expiringItems);
		
		when(inventory.itemsUpdated()).thenReturn(3);
		bbr.issueDiscountForItemsExpireIn30Days(0.1);
		
		verify(inventory).itemsUpdated();
		
		verify(inventory).update(item1, 9.0);
		verify(inventory).update(item3, 18.0);
		verify(inventory, new Times(2)).update(isA(Item.class), anyDouble());

//		verify(pas, times(2)).announce(isA(Offer.class));
		verify(pas, new Times(2)).announce(isA(Offer.class));
//		verify(inventory, times(2)).update();
		
	}
}
