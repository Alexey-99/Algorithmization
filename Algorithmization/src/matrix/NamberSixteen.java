/* Магическим квадратом порядка n называется квадратная матрица размера n x n, 
 * составленная из чисел 1, 2, 3, ..., n2 так, что суммы по каждому столбцу, 
 * каждой строке и каждой из двух больших диагоналей равны между собой. 
 * Построить такой квадрат. 
 * Пример магического квадрата порядка 3: 
 * 
 * 6  1  8 
 * 7  5  3 
 * 2  9  4
 * 
 * */

package matrix;

import java.util.Random;

public class NamberSixteen {

	public static void main(String[] args) {
		int length = 4;// matrixLengthInitialization();
		int[][] matrix = new int[length][length];
		buildingAndPrintMagicSquare(matrix);

	}

	private static int matrixLengthInitialization() {
		int length = 0;
		Random rand = new Random();
		while ((length <= 1) || (length >= 10)) {
			length = rand.nextInt(10);
		}
		return length;
	}

	private static void buildingAndPrintMagicSquare(int[][] matrix) {
		matrix = arrangementRandomNumbers(matrix);
		printMagicSquare(matrix);

		int sumNumberHorizontally = sumCalculationHorizontally(matrix);
		int sumSeriesHorizontally = seriesSumCalculation(matrix, sumNumberHorizontally);
		int sumNumberVertically = sumCalculationVertically(matrix);
		int sumSeriesVertically = seriesSumCalculation(matrix, sumNumberVertically);
		int sumSeries = sumСomparison(matrix, sumSeriesHorizontally, sumSeriesVertically);

		cornerPointCalculation(matrix, sumNumberHorizontally, sumNumberVertically, sumSeries);
		printMagicSquare(matrix);

	}

	private static int[][] arrangementRandomNumbers(int[][] matrix) {
		Random rand = new Random();
		for (int i = 0; i < matrix.length - 1; i++) {
			if (i == 0) {
				for (int j = 0; j < matrix[i].length - 1; j++) {
					matrix[i][j] = rand.nextInt(8) + 1;
				}
			} else if (i > 0) {
				for (int j = 0; j < 1; j++) {
					matrix[i][j] = rand.nextInt(8) + 1;
				}
			}
		}
		return matrix;
	}

	private static int seriesSumCalculation(int[][] matrix, int sum) {
		do {
			sum++;
		} while (sum % matrix.length != 0);
		System.out.println("Сумма 'после' равна: " + sum);
		return sum;
	}

	private static int[][] cornerPointCalculation(int[][] matrix, int sumNumberHorizontally, int sumNumberVertically,
			int sumSeries) {
		matrix[0][matrix[0].length - 1] = sumSeries - sumNumberHorizontally;
		matrix[matrix.length - 1][0] = sumSeries - sumNumberVertically;
		return matrix;
	}

	private static void printMagicSquare(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int sumCalculationHorizontally(int[][] matrix) {
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			sum += matrix[0][i];
		}
		System.out.println("Сумма 'до' равна: " + sum);
		return sum;
	}

	private static int sumCalculationVertically(int[][] matrix) {
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < 1; j++) {
				sum += matrix[i][j];
			}
		}
		System.out.println("Сумма 'до' равна: " + sum);
		return sum;
	}

	private static int sumСomparison(int[][] matrix, int sumSeriesHorizontally, int sumSeriesVertically) {
		int sumSeries = sumSeriesHorizontally;
		if (sumSeriesVertically > sumSeriesHorizontally) {
			sumSeries = sumSeriesVertically;
		}
		System.out.println("Сумма 'Итого' равна: " + sumSeries);
		return sumSeries;
	}

}
