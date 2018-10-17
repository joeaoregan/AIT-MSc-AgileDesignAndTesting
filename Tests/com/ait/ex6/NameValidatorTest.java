package com.ait.ex6;

import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import junitparams.*;
//import junitparams.JUnitParamsRunner;

import org.junit.Test;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.runner.RunWith;

//import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class NameValidatorTest {
	NameValidator nameValidator = new NameValidator();

	@Parameters
	private static final Object[] getValidNameLength() {
		return new Object[] { new Object[] { "NameOne" } };
	}

	@Parameters
	private static final Object[] getInvalidNameLength() {
		return new Object[] { new Object[] { "Na" }, new Object[] { "NameTwentyCharactersLong" } };
	}

	@Parameters
	private static final Object[] getInvalidCharacter() {
		return new Object[] { new Object[] { "joe1" }, new Object[] { "double-barrel" } };
	}
	
	@Test
	@Parameters(method = "getValidNameLength")
	public void testValidNameLength(String name) {
		assertTrue(nameValidator.checkName(name));
	}

	@Test
	@Parameters(method = "getInvalidNameLength")
	public void testInvalidNameLength(String name) {
		assertFalse(nameValidator.checkName(name));
	}
	
	@Test
	@Parameters(method = "getInvalidCharacter")
	public void testInvalidCharacter(String name) {
		assertFalse(nameValidator.checkName(name));
	}
}
