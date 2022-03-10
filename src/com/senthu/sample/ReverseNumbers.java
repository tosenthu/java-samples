package com.senthu.sample;

import java.math.BigDecimal;
import java.util.Random;

public class ReverseNumbers {
	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			long originalLong = new Random().nextLong(99999L, 99999999L);
			System.out.println("\nOriginal : " + String.valueOf(originalLong) + ", Reveresed : "
					+ String.valueOf(ReverseNumbers.reverseInteger(originalLong)));

			double doubleValue = new Random().nextDouble(9999.999999d, 99999999.99999999d);
			System.out.println("Original : " + BigDecimal.valueOf(doubleValue).toPlainString() + ", Reversed : "
					+ ReverseNumbers.reverseDecimalBigDecimalWay(doubleValue).toPlainString());
		}
	}

	private static BigDecimal reverseDecimalBigDecimalWay(double doubleValue) {
		BigDecimal originalDoubleValue = BigDecimal.valueOf(doubleValue);
		long originalIntegerPart = originalDoubleValue.longValue(), actualIntegerPart = originalIntegerPart;
		long reversedUnscaledValue = ReverseNumbers.reverseInteger(originalDoubleValue.unscaledValue().longValue());
		BigDecimal result = new BigDecimal(0);
		while (actualIntegerPart > 0) {
			long lastDigit = reversedUnscaledValue % 10;
			actualIntegerPart /= 10;
			reversedUnscaledValue /= 10;
			result = result.divide(BigDecimal.TEN).add(BigDecimal.valueOf(lastDigit).divide(BigDecimal.TEN));
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
