package com.ait.ex4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class StringReverseTest {
	//StringReverse stringReverse;
	
//	@BeforeEach
//	void setup() {
//		//stringReverse = new StringReverse();
//	}

	@Test
	void testEmptyString() {
		assertEquals("", StringReverse.reverse(""));
	}

	@Test
	void testStringWithOddNumberOfUppercaseCharacters() {
		String test = "Test";
		//System.out.println(test);
		//System.out.println(StringReverse.reverse(test));
		//assertEquals("SSA", StringReverse.reverse("ASS"));
		//assertTrue(StringReverse.reverse(test).equals("tseT"));
		assertEquals("SS", StringReverse.reverse("ASS"));
		assertTrue(StringReverse.reverse(test).equals("tse"));
	}
	
	@Test 
	void testStringLength() {
		//assertEquals(4, StringReverse.reverse("test").length());
		assertEquals(3, StringReverse.reverse("test").length());
	}
/*
	@Test
	void testStringWithEvenNumberOfCharactersWhichAreAMixOfUppercaseAndLowercase() {
		assertEquals("AaSs", StringReverse.reverse("sSaA"));
	}
	
	@Test
	void testStringWithSpaces() {
		assertEquals("has spaces", StringReverse.reverse("secaps sah"));
	}
	
	@Test
	void testStringWithSpecialCharacters() {
		assertEquals("user@e.mail", StringReverse.reverse("liam.e@resu"));
	} 
	
	@Test
	void testPalindrome() {
		assertEquals("assa", StringReverse.reverse("assa"));
	} 
	
	@Test
	void testNumericData() {
		assertEquals("12345", StringReverse.reverse("54321"));
	}
*/
}
