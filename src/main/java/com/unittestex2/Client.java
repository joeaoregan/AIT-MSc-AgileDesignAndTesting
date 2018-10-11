/*
 * Week 5
 * Lec5 jUnit and TDD S23
 */

package main.java.com.unittestex2;

import java.util.ArrayList;

public class Client {
	private ArrayList<Address> addresses = new ArrayList<Address>();
	
	public void addAddress(Address address) {
		addresses.add(address);
		
	}

	public ArrayList<Address> getAddresses() {
		return addresses;
	}
}
