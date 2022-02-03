/*Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух натуральных чисел: 
 *             A * B
 * НОК(A,B) = -------
 *            НОД(A,B)
 */

package by.koroza.algorithmization.subroutines;

import java.util.Random;

public class NumberOne {

	public static void main(String[] args) {
		int numberA = assigningRandomNumbers();
		int numberB = assigningRandomNumbers();
		calculationNOK(numberA, numberB);
	}

	private static int assigningRandomNumbers() {
		int number = 0;
		Random rand = new Random();
		number = rand.nextInt(30) + 1;
		return number;
	}

	private static void calculationNOK(int numberA, int numberB) {
		int nod = calculationNOD(numberA, numberB);
		int nok = (numberA * numberB) / nod;
		System.out.println("HOK = " + nok);
	}

	private static int calculationNOD(int numberA, int numberB) {
		System.out.println(numberA);
		System.out.println(numberB);
		int minNumber = findMinNumber(numberA, numberB);
		int nod = minNumber;
		boolean flag = true;
		while (flag == true && nod > 0) {
			flag = false;
			if (numberA % nod != 0 || numberB % nod != 0) {
				flag = true;
			}
			if (flag == true) {
				nod--;
			}
		}

		System.out.println("НОД = " + nod);
		return nod;
	}

	private static int findMinNumber(int numberA, int numberB) {
		int min = numberA;
		if (min > numberB) {
			min = numberB;
		}
		return min;
	}

}