/* Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. 
 * Определить, какой столбец содержит максимальную сумму.
 */

package matrix;

import java.util.Random;

public class NumberNine {

	public static void main(String[] args) {
		int linesCount = matrixLengthInitialization();
		int columnCount = matrixLengthInitialization();
		int[][] matrix = new int[linesCount][columnCount];
		matrix = fillingMatrixRandomNumbers(matrix);
		calculateSumColumn(matrix);
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
				do {
					matrix[i][j] = rand.nextInt(9) + 1;
					System.out.print(matrix[i][j] + " ");
				} while (matrix[i][j] < 0);
			}
			System.out.println();
		}
		return matrix;
	}

	private static void calculateSumColumn(int[][] matrix) {
		int sum = 0;
		int sumMax = 0;
		int indexColumnSumMax = 0;
		int indexLine = 0;
		for (int i = 0; i < matrix[indexLine].length; i++) {
			sum = 0;
			for (int j = 0; j < matrix.length; j++) {
				sum += matrix[j][i];
			}
			if (sumMax < sum) {
				sumMax = sum;
				indexColumnSumMax = i;
			}
			indexLine++;
		}
		System.out.println("В столбце под индексом " + indexColumnSumMax + " самая большая сумма чисел.");
	}
}