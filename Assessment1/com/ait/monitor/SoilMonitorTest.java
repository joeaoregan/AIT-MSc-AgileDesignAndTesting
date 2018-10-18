/*
 * A00258304
 */
package com.ait.monitor;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.*;
import static junitparams.JUnitParamsRunner.$;

@RunWith(JUnitParamsRunner.class)
public class SoilMonitorTest {

	private SoilMonitor sm;

	@Before
	public void setup() {
		sm = new SoilMonitor();
	}

	@Parameters
	private static final Object[] getInvalidMoistureContentArraySize() {
		return $($(new int[] { 1, 2, 3 }), $(new int[] { 1, 2, 3, 4, 5 }));
	}

	@Parameters
	private static final Object[] getInvalidMoistureValues() {
		return $($(new int[] { -1, 2, 3, 4 }), $(new int[] { 200, 2, 3, 4 }));
	}

	@Parameters
	private static final Object[] getValidSprinklerSetting() {
		return $($(new int[] { 1, 2, 3, 4 }, 2), $(new int[] { 75, 75, 75, 75 }, 1),
				$(new int[] { 125, 125, 125, 125 }, 0));
	}

	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidMoistureContentArraySize")
	public void testInvalidMoistureContentArraySize(int[] moistureContent) {
		sm.moistureLevelCheck(moistureContent);
	}

	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidMoistureValues")
	public void testInvalidMoistureValues(int[] moistureContent) {
		sm.moistureLevelCheck(moistureContent);
	}

	@Test
	@Parameters(method = "getValidSprinklerSetting")
	public void testValidSprinklerSetting(int[] moistureContent, int sprinklerSetting) {
		assertEquals(sprinklerSetting, sm.moistureLevelCheck(moistureContent));
	}
}
