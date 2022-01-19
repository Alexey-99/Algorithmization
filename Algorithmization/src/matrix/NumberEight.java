/*В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить на 
 * соответствующие им позиции другого, а его элементы второго переместить в первый. 
 * Номера столбцов вводит пользователь с клавиатуры. 
 */

package matrix;

import java.util.Random;
import java.util.Scanner;

public class NumberEight {

	public static void main(String[] args) {
		int linesCount = matrixLengthInitialization();
		int columnCount = matrixLengthInitialization();
		int[][] matrix = new int[linesCount][columnCount];
		matrix = fillingMatrixRandomNumbers(matrix);
		replacingTwoColumnsWithEachOther(matrix, columnCount);
	}

	private static int matrixLengthInitialization() {
		int length = 0;
		Random rand = new Random();
		while (length <= 1) {
			length = rand.nextInt(10);
		}
		return length;
	}

	private static int[][] fillingMatrixRandomNumbers(int[][] matrix) {
		Random rand = new Random();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = rand.nextInt(9) + 1;
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		return matrix;
	}

	private static int inputReplacementOneColumnNumber(int columnCount) {
		StringBuilder build = new StringBuilder();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int column = 0;
		do {
			build.append("Введите номер столбца (от 0 до ").append(columnCount - 1)
					.append(" включительно) на который необходимо заменить столбец: ");
			System.out.println(build);
			column = scan.nextInt();
		} while (column < 0 || column >= columnCount);
		return column;
	}

	private static int inputReplacementTwoColumnNumber(int columnCount, int columnOne) {
		StringBuilder build = new StringBuilder();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int column = 0;
		do {
			build.append("Введите номер столбца (от 0 до ").append(columnCount - 1).append(" включительно, кроме ")
					.append(columnOne)
					.append(", так как это номер столбца который заменяется) на который необходимо заменить столбец: ");
			System.out.println(build);
			column = scan.nextInt();
		} while (column < 0 || column >= columnCount || column == columnOne);
		return column;
	}

	private static void replacingTwoColumnsWithEachOther(int[][] matrix, int columnCount) {
		int columnOne = inputReplacementOneColumnNumber(columnCount);
		int columnTwo = inputReplacementTwoColumnNumber(columnCount, columnOne);
		System.out.println("Матрица с переставленными столбцами под номером " + columnOne + " и " + columnTwo + ": ");
		for (int i = 0; i < matrix.length; i++) {
			int tmp = matrix[i][columnOne];
			matrix[i][columnOne] = matrix[i][columnTwo];
			matrix[i][columnTwo] = tmp;
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}