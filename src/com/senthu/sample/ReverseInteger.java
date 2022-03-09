package com.senthu.sample;

import java.math.BigDecimal;
import java.util.Random;

public class ReverseInteger {
	public static void main(String[] args) {

		long originalLong = new Random().nextLong(99999l, 99999999l);
		long resultLong = reverseInteger(originalLong);
		System.out.println("Original : " + originalLong + ", Reveresed : " + resultLong);

		double doubleValue = new Random().nextDouble(9999.999999d, 99999999.99999999d);
		BigDecimal resultDouble = reverseDecimalBigDecimalWay(doubleValue);
		System.out.println("Original : " + BigDecimal.valueOf(doubleValue).toPlainString() + ", Reversed : "
				+ resultDouble.toPlainString());
	}

	private static BigDecimal reverseDecimalBigDecimalWay(double doubleValue) {
		BigDecimal actualDoubleValue = BigDecimal.valueOf(doubleValue);
		long originalIntegerPart = actualDoubleValue.longValue();
		long actualIntegerPart = originalIntegerPart;

		while (actualDoubleValue.remainder(BigDecimal.valueOf(actualDoubleValue.longValue()))
				.compareTo(BigDecimal.ZERO) > 0) {
			actualDoubleValue = actualDoubleValue.multiply(new BigDecimal(10.0));
			originalIntegerPart *= 10;
		}

		long finalDivider = 1;
		long tempActualIntegerPart = actualIntegerPart;
		while (tempActualIntegerPart > 0) {
			finalDivider *= 10;
			tempActualIntegerPart /= 10;
		}

		BigDecimal resultDouble = BigDecimal
				.valueOf(reverseInteger(actualDoubleValue.longValue() - originalIntegerPart));
		BigDecimal reversedIntegerPart = BigDecimal.valueOf(reverseInteger(actualIntegerPart));
		BigDecimal finalReversedIntegerPart = reversedIntegerPart.divide(BigDecimal.valueOf(finalDivider));
		resultDouble = resultDouble.add(finalReversedIntegerPart);
		return resultDouble;
	}

	private static long reverseInteger(long original) {
		long temp = original;
		long result = 0;
		while (temp > 0) {
			result = result * 10 + (temp % 10);
			temp /= 10;
		}
		return result;
	}

}
