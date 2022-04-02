package com.senthu.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Utility {
	public static int[] generateRandomIntArray(int sizeStartValue, int sizeEndValue, int rangeStartValue,
			int rangeEndValue) {
		int arraySize = new Random().nextInt(sizeStartValue, sizeEndValue);
		int[] arrayElements = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			arrayElements[i] = new Random().nextInt(rangeStartValue, rangeEndValue);
		}
		return arrayElements;
	}

	public static Integer[] generateRandomIntegerArray(int sizeStartValue, int sizeEndValue, int rangeStartValue,
			int rangeEndValue) {
		return Arrays
				.stream(Utility.generateRandomIntArray(sizeStartValue, sizeEndValue, rangeStartValue, rangeEndValue))
				.boxed().toArray(Integer[]::new);
	}

	public static List<Character> generateString(int sizeStartValue, int sizeEndValue) {
		List<Character> finalString = new ArrayList<>();
		for (int element : new Random().ints(new Random().nextInt(sizeStartValue, sizeEndValue), 97, 122).toArray()) {
			finalString.add((char) element);
		}
		return finalString;
	}

	public static int[][] prepareMatrix(int rows) {
		int[][] returnValue = new int[rows][rows];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
				returnValue[i][j] = (((i + 1) * rows) + (j + 1)) - rows;
			}
		}
		return returnValue;
	}

	public static String prepareStringFromCharacterArray(List<Character> listOfCharacters) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Character character : listOfCharacters) {
			stringBuilder.append(character);
		}
		return stringBuilder.toString();
	}

	public static void printArrayElements(String message, int[] arrayElements) {
		Utility.printArrayElements(message, arrayElements, 0, arrayElements.length);
	}

	public static void printArrayElements(String message, int[] arrayElements, int start, int end) {
		System.out.println("\n" + message);
		System.out.println(Arrays.toString(arrayElements));
	}

	public static void printArrayElements(String message, Object[] arrayElements) {
		Utility.printArrayElements(message, arrayElements, 0, arrayElements.length);
	}

	public static void printArrayElements(String message, Object[] arrayElements, int start, int end) {
		System.out.println("\n" + message);
		System.out.println(Arrays.toString(arrayElements));
	}

	public static void printMatrix(int[][] matrix) {
		int rowsCount = matrix.length;
		int columnsCount = matrix[0].length;
		for (int i = 0; i < rowsCount; i++) {
			for (int j = 0; j < columnsCount; j++) {
				System.out.printf("%5d", matrix[i][j]);
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public static void swap(int[] arrayElements, int start, int end) {
		int temp = arrayElements[start];
		arrayElements[start] = arrayElements[end];
		arrayElements[end] = temp;
	}

}
