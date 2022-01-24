/*Дана матрица. Вывести k-ю строку и p-й столбец матрицы. */

package by.home.algorithmization.matrix;

import java.util.Random;

public class NumberThree {

	public static void main(String[] args) {
		int lineNumber = 3;
		int columnNumber = 1;
		int x = 5;
		int y = 11;
		int[][] matrix = new int[y][x];
		matrix = arrayCreation(matrix);
		System.out.println();
		printDesiredLine(matrix, lineNumber);
		printinDesiredColumn(matrix, columnNumber);
	}

	private static int[][] arrayCreation(int[][] matrix) {
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

	private static void printDesiredLine(int[][] matrix, int lineNumber) {
		if ((lineNumber < matrix.length) && (lineNumber >= 0)) {
			System.out.println("Строка под индексом: " + lineNumber);
			for (int i = lineNumber; i < lineNumber + 1; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					System.out.print(matrix[i][j] + " ");
				}
				System.out.println();
			}
		} else {
			System.out.println("Не верно введен номер строки.");
		}
		System.out.println();
	}

	private static void printinDesiredColumn(int[][] matrix, int columnNumber) {
		if ((columnNumber < matrix[0].length) && (columnNumber >= 0)) {
			System.out.println("Столбец под индексом: " + columnNumber);
			for (int i = 0; i < matrix.length; i++) {
				for (int j = columnNumber; j == columnNumber; j++) {
					System.out.print(matrix[i][j] + " ");
				}
				System.out.println();
			}
		}else {
			System.out.println("Не верно введен номер столбца.");
		}
		System.out.println();
	}
}