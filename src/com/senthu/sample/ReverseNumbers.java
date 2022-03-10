package com.senthu.sample;

import java.math.BigDecimal;
import java.util.Random;

public class ReverseNumbers {
	private static boolean isReversed(String original, String reversed) {
		return new StringBuilder(original).reverse().toString().equals(reversed);
	}

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
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

	private static BigDecimal reverseDecimalBigDecimalWay(double doubleValue) {
		BigDecimal originalDoubleValue = BigDecimal.valueOf(doubleValue);
		long originalIntegerPart = originalDoubleValue.longValue(), actualIntegerPart = originalIntegerPart;
		long reversedUnscaledValue = reverseInteger(originalDoubleValue.unscaledValue().longValue());
		BigDecimal result = new BigDecimal(0);
		while (actualIntegerPart > 0) {
			long lastDigit = reversedUnscaledValue % 10;
			actualIntegerPart /= 10;
			reversedUnscaledValue /= 10;
			result = result.divide(BigDecimal.TEN);
			result = result.add(BigDecimal.valueOf(lastDigit).divide(BigDecimal.TEN));
		}
		result = result.add(BigDecimal.valueOf(reversedUnscaledValue));
		return result;
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
