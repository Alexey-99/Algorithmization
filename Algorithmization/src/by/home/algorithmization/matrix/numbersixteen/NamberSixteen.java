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

package by.home.algorithmization.matrix.numbersixteen;

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
			DoubleParityOrderSquare doubleParityOrderSquare = new DoubleParityOrderSquare();
			doubleParityOrderSquare.buildingDoubleParityOrderSquare(size);
		} else if ((size % 2 == 0) && (size % 4 != 0)) { //TODO 1
			

		} else if (size % 2 != 0) { //TODO 3

		}
	}
}