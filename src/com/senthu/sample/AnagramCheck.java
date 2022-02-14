package com.senthu.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class AnagramCheck {

	private static List<String> generateRandomString() {

		List<List<Character>> preparedListOfCharacterSet = new ArrayList<>();
		for (int count = 0; count < new Random().nextInt(10, 15); count++) {
			List<Character> finalString = new ArrayList<>();
			for (int element : new Random().ints(new Random().nextInt(3, 9), 97, 122).toArray()) {
				finalString.add((char) element);
			}
			preparedListOfCharacterSet.add(finalString);
		}

		Set<String> returnValue = new HashSet<String>();
		for (List<Character> characterSetList : preparedListOfCharacterSet) {
			int randomInt = new Random().nextInt(1, preparedListOfCharacterSet.size());
			returnValue.add(prepareStringFromCharacterArray(characterSetList));
			if ((randomInt % 5) == 0) {
				randomizeString(characterSetList, returnValue, new Random().nextInt(2, 10));
			} else if ((randomInt % 4) == 0) {
				randomizeString(characterSetList, returnValue, new Random().nextInt(2, 8));
			} else if ((randomInt % 3) == 0) {
				randomizeString(characterSetList, returnValue, new Random().nextInt(2, 6));
			}
		}
		return new ArrayList<String>(returnValue);
	}

	private static void getAnagramGroupCount(List<String> stringList) {
		System.out.println(stringList);
		Map<String, List<String>> characterSetStrings = new HashMap<>();
		for (String element : stringList) {
			String characterSetString = prepareCharacterSet(element);
			List<String> groupList = characterSetStrings.getOrDefault(characterSetString, new ArrayList<String>());
			groupList.add(element);
			characterSetStrings.put(characterSetString, groupList);
		}
		for (List<String> groupList : characterSetStrings.values()) {
			System.out.println(groupList);
		}
		System.out.println("Total String : " + stringList.size() + ", Total Groups : " + characterSetStrings.size());
	}

	public static void main(String[] args) {
		getAnagramGroupCount(generateRandomString());
	}

	private static String prepareCharacterSet(String element) {

		char[] characterArray = element.toLowerCase().toCharArray();
		TreeMap<Character, Integer> characterHashMap = new TreeMap<>();
		for (char eachCharacter : characterArray) {
			characterHashMap.put(eachCharacter, characterHashMap.getOrDefault(eachCharacter, 0) + 1);
		}
		StringBuilder sb = new StringBuilder();
		for (char key : characterHashMap.keySet()) {
			sb.append(characterHashMap.get(key)).append(key);
		}
		return sb.toString();
	}

	private static String prepareStringFromCharacterArray(List<Character> listOfCharacters) {
		StringBuilder stringBuilder = new StringBuilder();
		Character[] characterArray = {};
		characterArray = listOfCharacters.toArray(characterArray);
		for (Character character : characterArray) {
			stringBuilder.append(character.charValue());
		}
		return stringBuilder.toString();
	}

	private static void randomizeString(List<Character> listOfCharacters, Set<String> returnValue, int randomLimit) {
		int randomInt = new Random().nextInt(1, randomLimit);
		for (int index = 0; index < randomInt; index++) {
			Collections.shuffle(listOfCharacters);
			returnValue.add(prepareStringFromCharacterArray(listOfCharacters));
		}
	}
}
