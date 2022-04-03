package com.senthu.sample;

public class TransposeMatrixClockwiseRotator {
	public static void main(String[] args) {
		char[][] matrix = Utility.prepareMatrix(Utility.generateRandomInteger(3, 9));
		System.out.println("Original Matrix:\n");
		Utility.printMatrix(matrix);

		Utility.transposeMatrix(matrix);

		System.out.println("Transposed Matrix:\n");
		Utility.printMatrix(matrix);
		int rowCount = matrix.length;
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < (rowCount / 2); j++) {
				char temp = matrix[i][j];
				matrix[i][j] = matrix[i][rowCount - j - 1];
				matrix[i][rowCount - j - 1] = temp;
			}
		}

		System.out.println("90 Degree Clockwise Roated Matrix:\n");
		Utility.printMatrix(matrix);
	}

}
