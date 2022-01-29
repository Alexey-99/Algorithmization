/* Найти положительные элементы главной диагонали квадратной матрицы. */

package by.koroza.algorithmization.matrix;

import java.util.Random;

public class NumberTen {

	public static void main(String[] args) {
		int length = matrixLengthInitialization();
		int[][] matrix = new int[length][length];
		matrix = fillingMatrixRandomNumbers(matrix);
		findPositiveElementsMainDiagonalFromLeftToRight(matrix);
		findPositiveElementsMainDiagonalFromRightToLeft(matrix);
	}

	private static int matrixLengthInitialization() {
		int length = 0;
		Random rand = new Random();
		while (length <= 1) {
			length = rand.nextInt(10);
		}
		return length;
	}

	private static int[][] fillingMatrixRandomNumbers(int[][] matrix) {
		Random rand = new Random();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = rand.nextInt(9) + 1;
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		return matrix;
	}

	private static void findPositiveElementsMainDiagonalFromLeftToRight(int[][] matrix) {
		System.out.println("Положительные элементы главной диагонали (с лева на право) квадратной матрицы.");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j <= i; j++) {
				if (matrix[i][j] >= 0) {
					System.out.print(matrix[i][j] + " ");
				}

			}
		}
		System.out.println();
	}

	private static void findPositiveElementsMainDiagonalFromRightToLeft(int[][] matrix) {
		System.out.println("Положительные элементы главной диагонали (с право на лево) квадратной матрицы.");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = matrix[i].length - 1 - i; j >= matrix[i].length - 1 - i; j--) {
				if (matrix[i][j] > 0) {
					System.out.print(matrix[i][j] + " ");
				}
			}
		}
	}
}