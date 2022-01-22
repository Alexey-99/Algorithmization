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
		int size = matrixLengthInitialization();
		if ((size % 2 == 0) && (size % 4 == 0)) { // 2
			buildingDoubleParityOrderSquare(size);
		} else if ((size % 2 == 0) && (size % 4 != 0)) { // 1

		} else if (size % 2 != 0) {

		}
	}

	private static void buildingDoubleParityOrderSquare(int size) {
		int[][] matrix = new int[size][size];
		int magicConstant = calculateMagicConstant(size);
		System.out.println("Магическая сумма:" + magicConstant);
		matrix = buildingMagicSquareCornerAndCenterElements(matrix);
		buildingMagicSquareExtremeElements(matrix);
		printMagicSquare(matrix);
	}

	private static int calculateMagicConstant(int size) {
		int magicConstant = (size * ((int) Math.pow(size, 2) + 1)) / 2;
		return magicConstant;
	}

	private static int[][] buildingMagicSquareCornerAndCenterElements(int[][] matrix) {
		int beginningCentralSquareTop = matrix.length / 4 - 1;
		int beginningCentralSquareBottom = matrix.length - beginningCentralSquareTop - 1;
		int beginningCentralSquareLeft = beginningCentralSquareTop;
		int beginningCentralSquareRight = beginningCentralSquareBottom;
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				count++;
				if ((i == 0 || i == matrix.length - 1) && ((j == 0) || (j == matrix[i].length - 1))) {
					matrix[i][j] = count;
				} else if ((i > beginningCentralSquareTop && i < beginningCentralSquareBottom)
						&& (j > beginningCentralSquareLeft && j < beginningCentralSquareRight)) {
					matrix[i][j] = count;
				}
			}
		}
		return matrix;
	}

	private static int[][] buildingMagicSquareExtremeElements(int[][] matrix) {
		int beginningCentralSquareTop = matrix.length / 4 - 1;
		int beginningCentralSquareBottom = matrix.length - beginningCentralSquareTop - 1;
		int beginningCentralSquareLeft = beginningCentralSquareTop + 1;
		int beginningCentralSquareRight = beginningCentralSquareBottom - 1;
		int count = 0;
		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = matrix[i].length - 1; j >= 0; j--) {
				count++;
				if ((i == 0 || i == matrix.length - 1) && (j > 0 && j < matrix[i].length - 1)) {
					matrix[i][j] = count;
				} else if ((i > beginningCentralSquareTop && i < beginningCentralSquareBottom)
						&& (j < beginningCentralSquareLeft || j > beginningCentralSquareRight)) {
					matrix[i][j] = count;
				} else if ((i > 0 && i <= beginningCentralSquareTop)
						|| (i < matrix.length - 1 && i >= beginningCentralSquareBottom)) {
					matrix[i][j] = count;
				}
			}
		}
		return matrix;
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