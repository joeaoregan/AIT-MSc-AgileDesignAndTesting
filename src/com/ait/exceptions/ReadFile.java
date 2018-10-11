/*
 * Intro to Exceptions S5
 * 11/10/2018
 */

package com.ait.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ReadFile {
	/*
	 * public static String readFirstLine(String path) { RandomAccessFile in = null;
	 * in = new RandomAccessFile(path, "r"); // may throw FileNotFound String line =
	 * in.readLine();// may throw IOException in.close();// may throw IOException
	 * return line; }
	 */

	public static String readFirstLine(String path) {
		RandomAccessFile in = null;
		try {
			in = new RandomAccessFile(path, "r");
			// may throw FileNotFound
			String line = in.readLine();// may throw IOException
			in.close();// may throw IOException
			return line;
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return null;
		} catch (IOException e) {
			System.out.println("I/O error occurred.");
			return null;
		} finally {
			try {
				if (in != null) {
					in.close(); // may throw IOException
				}
			} catch (Exception e) {
				System.out.println("Unable to close file.");
			}
		}
	}
}
