/*Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух натуральных чисел: 
 *             A * B
 * НОК(A,B) = -------
 *            НОД(A,B)
 */

package by.koroza.algorithmization.subroutines;

import java.util.Random;

public class NumberOne {

	public static void main(String[] args) {
		int numberA = assigningRandomNumbersArray();
		int numberB = assigningRandomNumbersArray();
	}

	private static int assigningRandomNumbersArray() {
		int number = 0;
		Random rand = new Random();
		number = rand.nextInt(30) + 1;
		return number;
	}

}