/*Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число единиц равно номеру столбца. */

package matrix;

import java.util.Random;

public class NumberFourteen {

	public static void main(String[] args) {
		int m = matrixLengthInitialization();
		int n = m;
		int[][] matrix = new int[m][n + 1];
		System.out.println("Матрица состоящая из нулей и единиц: ");
		printMatrix(matrix, m, n);

	}

	private static int matrixLengthInitialization() {
		int length = 0;
		Random rand = new Random();
		while (length < 1) {
			length = rand.nextInt(10);
		}
		return length;
	}

	private static void printMatrix(int[][] matrix, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (j >= i) {
					matrix[i][j] = 1;	
				}
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
