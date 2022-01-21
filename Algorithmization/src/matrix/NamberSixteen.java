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

import java.util.Scanner;

public class NamberSixteen {

	public static void main(String[] args) {
		buildingAndPrintMagicSquare();
	}

	private static int matrixLengthInitialization() {
		int length = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Введите размер магического квадрата");
		length = scan.nextInt();
		scan.close();
		return length;
	}

	private static void buildingAndPrintMagicSquare() {
		int length = matrixLengthInitialization();
		if ((length % 2 == 0) && (length % 4 == 0)) { // 2

		} else if ((length % 2 == 0) && (length % 4 != 0)) { // 1

		} else if (length % 2 != 0) {

		}
	}

	private static void printMagicSquare(int[][] matrix) {
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}