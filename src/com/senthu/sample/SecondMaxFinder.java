package com.senthu.sample;

public class SecondMaxFinder {

	public static void main(String[] args) {
		
		int[] array = {45,23,45,675,78,34,88902,45,67,347};
		
		int firstMax = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		for (int element : array) {
			if (element > firstMax) {
				secondMax = firstMax;
				firstMax = element;
			}
		}
		
		System.out.println(firstMax + " " + secondMax);
	}
}
