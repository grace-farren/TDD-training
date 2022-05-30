// ***************************************************************************
// Copyright (c) 2022, Industrial Logic, Inc., All Rights Reserved.
//
// This code is the exclusive property of Industrial Logic, Inc. It may ONLY be
// used by students during Industrial Logic's workshops or by individuals
// who are being coached by Industrial Logic on a project.
//
// This code may NOT be copied or used for any other purpose without the prior
// written consent of Industrial Logic, Inc.
// ****************************************************************************

package com.industriallogic.email.utils;

/**
 * TODO: Add something here.
 */
public class StringUtils {
	/**
	 * Strip out any special characters from the word.
	 * 
	 * @param word
	 * @return
	 */
	public static String removeSpecialCharactersIfAny(final String word, final char[] allowedChars) {
		int index = 0;
		int size = word.length();
		String chars = String.valueOf(allowedChars);
		StringBuffer filteredWord = new StringBuffer();
		if (word.startsWith("-"))
			index++;
		if (word.endsWith("-"))
			size--;
		while (index < size) {
			String letter = String.valueOf(word.charAt(index++));
			if (isAlphanumeric(letter) || chars.contains(letter))
				filteredWord.append(letter);
		}
		return filteredWord.toString();
	}

	/**
	 * Checks if the String contains only unicode letters or digits. <code>null</code> will return <code>false</code>. An empty
	 * String ("") will return <code>true</code>.
	 * 
	 * @param str
	 *            the String to check, may be null
	 * @return <code>true</code> if only contains letters or digits, and is non-null
	 */
	public static boolean isAlphanumeric(String str) {
		if (str == null)
			return false;
		int sz = str.length();
		for (int i = 0; i < sz; i++)
			if (Character.isLetterOrDigit(str.charAt(i)) == false)
				return false;
		return true;
	}

	/**
	 * Strips out one character from the end.
	 * 
	 * @param value
	 *            - String
	 */
	public static String trimLastCharacter(String value) {
		return value.substring(0, value.length() - 1);
	}
}
