/*
 * Joe O'Regan
 * A00258304
 * 15/10/2018
 * Sample Assessment 2 Part 1
 */
package ait.adt.sampass2;

import static org.junit.Assert.*;
import org.junit.Test;
import static junitparams.JUnitParamsRunner.$;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class MarkCheckerTest {

//	private final int[] VALID_MARKS= {17,17,17,17,17};

	MarkChecker markChecker = new MarkChecker();

	@Parameters
	private static final Object[] getValidMarks() {
		return $($(new int[] { 14, 15, 16, 17, 18 }, new int[] { 14, 15, 16, 17, 18 }, 0),
				$(new int[] { 15, 16, 17, 18, 19 }, new int[] { 15, 16, 17, 18, 19 }, 0),
				$(new int[] { 16, 17, 18, 19, 20 }, new int[] { 16, 17, 18, 19, 20 }, 0));
	}

	@Parameters
	private static final Object[] getInvalidArraySize() {
		return $($(new int[] { 14, 15, 16, 17 }, new int[] { 14, 15, 16, 17, 18 }),
				$(new int[] { 14, 15, 16, 17, 18 }, new int[] { 14, 15, 16, 17 }),

				$(new int[] { 16, 17, 18, 19, 20, 16 }, new int[] { 16, 17, 18, 19, 20 }),
				$(new int[] { 16, 17, 18, 19, 20 }, new int[] { 15, 16, 17, 18, 19, 20 })

//				$(new int[] {15,16,17}, new int[] {15,16,17}),  
//				$(new int[] {15,16,17,18,19,20}, new int[] {15,16,17,18,19,20}),   
//				
//				$(new int[] {16,17,18,19,20,16}, new int[] {16,17,18}),
//				$(new int[] {16,17,18}, new int[] {15,16,17,18,19,20})
		);
	}

	@Parameters
	private static final Object[] getInvalidMarks() {
		return $($(new int[] { 14, 15, 16, -1, 18 }, new int[] { 14, 15, 16, 17, 18 }),
				$(new int[] { 15, 16, 17, 18, 19 }, new int[] { 15, 16, -1, 18, 19 }),
				$(new int[] { 16, 17, 18, 99, 20 }, new int[] { 16, 17, 18, 19, 20 }),
				$(new int[] { 15, 16, 17, 18, 19 }, new int[] { 15, 16, 17, 18, 99 }));
	}

	@Parameters
	private static final Object[] getInvalidMarkDifference() {
		return $($(new int[] { 14, 15, 16, 17, 18 }, new int[] { 18, 15, 16, 17, 18 }),
				$(new int[] { 15, 16, 17, 18, 19 }, new int[] { 15, 16, 12, 18, 19 }));
	}

	@Parameters
	private static final Object[] getInvalidTotalsDifference() {
		return $($(new int[] { 14, 15, 16, 16, 17 }, new int[] { 16, 17, 18, 19, 20 }),
				$(new int[] { 20, 19, 20, 19, 20 }, new int[] { 17, 17, 18, 17, 18 }),
				$(new int[] { 20, 20, 20, 1, 2 }, new int[] { 17, 17, 17, 4, 4 }));
	}

	@Test
	@Parameters(method = "getValidMarks")
	public void testValidMarks(int[] markerOne, int[] markerTwo, int result) {
		// assertEquals(1, markChecker.checkMarks(new int[] {1,1,1,1,1}, new int[]
		// {9,9,9,9,9}));
		assertEquals(result, markChecker.checkMarks(markerOne, markerTwo));
	}

	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidArraySize")
	public void testThrowIAEForInvalidArraySize(int[] markerOne, int[] markerTwo) {
		markChecker.checkMarks(markerOne, markerTwo); // should be red
	}

	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidMarks")
	public void testThrowIAEForInvalidMarkValue(int[] markerOne, int[] markerTwo) {
		markChecker.checkMarks(markerOne, markerTwo); // should be red
	}

	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidMarkDifference")
	public void testThrowIAEForInvalidMarkDifference(int[] markerOne, int[] markerTwo) {
		markChecker.checkMarks(markerOne, markerTwo); // should be red
	}

	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidTotalsDifference")
	public void testThrowIAEForInvalidTotalsDifference(int[] markerOne, int[] markerTwo) {
		markChecker.checkMarks(markerOne, markerTwo); // should be red
	}
}