/*
 * A00258304
 */
package com.ait.monitor;

public class SoilMonitor {
	final static int MIN_MOISTURE_CONTENT = 0;
	final static int MAX_MOISTURE_CONTENT = 150;
	final static int ARRAY_SIZE = 4;
	
	public int moistureLevelCheck(int[] moistureContent) {
		int sprinklerSetting = 0; // illegalArgurmentExceptions make this the default

		if (moistureContent.length != ARRAY_SIZE) {
			throw new IllegalArgumentException("System Faulty");
		}

		int total = 0;

		for (int i = 0; i < moistureContent.length; i++) {
			if (moistureContent[i] < MIN_MOISTURE_CONTENT || moistureContent[i] > MAX_MOISTURE_CONTENT) {
				throw new IllegalArgumentException("System Faulty");
			}			

			total += moistureContent[i];
		}

		int averageMoistureContent = total / moistureContent.length;

		if (averageMoistureContent >= 0 && averageMoistureContent <= 50) {
			sprinklerSetting = 2;
		} else if (averageMoistureContent >= 51 && averageMoistureContent <= 100) {
			sprinklerSetting = 1;
		} 

		return sprinklerSetting;
	}
}