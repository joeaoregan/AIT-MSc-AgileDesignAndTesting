/*
 * A00258304
 */
package com.ait.delivery;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.*;
import static junitparams.JUnitParamsRunner.$;

@RunWith(JUnitParamsRunner.class)
public class DeliveryChargeTest {
	private DeliveryCharge dc;
	
	@Before
	public void setUp() {
		dc = new DeliveryCharge();
	}

	@Parameters
	private static final Object[] getValidOrderAmount() {
		return $($(50.0, 8.99), $(150, 3.99), $(1000.0, 0.0));
	}

	@Parameters
	private static final Object[] getInvalidOrderAmount() {
		return $($(0.0), $(10001.0));
	}

	@Test
	@Parameters(method = "getValidOrderAmount")
	public void testValidOrderAmount(double orderAmount, double deliveryCharge) {
		assertEquals(deliveryCharge, dc.calculateCharge(orderAmount), 0.01);
	}

	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidOrderAmount")
	public void testInvalidOrderAmount(double orderAmount) {
		dc.calculateCharge(orderAmount);
	}
}
