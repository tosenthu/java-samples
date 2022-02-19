package com.senthu.sample;

import java.util.Arrays;

public class FindMinMove {

	private static int findMinMove(int[] array) {
		int index = 0;
		int[] newArray = array.clone();
		Arrays.sort(array);
		Utility.printArrayElements("Orignal Array", newArray);
		Utility.printArrayElements("Sorted Array", array);
		for (int element : newArray) {
			if (element == array[index]) {
				index++;
			}
		}
		return array.length - index;
	}

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			System.out.println("\nTotal Moves : " + FindMinMove.findMinMove(Utility.generateRandomIntArray(5, 30, 1, 100)));
		}
	}
}
