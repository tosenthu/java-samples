package com.senthu.sample;

import java.math.BigDecimal;
import java.util.Random;

public class ReverseNumbers {
	private static boolean isReversed(String original, String reversed) {
		return new StringBuilder(original).reverse().toString().equals(reversed);
	}

	public static void main(String[] args) {

		for (int i = 0; i < 20; i++) {
			long originalLong = new Random().nextLong(99999L, 99999999L);
			String originalValueInString = String.valueOf(originalLong);
			String reverseedValueInString = String.valueOf(ReverseNumbers.reverseInteger(originalLong));
			System.out.println("\nOriginal : " + originalValueInString + ", Reveresed : " + reverseedValueInString
					+ ", Is Reversed : " + ReverseNumbers.isReversed(originalValueInString, reverseedValueInString));

			double doubleValue = new Random().nextDouble(9999.999999d, 99999999.99999999d);
			String originalValueFormattedString = BigDecimal.valueOf(doubleValue).toPlainString();
			String reversedValueFormattedString = ReverseNumbers.reverseDecimalBigDecimalWay(doubleValue)
					.toPlainString();
			System.out.println("Original : " + originalValueFormattedString + ", Reversed : "
					+ reversedValueFormattedString + ", Is Reversed : "
					+ ReverseNumbers.isReversed(originalValueFormattedString, reversedValueFormattedString));
		}
	}

	// Failing test 30674036.001488812
	private static BigDecimal reverseDecimalBigDecimalWay(double doubleValue) {
		BigDecimal originalDoubleValue = BigDecimal.valueOf(doubleValue);
		long originalIntegerPart = originalDoubleValue.longValue(), actualIntegerPart = originalIntegerPart;

		while (originalDoubleValue.remainder(BigDecimal.valueOf(originalDoubleValue.longValue()))
				.compareTo(BigDecimal.ZERO) > 0) {
			originalDoubleValue = originalDoubleValue.multiply(new BigDecimal(10.0));
			actualIntegerPart *= 10;
		}

		long integerPartDivisor = 1, tempActualIntegerPart = originalIntegerPart;
		while (tempActualIntegerPart > 0) {
			integerPartDivisor *= 10;
			tempActualIntegerPart /= 10;
		}

		BigDecimal resultDouble = BigDecimal
				.valueOf(ReverseNumbers.reverseInteger(originalDoubleValue.longValue() - actualIntegerPart));
		BigDecimal dividedReversedIntegerPart = BigDecimal.valueOf(ReverseNumbers.reverseInteger(originalIntegerPart))
				.divide(BigDecimal.valueOf(integerPartDivisor));
		resultDouble = resultDouble.add(dividedReversedIntegerPart);
		return resultDouble;
	}

	private static long reverseInteger(long original) {
		long temp = original;
		long result = 0;
		while (temp > 0) {
			result = (result * 10) + (temp % 10);
			temp /= 10;
		}
		return result;
	}

}
