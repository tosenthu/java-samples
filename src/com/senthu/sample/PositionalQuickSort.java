package com.senthu.sample;

public class PositionalQuickSort {

	public static void main(String[] args) {
		int[] arrayElements = Utility.generateRandomIntegerArray(15, 20, 10, 99);
		int arraySize = arrayElements.length;
		System.out.println("Before Quick Sort");
		Utility.printArrayElements(arrayElements);
		quick(arrayElements, 0, arraySize - 1);
		System.out.println("After Quick Sort");
		Utility.printArrayElements(arrayElements);
	}

	public static int partition(int[] arrayElements, int start, int end) {
		int pivot = arrayElements[end];
		int i = start - 1;

		for (int j = start; j <= (end - 1); j++) {
			if (arrayElements[j] < pivot) {
				i++;
				Utility.swap(arrayElements, i, j);
				Utility.printArrayElements(arrayElements, start, end);
			}
		}
		i += 1;
		Utility.swap(arrayElements, i, end);
		Utility.printArrayElements(arrayElements, start, end);
		return i;
	}

	public static void quick(int[] arrayElements, int start, int end) {
		if (start < end) {
			int p = partition(arrayElements, start, end);
			quick(arrayElements, start, p - 1);
			quick(arrayElements, p + 1, end);
		}
	}

}
