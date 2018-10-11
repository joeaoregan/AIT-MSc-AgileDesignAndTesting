package main.java.com.cars;

import org.junit.Test;
import main.java.com.cars.Car;
import static org.mockito.Mockito.*;

class mockitoReturningDesiredValuesTestExceptions {
	private Car myFerrari = mock(Car.class);
	
	@Test(expected = RuntimeException.class)
	public void throwException() {
		when(myFerrari.needsFuel()).thenThrow(new RuntimeException());
		myFerrari.needsFuel();
	}

}
