package com.senthu.sample;

public class ReverseStringInPlace {

	public static void main(String[] args) {
		String[] inputStrings = { "The   Quick  Brown   Fox  Jumps   Over   THE  LaZy   dOg",
				"Eclipse IDE for Enterprise Java and Web Developers", "Senthil   Kumar   M   R" };

		for (String inputString : inputStrings) {
			System.out.println(ReverseStringInPlace.reverseAllCharacters(inputString));
			System.out.println(ReverseStringInPlace.reverseCharactersOfWords(inputString));
			System.out.println(ReverseStringInPlace.reverseWords(inputString));
		}
	}

	private static String reverseAllCharacters(String s) {
		char[] characterArray = s.toCharArray();
		ReverseStringInPlace.reverseInPlace(characterArray, 0, characterArray.length);
		return new String(characterArray);
	}

	private static String reverseCharactersOfWords(String sentence) {

		int lastSpaceIndex = 0;
		int currentSpaceIndex = -1;
		int length = sentence.length();

		for (int i = 0; i < length; i++) {
			if (sentence.charAt(i) == ' ') {
				lastSpaceIndex = currentSpaceIndex + 1;
				currentSpaceIndex = i;
				char[] characterArray = sentence.toCharArray();
				ReverseStringInPlace.reverseInPlace(characterArray, lastSpaceIndex, currentSpaceIndex);
				sentence = new String(characterArray);
			}
		}
		lastSpaceIndex = currentSpaceIndex + 1;
		currentSpaceIndex = sentence.length();
		char[] characterArray = sentence.toCharArray();
		ReverseStringInPlace.reverseInPlace(characterArray, lastSpaceIndex, currentSpaceIndex);
		return new String(characterArray);
	}

	private static void reverseInPlace(char[] characterArray, int startIndex, int endIndex) {

		int mid = (endIndex - startIndex) / 2;
		endIndex--;
		for (int i = 0; i < mid; i++) {
			char temp = characterArray[endIndex];
			characterArray[endIndex] = characterArray[startIndex];
			characterArray[startIndex] = temp;
			endIndex--;
			startIndex++;
		}
	}

	private static String reverseWords(String string) {
		char[] characterArray = string.toCharArray();
		ReverseStringInPlace.reverseInPlace(characterArray, 0, characterArray.length);
		String fullReversedString = new String(characterArray);
		return ReverseStringInPlace.reverseCharactersOfWords(fullReversedString);
	}
}
