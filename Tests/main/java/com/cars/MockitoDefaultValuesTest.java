/*
 * L5S59
 * Mockito - default values returned
 * 11/10/2018
 */
package main.java.com.cars;

//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

class MockitoDefaultValuesTest {

	private Car myFerrari = mock(Car.class)
			;
	@Test
	public void testDefaultBehaviourOfTestDouble() {
		assertFalse("New test double should return false as boolean", myFerrari.needsFuel());
		assertEquals("New test double should return 0.0 as double", 0.0, myFerrari.getEngineTemperature(), 0.01);
	}

}
