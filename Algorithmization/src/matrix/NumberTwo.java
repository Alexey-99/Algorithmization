/* Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали. */

package matrix;

import java.util.Random;

public class NumberTwo {

	public static void main(String[] args) {
		Random rand = new Random();
		int x = rand.nextInt(10) + 1;
		int y = x;
		int[][] matrix = new int[y][x];
		matrix = arrayCreation(matrix);
		drawingElementsDiagonallyFromLeftToRight(matrix);
		drawingElementsDiagonallyFromRightToLeft(matrix);
	}

	private static int[][] arrayCreation(int[][] matrix) {
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

	private static void drawingElementsDiagonallyFromRightToLeft(int[][] matrix) {
		System.out.println(" ");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = matrix[i].length - i - 1; j > matrix[i].length - i - 2; j--) {
				System.out.print(matrix[i][j] + " ");
			}
		}
	}

	private static void drawingElementsDiagonallyFromLeftToRight(int[][] matrix) {
		System.out.println(" ");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < i + 1; j++) {
				System.out.print(matrix[i][j] + " ");
			}
		}
	}
}