package com.senthu.sample;

public class InPlaceMatrixRotator {

	public static void main(String[] args) {
		char[][] matrix = Utility.prepareMatrix(Utility.generateRandomInteger(4, 10));
		System.out.println("Original Matrix:\n");
		Utility.printMatrix(matrix);
		InPlaceMatrixRotator.rotateMatrix(matrix);
		System.out.println("90 Degree Anti-Clockwise Rotated Matrix:\n");
		Utility.printMatrix(matrix);

		InPlaceMatrixRotator.rotateMatrix(matrix);
		System.out.println("180 Degree Anti-Clockwise Rotated Matrix:\n");
		Utility.printMatrix(matrix);

		InPlaceMatrixRotator.rotateMatrix(matrix);
		System.out.println("270 Degree Anti-Clockwise Rotated Matrix:\n");
		Utility.printMatrix(matrix);

		InPlaceMatrixRotator.rotateMatrix(matrix);
		System.out.println("Rotated back to Original Matrix:\n");
		Utility.printMatrix(matrix);
	}

	private static void rotateMatrix(char[][] matrix) {
		int rows = matrix.length;
		for (int i = 0; i < (rows / 2); i++) {
			for (int j = i; j < (rows - i - 1); j++) {
				char leftTop = matrix[i][j];
				char leftBottom = matrix[rows - j - 1][i];
				char rightBottom = matrix[rows - i - 1][rows - j - 1];
				char rightTop = matrix[j][rows - i - 1];

				matrix[i][j] = rightTop;
				matrix[rows - j - 1][i] = leftTop;
				matrix[rows - i - 1][rows - j - 1] = leftBottom;
				matrix[j][rows - i - 1] = rightBottom;
			}
		}
	}
}
