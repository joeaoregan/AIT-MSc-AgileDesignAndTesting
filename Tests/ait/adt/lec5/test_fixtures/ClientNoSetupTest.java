/*
 * Week 5
 * 11/10/2018
 * Lec5: S24
 */
package ait.adt.lec5.test_fixtures;
//package main.java.com.unittestex2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClientNoSetupTest {
	private Address addressA = new Address("street A");
	private Address addressB = new Address("street B");
	
	@Test
	public void afterCreationShouldHaveNoAddress() {
		Client client = new Client();
		assertEquals(client.getAddresses().size(), 0);
	}
	
	@Test
	public void shouldAllowToAddAddress() {
		Client client = new Client();
		client.addAddress(addressA);
		assertEquals(client.getAddresses().size(), 1);
		assertTrue(client.getAddresses().contains(addressA));
	}

	@Test
	public void shouldAllowToAddManyAddresses() {
		Client client = new Client();
		client.addAddress(addressA);
		client.addAddress(addressB);
		assertEquals(client.getAddresses().size(), 2);
		assertTrue(client.getAddresses().contains(addressA));
		assertTrue(client.getAddresses().contains(addressB));
	}
}
