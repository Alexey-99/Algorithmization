/* Сформировать квадратную матрицу порядка n по заданному образцу(n - четное): 
 * 1 1 1 ... 1 1 1 
 * 0 1 1 ... 1 1 0 
 * 0 0 1 ... 1 0 0 
 * . . . .   . . .  
 * . . .  .  . . .
 * . . .   . . . .
 * 0 1 1 ... 1 1 0 
 * 1 1 1 ... 1 1 1 
*/
package matrix;

import java.util.Random;

public class NumberSix {

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
			for (int j = 0; j < matrix[i].length; j++) {
				if (((j >= i) && (j < matrix[i].length - i) && (i < matrix.length / 2))
						|| ((j >= matrix[i].length - 1 - i) && (j <= i) && (i >= matrix.length / 2))) {
					matrix[i][j] = 1;
				}
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}