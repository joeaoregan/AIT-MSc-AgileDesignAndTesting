package com.ait.ex6_solution;

//Check that name length is between 3 and 20 chars
//Check that name only contains characters

public class NameValidator {
	public boolean checkName(String name) {
		boolean result=true;
		if (name.length()<3||name.length()>20) {
			result=false;
		}
		for(int i=0;i<name.length();i++) {
			char ch=name.charAt(i);
			if(!Character.isLetter(ch)) {
				result=false;
				break;
			}
		}
		return result;
	}

}
