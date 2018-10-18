/*
 * Week 5
 * 11/10/2018
 * Lec5: S28
 */
package ait.adt.lec5.test_fixtures;
//package main.java.com.unittestex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClientTest {
	private Address addressA = new Address("street A");
	private Address addressB = new Address("street B");
	Client client;
	
	@BeforeEach
	public void setUp() {
		client = new Client();
	}
	
	@Test
	public void afterCreationShouldHaveNoAddress() {
		assertEquals(client.getAddresses().size(), 0);
	}

	@Test
	public void shouldAllowToAddManyAddresses() {
		client.addAddress(addressA);
		client.addAddress(addressB);
		assertEquals(client.getAddresses().size(), 2);
		assertTrue(client.getAddresses().contains(addressA));
		assertTrue(client.getAddresses().contains(addressB));
	}
	
	@Test
	public void shouldAllowToAddAddress() {
		client.addAddress(addressA);
		assertEquals(client.getAddresses().size(), 1);
		assertTrue(client.getAddresses().contains(addressA));
	}
}
