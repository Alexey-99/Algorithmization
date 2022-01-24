/* Матрицу 10x20 заполнить случайными числами от 0 до 15. 
 * Вывести на экран саму матрицу и номера строк, в которых число 5 встречается три и более раз.
 * */

package by.home.algorithmization.matrix;

import java.util.Random;

public class NumberEleven {

	public static void main(String[] args) {
		int[][] matrix = new int[10][20];
		matrix = fillingMatrixRandomNumbers(matrix);
		searchStringsWithMostDigitFive(matrix);
	}

	private static int[][] fillingMatrixRandomNumbers(int[][] matrix) {
		Random rand = new Random();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = rand.nextInt(15);
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		return matrix;
	}

	private static void searchStringsWithMostDigitFive(int[][] matrix) {
		System.out.print("Номер cтрок в которых цифра 5 встречается 3 и более раз: ");
		int counterNumberFive = 0;
		for (int i = 0; i < matrix.length; i++) {
			counterNumberFive = 0;
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 5) {
					counterNumberFive++;
				}
			}
			if (counterNumberFive >= 3) {
				System.out.print(i + " ");
			}
		}
	}
}