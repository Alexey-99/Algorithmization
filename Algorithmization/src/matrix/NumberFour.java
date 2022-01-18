/* Сформировать квадратную матрицу порядка n по заданному образцу(n - четное): 
 * */

package matrix;

import java.util.Random;

public class NumberFour {

	public static void main(String[] args) {
		Random rand = new Random();
		int y = rand.nextInt(30) + 1;
		int x = rand.nextInt(30) + 1;
		int[][] matrix = new int[y][x];
		matrix = matrixCreationRandNumber(matrix);
		System.out.println();
		printMatrix(matrix);
	}

	private static int[][] matrixCreationRandNumber(int[][] matrix) {
		System.out.println("Первоначальная матрица.");
		Random rand = new Random();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = rand.nextInt(10);
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		return matrix;
	}

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			if ((i == 0) || (i % 2 != 0)) {
				for (int j = 0; j < matrix[i].length; j++) {
					System.out.print(matrix[i][j] + " ");
				}
			} else if ((i != 0) && (i % 2 == 0)) {
				for (int j = matrix[i].length - 1; j >= 0; j--) {
					System.out.print(matrix[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
}
