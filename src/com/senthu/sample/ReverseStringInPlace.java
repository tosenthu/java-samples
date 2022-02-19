package com.senthu.sample;

public class ReverseStringInPlace {

	public static void main(String[] args) {
		String bigString = "  411 F Block Amrutha Value Apartments   Borewell Road Nallurhalli  ";
		String smallString = "  Senthil   Kumar   M   R    ";
		System.out.println(reverseStringInPlace(bigString));
		System.out.println(reverseStringInPlace(smallString));
		System.out.println(reverseEachStringInPlace(bigString));
		System.out.println(reverseEachStringInPlace(smallString));
	}

	private static String reverseEachStringInPlace(String sentence) {

		int lastSpaceIndex = 0;
		int currentSpaceIndex = -1;
		int length = sentence.length();

		for (int i = 0; i < length; i++) {
			if (sentence.charAt(i) == ' ') {
				lastSpaceIndex = currentSpaceIndex + 1;
				currentSpaceIndex = i;
				char[] characterArray = sentence.toCharArray();
				reverseInPlace(characterArray, lastSpaceIndex, currentSpaceIndex);
				sentence = new String(characterArray);
			}
		}
		lastSpaceIndex = currentSpaceIndex + 1;
		currentSpaceIndex = sentence.length();
		char[] characterArray = sentence.toCharArray();
		reverseInPlace(characterArray, lastSpaceIndex, currentSpaceIndex);
		return new String(characterArray);
	}

	private static void reverseInPlace(char[] characterArray, int startIndex, int endIndex) {

		int mid = (endIndex - startIndex) / 2;
		endIndex--;
		for (int i = 0; i < mid; i++) {
			char temp = characterArray[endIndex];
			characterArray[endIndex] = characterArray[startIndex];
			endIndex--;
			characterArray[startIndex] = temp;
			startIndex++;
		}
	}

	private static String reverseStringInPlace(String s) {
		char[] characterArray = s.toCharArray();

		reverseInPlace(characterArray, 0, characterArray.length);
		return new String(characterArray);
	}
}
