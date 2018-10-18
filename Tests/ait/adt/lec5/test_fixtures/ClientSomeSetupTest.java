/*
 * Week 5
 * 11/10/2018
 * Lec5: S26
 */
package ait.adt.lec5.test_fixtures;
//package main.java.com.unittestex2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClientSomeSetupTest {
	private Address addressA = new Address("street A");
	private Address addressB = new Address("street B");
	Client client = new Client();
	
	@Test
	public void afterCreationShouldHaveNoAddress() {
		assertEquals(client.getAddresses().size(), 0);
	}
	
	@Test
	public void shouldAllowToAddAddress() {
		client.addAddress(addressA);
		assertEquals(client.getAddresses().size(), 1);
		assertTrue(client.getAddresses().contains(addressA));
	}

	@Test
	public void shouldAllowToAddManyAddresses() {
		client.addAddress(addressA);
		client.addAddress(addressB);
		assertEquals(client.getAddresses().size(), 2);
		assertTrue(client.getAddresses().contains(addressA));
		assertTrue(client.getAddresses().contains(addressB));
	}
}
