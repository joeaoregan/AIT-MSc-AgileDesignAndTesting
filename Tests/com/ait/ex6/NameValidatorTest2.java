package com.ait.ex6;

//import static org.junit.Assert.*;
import static junitparams.JUnitParamsRunner.$;

import org.junit.Before;
import org.junit.Test;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;
//import org.junit.runners.Parameterized.Parameters;

//import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class NameValidatorTest2 {
	NameValidator nv;

	@Before
	public void setup() {
		nv = new NameValidator();
	}

	@Parameters
	private static final Object[] getValidNameLength() {
		return $($("NameOne"), $("NameTwo"));
	}

	@Parameters
	private static final Object[] getInvalidNameLength() {
		return $($("nn"), $("NameWithTwentyCharacters"));
	}

	@Parameters
	private static final Object[] getInvalidCharacters() {
		return $($("name1"), $("hyphenated-name"));
	}

	@Test
	@Parameters(method = "getValidNameLength")
	public void testValidNameLength(String name) {
		assertTrue(nv.checkName(name));
	}

	@Test
	@Parameters(method = "getInvalidNameLength")
	public void testInvalidNameLength(String name) {
		assertFalse(nv.checkName(name));
	}

	@Test
	@Parameters(method = "getInvalidCharacters")
	public void testInvalidCharacters(String name) {
		assertFalse(nv.checkName(name));
	}
}
