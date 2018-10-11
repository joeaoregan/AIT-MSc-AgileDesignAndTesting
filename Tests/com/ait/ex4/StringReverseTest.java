package com.ait.ex4;

import static org.junit.Assert.assertEquals;
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
		assertEquals("ASS", StringReverse.reverse("SSA"));
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
