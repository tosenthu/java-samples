package com.senthu.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Utility {
	private static void fillColumnWithPipe(char[][] matrix, int columnToFill, int totalColumns) {
		for (int i = 0; i < totalColumns; i++) {
			matrix[i][columnToFill] = '#';
		}
	}

	private static void fillRowWithHyphen(char[][] matrix, int rowToFill, int totalRows) {
		for (int i = 0; i < totalRows; i++) {
			matrix[rowToFill][i] = '+';
		}
	}

	public static int[] generateRandomIntArray(int sizeStartValue, int sizeEndValue, int rangeStartValue,
			int rangeEndValue) {
		int arraySize = Utility.nextInt(sizeStartValue, sizeEndValue);
		int[] arrayElements = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			arrayElements[i] = Utility.nextInt(rangeStartValue, rangeEndValue);
		}
		return arrayElements;
	}

	public static int nextInt(int min, int max) {
		return new Random().nextInt((max - min) + 1) + min;
	}

	public static long nextLong(long min, long max) {
		return min + new Random().nextLong() * max;
	}

	public static double nextDouble(double min, double max) {
		return min + new Random().nextDouble() * max;
	}
	public static int generateRandomInteger(int range, int limit) {
		return Utility.nextInt(range, limit);
	}

	public static Integer[] generateRandomIntegerArray(int sizeStartValue, int sizeEndValue, int rangeStartValue,
			int rangeEndValue) {
		return Arrays
				.stream(Utility.generateRandomIntArray(sizeStartValue, sizeEndValue, rangeStartValue, rangeEndValue))
				.boxed().toArray(Integer[]::new);
	}

	public static List<Character> generateString(int sizeStartValue, int sizeEndValue) {
		List<Character> finalString = new ArrayList<>();
		for (int element : new Random().ints(Utility.nextInt(sizeStartValue, sizeEndValue), 97, 122).toArray()) {
			finalString.add((char) element);
		}
		return finalString;
	}

	public static char[][] prepareMatrix(int rows) {
		char[][] returnValue = new char[rows][rows];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
				if (i > (rows / 2)) {
					returnValue[i][j] = '~';
					if (j > (rows / 2)) {
						returnValue[i][j] = '=';
					}
				} else {
					returnValue[i][j] = '*';
					if (j > (rows / 2)) {
						returnValue[i][j] = '-';
					}
				}
			}
		}

		if ((rows % 2) == 0) {
			Utility.fillRowWithHyphen(returnValue, (rows / 2) - 1, rows);
		}
		Utility.fillRowWithHyphen(returnValue, rows / 2, rows);

		if ((rows % 2) == 0) {
			Utility.fillColumnWithPipe(returnValue, (rows / 2) - 1, rows);
		}
		Utility.fillColumnWithPipe(returnValue, rows / 2, rows);
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

	public static void printMatrix(char[][] matrix) {
		int rowsCount = matrix.length;
		int columnsCount = matrix[0].length;
		for (int i = 0; i < rowsCount; i++) {
			for (int j = 0; j < columnsCount; j++) {
				System.out.printf("%3c", matrix[i][j]);
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

	public static void transposeMatrix(char[][] matrix) {
		int rowCount = matrix.length;
		int columnCount = matrix[0].length;
		for (int i = 0; i < rowCount; i++) {
			for (int j = i; j < columnCount; j++) {
				char temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
}
