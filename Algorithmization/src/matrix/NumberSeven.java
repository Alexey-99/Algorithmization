/* Сформировать квадратную матрицу порядка N по правилу: 
 * A[I,J] = sin((I2 * J2) / N)
 *
 */

package matrix;

import java.util.Random;

public class NumberSeven {

	public static void main(String[] args) {
		int n = matrixLengthInitialization();
		int[][] matrix = new int[n][n];
		printMatrix(matrix);
	}

	private static int matrixLengthInitialization() {
		int length = 0;
		Random rand = new Random();
		while (length <= 1) {
			length = rand.nextInt(10);
		}
		return length;
	}

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (int) Math.ceil(Math.sin((Math.pow(i, 2) - Math.pow(j, 2)) / matrix.length));
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
