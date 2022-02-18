package com.senthu.sample;

import java.util.Random;

public class PositionalBubbleSort {

	private static void bubbleSort(boolean odd, int arraySize, int[] arrayElements) {
		for (int i = odd ? 0 : 1; i < (arraySize - 1); i += 2) {
			for (int j = i + 2; j < arraySize; j += 2) {
				if (arrayElements[i] > arrayElements[j]) {
					int temp = arrayElements[i];
					arrayElements[i] = arrayElements[j];
					arrayElements[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {

		boolean odd = false;
		int arraySize = new Random().nextInt(15, 20);
		int[] arrayElements = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			arrayElements[i] = new Random().nextInt(10, 99);
		}

		System.out.println("Before Bubble Sort");
		printArrayElements(arrayElements);
		bubbleSort(odd, arraySize, arrayElements);
		System.out.println("After Bubble Sort");
		printArrayElements(arrayElements);
	}

	public static void printArrayElements(int[] arrayElements) {
		for (int element : arrayElements) {
			System.out.print(element + " ");
		}
		System.out.println("\n");
	}
}
