/*
 * Joe O'Regan
 * A00258304
 * 15/10/2018
 * Sample Assessment 2 Part 1
 */
package ait.adt.sampass2;

public class MarkChecker {
	private final static int FLAG_OK=0;
	private final static int FLAG_QUESTION_SCORE_DIFFERENCE=1;
	private final static int FLAG_TOTAL_SCORE_DIFFERENCE=2;
	
	public int checkMarks(int[] markerOne, int[] markerTwo) {
		// Check Mark Array Sizes
//		System.out.println("checkMarks()");
		int totalScore1 = 0, totalScore2 = 0;
		
//		if (markerOne.length != 5 || markerTwo.length != 5) {
//			throw new IllegalArgumentException(
//				"illegal array length, array must contain 5 values");
//		}

		if (markerOne.length != 5) {
			throw new IllegalArgumentException(
				"illegal array length, 1st array must contain 5 values");
		} else if (markerTwo.length != 5) {
			throw new IllegalArgumentException(
				"illegal array length, 2nd array must contain 5 values");
		}
		
		try {
		//int markCheck = 0;
		for (int i = 0; i < markerOne.length; i++) {
			// Check input
			if (markerOne[i] < 0) {
				throw new IllegalArgumentException(
						"illegal mark: [" + markerOne[i] + "], at array position: [" + i + "], min value: 0");
			} else if (markerOne[i] > 20) {
				throw new IllegalArgumentException(
						"illegal mark: [" + markerOne[i] + "], at array position: [" + i + "], max value: 20");
			}
			
			if (markerTwo[i] < 0) {
				throw new IllegalArgumentException(
						"illegal mark: [" + markerTwo[i] + "], at array position: [" + i + "], min value: 0");
			}else if (markerTwo[i] > 20) {
				throw new IllegalArgumentException(
						"illegal mark: [" + markerTwo[i] + "], at array position: [" + i + "], max value: 20");
			}
			
			// Check Score Difference
			if (Math.abs(markerOne[i] - markerTwo[i]) > 3) {
				//markCheck = 1;
				return FLAG_QUESTION_SCORE_DIFFERENCE;
			}

			// Increment Totals
			totalScore1 += markerOne[i];
			totalScore2 += markerTwo[i];
		}

		// Check Total Differences
		if (Math.abs(totalScore1 - totalScore2) > 10) {
			//markCheck= 2;
			return FLAG_TOTAL_SCORE_DIFFERENCE;
		}
		
		} catch(Exception e) {
			System.out.println("Exception");
		}
		
		return FLAG_OK;
	}
}
