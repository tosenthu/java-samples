package com.senthu.sample;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class FindMinMove {

	private static int findMinMove(Integer[] array) {
		int index = 0;
		Integer[] newArray = array.clone();
		Arrays.sort(array);
		printArray("Original", newArray);
		printArray("Sorted  ", array);
		for (int element : newArray) {
			if (element == array[index])
				index++;
		}
		return array.length - index;
	}

	private static Integer[] prepareList() {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int element : new Random().ints(new Random().nextInt(5, 30), 1, 100).toArray()) {
			set.add(element);
		}
		return set.toArray(Integer[]::new);
	}

	private static void printArray(String message, Integer[] array) {
		System.out.println(message + " : " + Arrays.toString(array));
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(findMinMove(prepareList()));
		}
	}
}
