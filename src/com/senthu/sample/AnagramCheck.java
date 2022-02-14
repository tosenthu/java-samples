package com.senthu.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class AnagramCheck {

	private static String prepareCharacterSet(String element) {

		char[] characterArray = element.toCharArray();
		TreeMap<Character, Integer> characterHashMap = new TreeMap<Character, Integer>();
		for (char eachCharacter : characterArray) {
			Integer count = characterHashMap.getOrDefault(eachCharacter, 0);
			characterHashMap.put(eachCharacter, ++count);
		}
		StringBuilder sb = new StringBuilder();
		for (char key : characterHashMap.keySet()) {
			sb.append(characterHashMap.get(key)).append(key);
		}
		return sb.toString();
	}

	private static int getAnagramGroupCount(List<String> stringList) {
		Set<String> characterSetStrings = new HashSet<String>();
		for (String element : stringList) {
			characterSetStrings.add(prepareCharacterSet(element));
		}
		return characterSetStrings.size();
	}

	public static void main(String[] args) {
		String[] listOfString = {"cat", "tab", "tac", "same", "ames", "aims", "sima", "senthil", "thilsen", "kumar"};
		System.out.println(getAnagramGroupCount(Arrays.asList(listOfString)));
	}
}
