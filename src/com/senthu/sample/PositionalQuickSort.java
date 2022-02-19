package com.senthu.sample;

public class PositionalQuickSort {

	public static final Boolean ODD_POSITION_SORT = false;

	public static void main(String[] args) {
		int[] arrayElements = Utility.generateRandomIntArray(10, 20, 10, 99);
		int arraySize = arrayElements.length;
		System.out.println("Before Quick Sort");
		Utility.printArrayElements(arrayElements);

		int start = PositionalQuickSort.ODD_POSITION_SORT ? 0 : 1;
		int end = arraySize - 1;
		if (PositionalQuickSort.ODD_POSITION_SORT) {
			if ((arraySize % 2) == 0) {
				end--;
			}
		} else if ((arraySize % 2) != 0) {
			end--;
		}
		PositionalQuickSort.quickSort(arrayElements, start, end);
		System.out.println("\nAfter Quick Sort");
		Utility.printArrayElements(arrayElements);
	}

	public static void quickSort(int[] arrayElements, int startOfArray, int endOfArray) {

		int step = 2;
		int leftIndex = startOfArray;
		int rightIndex = endOfArray;
		int middlePosition = ((((endOfArray / step) - (startOfArray / step)) / 2) * step) + startOfArray;
		System.out.println("Start : " + startOfArray + ", End : " + endOfArray + ", Middle :" + middlePosition);
		int middleElement = arrayElements[middlePosition];
		do {
			while (arrayElements[leftIndex] < middleElement) {
				leftIndex += step;
			}
			while (arrayElements[rightIndex] > middleElement) {
				rightIndex -= step;
			}
			if (leftIndex <= rightIndex) {
				Utility.swap(arrayElements, leftIndex, rightIndex);
				leftIndex += step;
				rightIndex -= step;
			}
		} while (leftIndex <= rightIndex);
		if (startOfArray < rightIndex) {
			PositionalQuickSort.quickSort(arrayElements, startOfArray, rightIndex);
		}
		if (leftIndex < endOfArray) {
			PositionalQuickSort.quickSort(arrayElements, leftIndex, endOfArray);
		}
	}
}
