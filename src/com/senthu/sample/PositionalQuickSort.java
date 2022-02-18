package com.senthu.sample;

import java.util.Random;

public class PositionalQuickSort {

	public static void main(String[] args) {
		int arraySize = new Random().nextInt(15, 20);
		int[] arrayElements = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			arrayElements[i] = new Random().nextInt(10, 99);
		}

		System.out.println("Before Quick Sort");
		printArrayElements(arrayElements);
		quick(arrayElements, 0, arraySize - 1);
		System.out.println("After Quick Sort");
		printArrayElements(arrayElements);
	}

	public static int partition(int[] arrayElements, int start, int end) {
		int pivot = arrayElements[end];
		int i = start - 1;

		for (int j = start; j <= (end - 1); j++) {
			if (arrayElements[j] < pivot) {
				i++;
				swap(arrayElements, i, j);
			}
		}
		swap(arrayElements, i + 1, end);
		return (i + 1);
	}

	public static void printArrayElements(int[] arrayElements) {
		for (int element : arrayElements) {
			System.out.print(element + " ");
		}
		System.out.println("\n");
	}

	public static void quick(int[] arrayElements, int start, int end) {
		if (start < end) {
			int p = partition(arrayElements, start, end);
			quick(arrayElements, start, p - 1);
			quick(arrayElements, p + 1, end);
		}
	}

	public static void swap(int[] arrayElements, int start, int end) {
		int temp = arrayElements[start];
		arrayElements[start] = arrayElements[end];
		arrayElements[end] = temp;
	}

}
