/*
 * L5S62
 * Mockito - Verification
 * If we want to check did our class call a method
 * 11/10/2018
 */
package main.java.com.cars;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class MockitoVerificationTest {
	private Car myFerrari = mock(Car.class);
	
	@Test
	public void testVerification() {
		myFerrari.driveTo("Belfast");	// Calling methods of the test double
		myFerrari.needsFuel();
		verify(myFerrari).driveTo("Belfast");	// Checking methods have been called
		verify(myFerrari).needsFuel();
	}
}
