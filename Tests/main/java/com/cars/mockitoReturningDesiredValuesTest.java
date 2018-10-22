/*
 * L5S60
 * Mockito - specify return values
 * Instead of returning the default value of false, you can set it to return true
 * 11/10/2018
 */
package main.java.com.cars;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class mockitoReturningDesiredValuesTest {
	private Car myFerrari = mock(Car.class);

	@Test
	public void testStubbing() {
		assertFalse("new test double should return false as boolean", 
				myFerrari.needsFuel());
		when(myFerrari.needsFuel()).thenReturn(true);
		assertTrue("after instruction test double returns what we want", 
				myFerrari.needsFuel());
	}
}