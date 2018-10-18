package ait.adt.sampass2.solution;
//package com.ait.marks;

import static org.junit.Assert.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
//import static junitparams.JUnitParamsRunner.$;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
//import junitparams.*;

@RunWith(JUnitParamsRunner.class)
public class MarkCheckerTest {
	private MarkChecker markChecker;
	
	@Before
	public void setUp(){
		markChecker = new MarkChecker();
	}
	
	//Testing 0,1,4,6
	@Parameters
	private Object[] getInvalidNumMarks() {
		Object[] objects = new Object[4];
		objects[0] = new Object[] { new int[] { } };
		objects[1] = new Object[] { new int[] { 6 } };
		objects[2] = new Object[] { new int[] { 13, 14, 14,12 } };
		objects[3] = new Object[] { new int[] { 13, 14, 14,12,15,16 } };
		return objects;
	}
	
	//Testing -1,21
	@Parameters
	private Object[] getMarksOutOfRange() {
		Object[] objects = new Object[2];
		objects[0] = new Object[] { new int[] {-1,15,15,15,15 },new int[] {15,15,14,15,15 } };
		objects[1] = new Object[] { new int[] {15,15,15,15,15 },new int[] {15,15,21,15,15 } };
		return objects;
	}
	
	//Testing 4,5 in individual question
	@Parameters
	private Object[] getDiffGreaterThanThree() {
		Object[] objects = new Object[2];
		objects[0] = new Object[] { new int[] {15,15,15,15,15 },new int[] {15,15,15,15,11 } };
		objects[1] = new Object[] { new int[] {15,15,15,15,15 },new int[] {10,15,15,15,15 } };
		return objects;
	}
	
	//Testing 11,12 in diff of script total
	@Parameters
	private Object[] getMarksTotalGreaterThanTen() {
		Object[] objects = new Object[2];
		objects[0] = new Object[] { new int[] {12,12,12,12,12 },new int[] {14,14,14,14,15 } };
		objects[1] = new Object[] { new int[] {15,15,15,15,15 },new int[] {13,13,13,12,12 } };
		return objects;
	}
	
	//Testing total diffs of 0,1,9,10
	//Testing diff 0,1,2,3
	@Parameters
	private Object[] getValidMarks() {
		Object[] objects = new Object[5];
		//total diff =0, individual diff=0
		objects[0] = new Object[] { new int[] {15,15,15,15,15 },new int[] {15,15,15,15,15 } };
		//total diff=1, ind. q diff=1
		objects[1] = new Object[] { new int[] {14,15,15,15,15 },new int[] {15,15,15,15,15 } };
		//total diff=9, individual q diff=3
		objects[2] = new Object[] { new int[] {15,15,15,14,14 },new int[] {12,12,12,14,14 } };
		//total diff=10, individual q diff=3 and 1
		objects[3] = new Object[] { new int[] {15,15,15,14,14 },new int[] {12,12,12,13,14 } };
		//individual q diff=2
		objects[4] = new Object[] { new int[] {15,15,15,14,14 },new int[] {15,15,15,12,14 } };
		return objects;
	}

	@Test(expected=IllegalArgumentException.class)
	@Parameters(method="getInvalidNumMarks")
	public void testIllegalNumberMarks(int[] marks) {
		markChecker.checkMarks(marks, marks);
	}
	
	@Test(expected=IllegalArgumentException.class)
	@Parameters(method="getMarksOutOfRange")
	public void testMarksOutOfRange(int[] marksOne,int[] marksTwo) {
		markChecker.checkMarks(marksOne, marksTwo);
	}
	
	@Test
	@Parameters(method="getDiffGreaterThanThree")
	public void testMarksDiffGreaterThanThree(int[] marksOne,int[] marksTwo) {
		int result=markChecker.checkMarks(marksOne, marksTwo);
		assertEquals(1,result);
	}
	
	@Test
	@Parameters(method="getMarksTotalGreaterThanTen")
	public void testMarksDiffGreaterThanTen(int[] marksOne,int[] marksTwo) {
		int result=markChecker.checkMarks(marksOne, marksTwo);
		assertEquals(2,result);
	}
	
	@Test
	@Parameters(method="getValidMarks")
	public void testValidMarks(int[] marksOne,int[] marksTwo) {
		int result=markChecker.checkMarks(marksOne, marksTwo);
		assertEquals(0,result);
	}

}
