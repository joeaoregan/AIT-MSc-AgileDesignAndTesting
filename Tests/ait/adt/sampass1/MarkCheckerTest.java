package ait.adt.sampass1;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import com.ait.ex7.investment.InvestmentValue;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
class MarkCheckerTest {

//	private final int[] VALID_MARKS= {17,17,17,17,17};
	
	InvestmentValue iv = new InvestmentValue();

	MarkChecker markChecker = new MarkChecker();
	
	@Parameters
	private static final Object[] getValidMarks(){
		return $(
				$(new int[] {14,15,16,17,18}, new int[] {14,15,16,17,18}),       
				$(new int[] {15,16,17,18,19}, new int[] {15,16,17,18,19}),        
				$(new int[] {16,17,18,19,20}, new int[] {16,17,18,19,20})
		);
	}
	
	@Test
	@Parameters(method="getValidMarks")
	public void testValidMarks(int[] markerOne, int[] markerTwo) {	
		//assertEquals(1, markChecker.checkMarks(new int[] {1,1,1,1,1}, new int[] {9,9,9,9,9}));	
		assertEquals(0, markChecker.checkMarks(markerOne,markerTwo));
	}	

}



//MarkChecker markChecker = new MarkChecker();
//assertEquals(1, markChecker.checkMarks(new int[] {1,1,1,1,1}, new int[] {9,9,9,9,9}));
//System.out.println(markChecker.checkMarks(markerOne, markerTwo));

//public void testMarks() {
//	MarkChecker markChecker = new MarkChecker();
//	System.out.println(markChecker.checkMarks(VALID_MARKS, VALID_MARKS));
//	assertEquals(0, markChecker.checkMarks(VALID_MARKS, VALID_MARKS));
//}

//@Parameters
//private static final Object[] getValidMarks() {
//	return new Integer[][] {{17,17,17,17,17},{17,17,17,17,17}};
//}