package com.senthu.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DuplicateTest {

	public static void main(String[] args) {

		String[] originalArray = { "ab", "ab", "ababcd", "cf", "cd", "cdag", "cfe" };

		List<String> resultList = new ArrayList<>();

		// Remove duplicate Strings
		// Remove Strings which are substring of other strings

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
		System.out.println(resultList);
	}

}
