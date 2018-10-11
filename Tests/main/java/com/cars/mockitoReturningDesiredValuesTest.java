/*
 * L5S60
 * 11/10/2018
 */
package main.java.com.cars;

public class mockitoReturningDesiredValuesTest {
	private Car myFerrari = mock(Car.class);
	
	@Test
	pubic void testStubbing() {
		assertFalse("new test double should return false as boolean",
				myFerrari.needsFuel());
		when(myFerrari.needsFuel()).thenReturn(true);
		assertTrue("after instruction test double returns what we want",
				myFerrari.needsFuel());
	}
}
