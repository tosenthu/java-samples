package com.senthu.sample;

public class PositionalQuickSort {

	public static final Boolean ODD_POSITION_SORT = true;

	public static void main(String[] args) {
		int[] arrayElements = Utility.generateRandomIntegerArray(15, 20, 10, 99);
		int arraySize = arrayElements.length;
		System.out.println("Before Quick Sort");
		Utility.printArrayElements(arrayElements);

		int start = ODD_POSITION_SORT ? 0 : 1;
		int end = arraySize - 1;
		if (ODD_POSITION_SORT) {
			if (arraySize % 2 == 0) {
				end--;
			}
		} else {
			if (arraySize % 2 != 0) {
				end--;
			}
		}
		quickSort(arrayElements, start, end);
		System.out.println("After Quick Sort");
		Utility.printArrayElements(arrayElements);
	}

	public static void quickSort(int[] arrayElements, int start, int end) {
		int step = 2;
		int leftIndex = start;
		int rightIndex = end;
		int mid = (((end - start) / 2) * step) + start;
		int midElement = arrayElements[mid];
		do {
			while (arrayElements[leftIndex] < midElement)
				leftIndex += step;
			while (arrayElements[rightIndex] > midElement)
				rightIndex -= step;
			if (leftIndex <= rightIndex) {
				Utility.swap(arrayElements, leftIndex, rightIndex);
				leftIndex += step;
				rightIndex -= step;
			}
		} while (leftIndex <= rightIndex);
		if (start < rightIndex)
			quickSort(arrayElements, start, rightIndex);
		if (leftIndex < end)
			quickSort(arrayElements, leftIndex, end);
	}
}
