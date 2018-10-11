package main.java.com.cars;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.com.cars.Car;

class mockitoReturningDesiredValuesTestExceptions {
	private Car myFerrari = mock(Car.class);
	
	@Test(expected = RuntimeException.class)
	void void throwException() {
		when(myFerrari.needsFuel()).thenThrow(new RuntimeException());
		myFerrari.needsFuel();
	}

}
