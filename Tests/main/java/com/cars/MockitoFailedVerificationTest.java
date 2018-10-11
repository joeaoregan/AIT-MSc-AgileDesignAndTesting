/*
 * L5S63
 * Mockito - Failed Verification
 * 11/10/2018
 */
package main.java.com.cars;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class MockitoFailedVerificationTest {
	private Car myFerrari = mock(Car.class);
	
	@Test
	public void testVerificationFailure() {
		myFerrari.needsFuel();
		verify(myFerrari).getEngineTemperature();
	}
}
