/* Отсотрировать стобцы матрицы по возрастанию и убыванию значений эементов. */

package matrix;

import java.util.Random;

public class NumberThirteen {

	public static void main(String[] args) {
		int linesCount = matrixLengthInitialization();
		int columnCount = matrixLengthInitialization();
		int[][] matrix = new int[linesCount][columnCount];
		System.out.println("Исходная матрица: ");
		matrix = fillingMatrixRandomNumbers(matrix);
		printMatrix(matrix);
		sortAndPrintMatrix(matrix);

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

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void sortAndPrintMatrix(int[][] matrix) {
		System.out.println();
		matrix = sortColumnElementsInAscendingOrder(matrix);
		System.out.println("Массив с сортировкой элементов стобцов по возростанию: ");
		printMatrix(matrix);
		System.out.println();
		matrix = sortColumnElementsInDescendingOrder(matrix);
		System.out.println("Массив с сортировкой элементов столбцов по убыванию: ");
		printMatrix(matrix);
	}

	private static int[][] sortColumnElementsInAscendingOrder(int[][] matrix) {

		return matrix;
	}

	private static int[][] sortColumnElementsInDescendingOrder(int[][] matrix) {

		return matrix;
	}
}