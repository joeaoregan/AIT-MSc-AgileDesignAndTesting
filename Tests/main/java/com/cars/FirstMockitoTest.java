package main.java.com.cars;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class FirstMockitoTest {

	private Car myFerrari = mock(Car.class);

	@Test
	public void testIfCarIsACar() {
		assertTrue(myFerrari instanceof Car);
	}
}
