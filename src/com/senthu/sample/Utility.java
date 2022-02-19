package com.senthu.sample;

import java.util.Random;

public class Utility {
	public static int[] generateRandomIntegerArray(int sizeStartValue, int sizeEndValue, int rangeStartValue, int rangeEndValue) {
		int arraySize = new Random().nextInt(sizeStartValue, sizeEndValue);
		int[] arrayElements = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			arrayElements[i] = new Random().nextInt(rangeStartValue, rangeEndValue);
		}
		return arrayElements;
	}

	public static void printArrayElements(int[] arrayElements) {
		Utility.printArrayElements(arrayElements, 0, arrayElements.length);
	}

	public static void printArrayElements(int[] arrayElements, int start, int end) {
		for (int index = start; index < end; index++) {
			System.out.print(arrayElements[index] + " ");
		}
		System.out.println("\n");
	}

	public static void swap(int[] arrayElements, int start, int end) {
		int temp = arrayElements[start];
		arrayElements[start] = arrayElements[end];
		arrayElements[end] = temp;
	}

}
