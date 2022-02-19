package com.senthu.sample;

import java.util.Arrays;
import java.util.Collections;

public class MergeTwoSortedArray {

	private static Integer[] copyArrays(Integer[] firstArray, Integer[] secondArray) {
		Integer[] arrayElements = new Integer[firstArray.length + secondArray.length];
		int index = 0;
		for (Integer element : firstArray) {
			arrayElements[index++] = element;
		}
		for (Integer element : secondArray) {
			arrayElements[index++] = element;
		}
		return arrayElements;
	}

	public static void main(String[] args) {
		Integer[] firstHalfArray = Utility.generateRandomIntegerArray(5, 10, 10, 99);
		Integer[] secondHalfArray = Utility.generateRandomIntegerArray(5, 10, 10, 99);

		Arrays.sort(firstHalfArray, Collections.reverseOrder());
		Arrays.sort(secondHalfArray);

		Utility.printArrayElements("First Half", firstHalfArray);
		Utility.printArrayElements("Second Half", secondHalfArray);

		Integer[] arrayElements = MergeTwoSortedArray.copyArrays(firstHalfArray, secondHalfArray);

		Utility.printArrayElements("Before Sorting", arrayElements);
		int middleElement = firstHalfArray.length;
		int leftIndex = middleElement - 1;
		int rightIndex = middleElement;

		Integer[] result = new Integer[arrayElements.length];
		int resultIndex = 0;
		while ((leftIndex >= 0) && (rightIndex < arrayElements.length)) {
			if (arrayElements[rightIndex] < arrayElements[leftIndex]) {
				result[resultIndex] = arrayElements[rightIndex++];
			} else {
				result[resultIndex] = arrayElements[leftIndex--];

			}
			resultIndex++;
		}

		while (leftIndex >= 0) {
			result[resultIndex++] = arrayElements[leftIndex--];
		}

		while (rightIndex < arrayElements.length) {
			result[resultIndex++] = arrayElements[rightIndex++];
		}

		Utility.printArrayElements("After Sorting", result);
	}
}
