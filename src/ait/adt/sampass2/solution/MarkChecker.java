package ait.adt.sampass2.solution;
//package com.ait.marks;

public class MarkChecker {

	public int checkMarks(int[] markerOne, int[] markerTwo) {
		checkRanges(markerOne);
		checkRanges(markerTwo);
		if (checkDiffGreaterThanThree(markerOne, markerTwo)) {
			return 1;
		} else if (checkTotalDiffGreaterThanTen(markerOne, markerTwo)) {
			return 2;
		}
		return 0;
	}

	private void checkRanges(int[] marks) {
		if ((marks.length) == 5) {
			for (int i = 0; i < 5; i++) {
				if ((marks[i] < 0) || (marks[i] > 20)) {
					throw new IllegalArgumentException("mark out of range ["
							+ marks[i] + "]");
				}
			}
		} else {
			throw new IllegalArgumentException(
					"Should have five marks per script");
		}
	}

	private boolean checkDiffGreaterThanThree(int[] scriptOne, int[] scriptTwo) {
		for (int i = 0; i < 5; i++) {
			if (Math.abs((scriptOne[i] - scriptTwo[i])) > 3) {
				return true;
			}
		}
		return false;
	}

	private boolean checkTotalDiffGreaterThanTen(int[] scriptOne,
			int[] scriptTwo) {
		int sumMarkerOne = 0;
		int sumMarkerTwo = 0;
		for (int i = 0; i < 5; i++) {
			sumMarkerOne += scriptOne[i];
		}
		for (int i = 0; i < 5; i++) {
			sumMarkerTwo += scriptTwo[i];
		}
		if (Math.abs(sumMarkerOne - sumMarkerTwo) > 10) {
			return true;
		} else
			return false;
	}

}
