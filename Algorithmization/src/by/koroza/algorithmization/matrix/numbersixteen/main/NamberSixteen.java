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

package by.koroza.algorithmization.matrix.numbersixteen.main;

import java.util.Scanner;

import by.koroza.algorithmization.matrix.numbersixteen.magicsquare.DoubleParityOrderSquare;
import by.koroza.algorithmization.matrix.numbersixteen.magicsquare.OddOrderSquare;
import by.koroza.algorithmization.matrix.numbersixteen.magicsquare.SingleParityOrderSquare;

public class NamberSixteen {
	
	// TODO ПРОВЕРИТЬ ЧТОБЫ НЕ БЫЛО МАГИЧЕСКИХ ЧИСЕЛ 

	public static void main(String[] args) {
		buildingAndPrintMagicSquare();
	}

	private static int matrixLengthInitialization() { //TODO ПРОВЕРКА ЧТО ВВЕДЕНО ЧИСЛО НЕ МЕНЕЕ 3 И ЧИСЛО ЭТО ВООБЩЕ
		int length = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Введите размер (не менее 3-ёх) магического квадрата ");
		length = scan.nextInt();
		scan.close();
		return length;
	}

	private static void buildingAndPrintMagicSquare() {
		int size = matrixLengthInitialization();
		if ((size % 2 == 0) && (size % 4 == 0)) {
			DoubleParityOrderSquare doubleParityOrderSquare = new DoubleParityOrderSquare();
			doubleParityOrderSquare.buildingDoubleParityOrderSquare(size);
		} else if ((size % 2 == 0) && (size % 4 != 0)) { 
			SingleParityOrderSquare singleParityOrderSquare = new SingleParityOrderSquare();
			singleParityOrderSquare.buildSingleParityOrderSquare(size);
		} else if (size % 2 != 0) {
			OddOrderSquare oddOrderSquare = new OddOrderSquare();
			oddOrderSquare.buildOddOrderSquare(size);
		}
	}
}