/*
 * Joe O'Regan
 * A00258304
 * 15/10/2018
 * Sample Assessment 2 Part 1
 */
package ait.adt.sampass1;

import static org.junit.Assert.*;
import org.junit.Test;
import static junitparams.JUnitParamsRunner.$;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class OrderTest {
	
	Order order = new Order();
	
	@Parameters
	private static final Object[] getValidQuantities(){
		return $(
				$(6, 60.0),       
				$(7, 70.0),   
				$(8, 80.0),
				$(200, 1800.0),
				$(300, 2700.0),
				$(400, 3600.0)
		);
	}

	@Parameters
	private static final Object[] getInvalidQuantitiesMin(){
		return $(
				$(1),       
				$(2),
				$(3)
		);
	}
	
	@Parameters
	private static final Object[] getInvalidQuantitiesMax(){
		return $(
				$(501),       
				$(600),
				$(1000)
		);
	}
	
	@Test
	@Parameters(method="getValidQuantities")
	public void testValidOrderQuantity(int quantity, double total) {
		assertEquals(total, order.calculateOrderTotal(quantity),0.01);
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidQuantitiesMin")
	public void testThrowIAEForInvalidOrderQuantityMin(int quantity) {
		order.calculateOrderTotal(quantity);	// should be red
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidQuantitiesMax")
	public void testThrowIAEForInvalidOrderQuantityMax(int quantity) {
		order.calculateOrderTotal(quantity);	// should be red
	}
	
}
