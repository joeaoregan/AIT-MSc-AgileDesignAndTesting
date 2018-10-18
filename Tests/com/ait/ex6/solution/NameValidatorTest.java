package com.ait.ex6.solution;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static junitparams.JUnitParamsRunner.$;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class NameValidatorTest {
	private NameValidator nameValidator;

	@Before
	public void setUp() {
		nameValidator = new NameValidator();
	}

	// 21,2, non-char at start, middle and end

	@Parameters
	private static final Object[] invalidName() {
		return $($("abcdefghijklmnopqrstu"), $("*abcdefgh8jklmnopqrst"), $("abcdefghijklmnopqrs1"), $("SV"));
	}

	// 3,4,19,20 chars
	@Parameters
	private static final Object[] validName() {
		return $($("abcdefghijklmnopqrst"), $("abcdefghijklmnopqrs"), $("abc"), $("abcd"));
	}

	@Test
	@Parameters(method = "invalidName")
	public void testInvalidName(String name) {
		assertFalse(nameValidator.checkName(name));
	}

	@Test
	@Parameters(method = "validName")
	public void testValidName(String name) {
		assertTrue(nameValidator.checkName(name));
	}

}
