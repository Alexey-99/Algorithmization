/*Сформировать квадратную матрицу порядка n по заданному образцу(n - четное): 
 * 1 1 1 1 1 ... 1 1 1 
 * 2 2 2 2 2 ... 2 2 0 
 * 3 3 3 3 3 ... 3 0 0 
 * . . . . . .   . . .  
 * . . . . .  .  . . .
 * . . . . .   . . . .
 * n-1 n-1 0 0 0 0 0 0 
 * n 0 0 0 0 0 0 0 0 0 
 * */

package by.home.algorithmization.matrix;

import java.util.Random;

public class NumberFive {

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
				if (j < matrix[i].length - i) {
					matrix[i][j] = i + 1;
				}
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}