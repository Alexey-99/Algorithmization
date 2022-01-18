/* Сформировать квадратную матрицу порядка n по заданному образцу(n - четное): 
 * 1  2   3  ... n 
 * n n-1 n-2 ... 1 
 * 1  2   3  ... n 
 * n n-1 n-2 ... 1  
 * . . . . . .   .
 * . . . . .  .  .
 * . . . . .   . .
 * n n-1 n-2 ... 1 
 * */

package matrix;

import java.util.Random;

public class NumberFour {

	public static void main(String[] args) {
		int n = matrixLengthInitialization();
		int[][] matrix = new int[n][n];
		printMatrix(matrix);
	}

	private static int matrixLengthInitialization() {
		int length = 0;
		Random rand = new Random();
		while ((length % 2 != 0) || (length == 0)) {
			length = rand.nextInt(10);
		}
		return length;
	}

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			if ((i == 0) || (i % 2 == 0)) {
				for (int j = 0; j < matrix[i].length; j++) {
					System.out.print(matrix[i][j] + (j + 1) + " ");
				}
			} else if ((i != 0) && (i % 2 != 0)) {
				for (int j = matrix[i].length - 1; j >= 0; j--) {
					System.out.print(matrix[i][j] + (j + 1) + " ");
				}
			}
			System.out.println();
		}
	}
}
