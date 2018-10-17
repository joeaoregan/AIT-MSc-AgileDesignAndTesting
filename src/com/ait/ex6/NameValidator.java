/*
 * Joe O'Regan
 * A00258304
 * 
 */
package com.ait.ex6;

public class NameValidator {
	public boolean checkName(String name) {
		if (name.length() < 3 || name.length() > 20) {
			return false;
		}
		
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			if (!Character.isLetter(ch)) {
				return false;
			}
		}
		
		return true;
	}
}
