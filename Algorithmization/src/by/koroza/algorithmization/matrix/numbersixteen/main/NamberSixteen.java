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

	private static int matrixLengthInitialization() { 
		int size = 0;
		Scanner scan = new Scanner(System.in);
		boolean flag = false;
		while (flag == false) {
			System.out.println("Введите размер (не менее 3-ёх) магического квадрата ");
			String line = scan.nextLine();
			flag = checkingNumbersInString(line);
			if (flag == true) {
				flag = checkingForPresenceNumberInStringGreaterThanThree(line);
				if (flag == true) {
					size = Integer.parseInt(line);
				}
			}
		}
		scan.close();
		return size;
	}

	private static boolean checkingNumbersInString(String line) {
		boolean flag = true;
		String[] arrayLine = line.split("");
		for (String element : arrayLine) {
			if ((element.equals("1") || element.equals("2")) || (element.equals("3") || element.equals("4"))
					|| (element.equals("5") || element.equals("6"))
					|| (element.equals("7") || element.equals("8") || (element.equals("9") || element.equals("0")))) {
			} else {
				flag = false;
			}
		}
		if (flag == false) {
			System.out.println("Введите, пожалуйста, коректно размер магического квадрата");
		}
		return flag;
	}

	private static boolean checkingForPresenceNumberInStringGreaterThanThree(String line) {
		boolean flag = true;
		int size = Integer.parseInt(line);
		if (size < 3) {
			flag = false;
		}
		System.out.println("Введите, пожалуйста, размер магического квадрата, больше 2");
		return flag;
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