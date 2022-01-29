/* Сформировать квадратную матрицу порядка N по правилу: 
 * A[I,J] = sin((I2 * J2) / N)
 * 
 * и подсчитать количество положительных элементов в ней. 
 */

package by.koroza.algorithmization.matrix;

import java.util.Random;

public class NumberSeven {

	public static void main(String[] args) {
		int n = matrixLengthInitialization();
		double[][] matrix = new double[n][n];
		printMatrix(matrix);
		countingPositiveNumbers(matrix);
	}

	private static int matrixLengthInitialization() {
		int length = 0;
		Random rand = new Random();
		while (length <= 1) {
			length = rand.nextInt(10);
		}
		return length;
	}

	private static void printMatrix(double[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = Math.sin((Math.pow(i, 2) - Math.pow(j, 2)) / matrix.length);
				System.out.printf("%.3f", matrix[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	private static void countingPositiveNumbers(double[][] matrix) {
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] >= 0) {
					count++;
				}
			}
		}
		System.out.println("Количество положительных элементов в матрице: " + count);
	}
}
