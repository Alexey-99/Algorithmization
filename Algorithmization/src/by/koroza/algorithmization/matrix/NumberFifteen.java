/* Найдите наибольший элемент матрицы и заменить все нечетные элементы на него. */

package by.koroza.algorithmization.matrix;

import java.util.Random;

public class NumberFifteen {

	public static void main(String[] args) {
		int linesCount = matrixLengthInitialization();
		int columnCount = matrixLengthInitialization();
		int[][] matrix = new int[linesCount][columnCount];
		matrix = fillingMatrixRandomNumbers(matrix);
		System.out.println("Исходная матрица: ");
		printMatrix(matrix);
		replaceAllOddElementsWithMaximumElement(matrix);

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
			}
		}
		return matrix;
	}

	private static int[][] printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		return matrix;
	}

	private static int findMaxNumber(int[][] matrix) {
		int maxNumber = matrix[0][0];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (maxNumber < matrix[i][j]) {
					maxNumber = matrix[i][j];
				}
			}
		}
		return maxNumber;
	}

	private static void replaceAllOddElementsWithMaximumElement(int[][] matrix) {
		System.out.println();
		int maxNumber = findMaxNumber(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] % 2 != 0) {
					matrix[i][j] = maxNumber;
				}
			}
		}
		printMatrix(matrix);
	}
}