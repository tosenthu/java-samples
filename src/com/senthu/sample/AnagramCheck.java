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
			preparedListOfCharacterSet.add(Utility.generateString(3, 10));
		}

		Set<String> returnValue = new HashSet<>();
		for (List<Character> characterSetList : preparedListOfCharacterSet) {
			int randomInt = new Random().nextInt(1, preparedListOfCharacterSet.size());
			returnValue.add(Utility.prepareStringFromCharacterArray(characterSetList));
			if ((randomInt % 5) == 0) {
				AnagramCheck.randomizeString(characterSetList, returnValue, new Random().nextInt(2, 10));
			} else if ((randomInt % 4) == 0) {
				AnagramCheck.randomizeString(characterSetList, returnValue, new Random().nextInt(2, 8));
			} else if ((randomInt % 3) == 0) {
				AnagramCheck.randomizeString(characterSetList, returnValue, new Random().nextInt(2, 6));
			}
		}
		return new ArrayList<>(returnValue);
	}

	private static void getAnagramGroupCount(List<String> stringList) {
		Utility.printArrayElements("Original Array", stringList.toArray());
		Map<String, List<String>> characterSetStrings = new HashMap<>();
		for (String element : stringList) {
			String characterSetString = AnagramCheck.prepareCharacterSet(element);
			List<String> groupList = characterSetStrings.getOrDefault(characterSetString, new ArrayList<String>());
			groupList.add(element);
			characterSetStrings.put(characterSetString, groupList);
		}
		for (List<String> groupList : characterSetStrings.values()) {
			Utility.printArrayElements("Group ", groupList.toArray());
		}
		System.out.println("\nTotal String : " + stringList.size() + ", Total Groups : " + characterSetStrings.size());
	}

	public static void main(String[] args) {
		AnagramCheck.getAnagramGroupCount(AnagramCheck.generateRandomString());
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

	private static void randomizeString(List<Character> listOfCharacters, Set<String> returnValue, int randomLimit) {
		int randomInt = new Random().nextInt(1, randomLimit);
		for (int index = 0; index < randomInt; index++) {
			Collections.shuffle(listOfCharacters);
			returnValue.add(Utility.prepareStringFromCharacterArray(listOfCharacters));
		}
	}
}
