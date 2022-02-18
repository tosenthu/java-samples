package com.senthu.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FillMissingNumbers {
	public static void main(String[] args) {

		int[] originalArray = { 1, 4, 13, 19, 12, 2, 5, 8, 7, 3 };
		// Sorted : {1, 3, 4,7}
		// Output : {1, -1, 3, 4, -1, -1, 7}

		int[] sortedArray = originalArray.clone();
		Arrays.sort(sortedArray);
		List<Integer> result = new ArrayList<>();

		for (int index = 0; index < (sortedArray.length - 1); index++) {
			result.add(sortedArray[index]);
			if (sortedArray[index + 1] != (sortedArray[index] + 1)) {
				for (int jIndex = sortedArray[index] + 1; jIndex < sortedArray[index + 1]; jIndex++) {
					result.add(-1);
				}
			}
		}
		result.add(sortedArray[sortedArray.length - 1]);
		System.out.println(result);
	}
}
