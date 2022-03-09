package com.senthu.sample;

public class SecondMaxFinder {

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			int[] array = Utility.generateRandomIntArray(5, 15, 1, 100);

			int firstMax = Integer.MIN_VALUE;
			int secondMax = Integer.MIN_VALUE;
			for (int element : array) {
				if (element > firstMax) {
					secondMax = firstMax;
					firstMax = element;
				} else if ((element > secondMax) && (element != firstMax)) {
					secondMax = element;
				}
			}
			Utility.printArrayElements("Original Array", array);
			System.out.println("First Maximum Number : " + firstMax + ", Second Maximum Number : " + secondMax);
		}
	}
}
