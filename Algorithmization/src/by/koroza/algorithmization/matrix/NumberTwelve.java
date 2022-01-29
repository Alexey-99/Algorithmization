/* Отсортировать строки матрицы по возрастанию и убыванию значений элементов.*/

package by.koroza.algorithmization.matrix;

import java.util.Random;

public class NumberTwelve {

	public static void main(String[] args) {
		int linesCount = matrixLengthInitialization();
		int columnCount = matrixLengthInitialization();
		int[][] matrix = new int[linesCount][columnCount];
		matrix = fillingMatrixRandomNumbers(matrix);
		System.out.println("Исходная матрица: ");
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

	private static void sortAndPrintMatrix(int[][] matrix) {
		System.out.println();
		matrix = sortingMatrixRowsAscending(matrix);
		System.out.println("Массив с сортировкой элементов строк по возростанию: ");
		printMatrix(matrix);
		System.out.println();
		matrix = sortingMatrixRowsDescending(matrix);
		System.out.println("Массив с сортировкой элементов строк по убыванию: ");
		printMatrix(matrix);
	}

	private static int[][] sortingMatrixRowsAscending(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length - 1; j++) {
				for (int f = j; f < matrix[i].length; f++) {
					if (matrix[i][j] > matrix[i][f]) {
						int tmp = matrix[i][j];
						matrix[i][j] = matrix[i][f];
						matrix[i][f] = tmp;
					}
				}

			}
		}
		return matrix;
	}

	private static int[][] sortingMatrixRowsDescending(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length - 1; j++) {
				for (int f = j; f < matrix[i].length; f++) {
					if (matrix[i][j] < matrix[i][f]) {
						int tmp = matrix[i][j];
						matrix[i][j] = matrix[i][f];
						matrix[i][f] = tmp;
					}
				}
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
}