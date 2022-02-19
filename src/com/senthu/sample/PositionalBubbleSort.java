package com.senthu.sample;

public class PositionalBubbleSort {

	private static final Boolean ODD_POSITION_SORT = false;

	private static void bubbleSort(boolean odd, int[] arrayElements) {
		for (int i = odd ? 0 : 1; i < (arrayElements.length - 1); i += 2) {
			for (int j = i + 2; j < arrayElements.length; j += 2) {
				if (arrayElements[i] > arrayElements[j]) {
					Utility.swap(arrayElements, i, j);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] arrayElements = Utility.generateRandomIntegerArray(15, 20, 10, 99);
		System.out.println("Before Bubble Sort");
		Utility.printArrayElements(arrayElements);
		bubbleSort(ODD_POSITION_SORT, arrayElements);
		System.out.println("After Bubble Sort");
		Utility.printArrayElements(arrayElements);
	}
}
