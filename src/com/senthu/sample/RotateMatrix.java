package com.senthu.sample;

public class RotateMatrix {

	public static void main(String[] args) {
		int[][] matrix = Utility.prepareMatrix(5);
		Utility.printMatrix(matrix);

		int rows = matrix.length;
		for (int i = 0; i < (rows / 2); i++) {
			for (int j = i; j < (rows - i - 1); j++) {
				int leftTop = matrix[i][j];
				int leftBottom = matrix[rows - j - 1][i];
				int rightBottom = matrix[rows - i - 1][rows - j - 1];
				int rightTop = matrix[j][rows - i - 1];

				matrix[i][j] = rightTop;
				matrix[rows - j - 1][i] = leftTop;
				matrix[rows - i - 1][rows - j - 1] = leftBottom;
				matrix[j][rows - i - 1] = rightBottom;
			}
		}

		Utility.printMatrix(matrix);
	}
}
