package com.senthu.sample;

import java.util.Arrays;

public class FindMinMove {

	private static int findMinMove(int[] array) {
		int index = 0;
		int[] newArray = array.clone();
		Arrays.sort(array);
		Utility.printArrayElements(newArray);
		Utility.printArrayElements(array);
		for (int element : newArray) {
			if (element == array[index]) {
				index++;
			}
		}
		return array.length - index;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(findMinMove(Utility.generateRandomIntegerArray(5, 30, 1, 100)));
		}
	}
}
