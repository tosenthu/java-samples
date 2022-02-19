package com.senthu.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

// Remove duplicate Strings
// Remove Strings which are substring of other strings
public class DuplicateTest {

	public static void main(String[] args) {

		List<String> preparedStringArray = new ArrayList<String>();
		for (int i = 0; i < new Random().nextInt(3, 20); i++) {
			preparedStringArray.add(Utility.prepareStringFromCharacterArray(Utility.generateString(2, 3)));
		}
		for (int i = 0; i < new Random().nextInt(3, 10); i++) {
			preparedStringArray.add(Utility.prepareStringFromCharacterArray(Utility.generateString(3, 5)));
		}
		
		for (int i = 0; i < new Random().nextInt(3, 20); i++) {
			preparedStringArray.add(Utility.prepareStringFromCharacterArray(Utility.generateString(5, 7)));
		}
		for (int i = 0; i < new Random().nextInt(3, 20); i++) {
			preparedStringArray.add(Utility.prepareStringFromCharacterArray(Utility.generateString(7, 10)));
		}

		String[] originalArray = {};
		originalArray = preparedStringArray.toArray(originalArray);
		List<String> resultList = new ArrayList<>();

		String[] sortedArray = originalArray.clone();
		Arrays.sort(sortedArray);
		for (int index = 0; index < sortedArray.length; index++) {
			if (!resultList.contains(sortedArray[index])) {
				boolean subStringFound = false;
				for (int jIndex = index + 1; jIndex < sortedArray.length; jIndex++) {
					if (sortedArray[jIndex].contains(sortedArray[index])) {
						subStringFound = true;
						break;
					}
				}
				if (!subStringFound) {
					resultList.add(sortedArray[index]);
				}
			}
		}
		Utility.printArrayElements("Original Array", originalArray);
		Utility.printArrayElements("Duplicate Removed Array", resultList.toArray());
		System.out.println("\nNo of Duplicates Removed : " + (originalArray.length - resultList.size()));
	}

}
