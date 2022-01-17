/* Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего. */

package matrix;

import java.util.Random;

public class NumberOne {

	public static void main(String[] args) {
		Random rand = new Random();
		int x = rand.nextInt(10) + 1;
		int y = rand.nextInt(10) + 1;
		int[][] matrix = new int[y][x];

		System.out.println("Первоначатльный многомерный массив:");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = rand.nextInt(10);
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		int[] arrayIndexСolumn = new int[x];
		int indexArrayIndexСolumn = 0;

		System.out.println("Все нечетные столбцы, у которых первый элемент больше последнего: ");
		for (int i = 0; i < 1; i++) {
			for (int j = 1; j < matrix[i].length; j += 2) {
				if (matrix[i][j] > matrix[matrix.length - 1][j]) {
					arrayIndexСolumn[indexArrayIndexСolumn] = j;
					indexArrayIndexСolumn++;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < indexArrayIndexСolumn; j++) {
					System.out.print(matrix[i][arrayIndexСolumn[j]] + " ");
			}
			System.out.println();
		}
	}
}