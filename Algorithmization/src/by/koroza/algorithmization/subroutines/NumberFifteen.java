/* Найти все натуральные n-значные числа, 
 * цифры в которых образуют строго возрастающую последовательность (например, 1234, 5789). 
 * Для решения задачи использовать декомпозицию. 
 * */

package by.koroza.algorithmization.subroutines;

import java.util.Random;
import static java.lang.Math.pow;

public class NumberFifteen {

	public static void main(String[] args) {
		int numberN = initializationNumber();
		findAscendingSequence(numberN);
	}

	private static int initializationNumber() {
		Random rand = new Random();
		int number = 0;
		do {
			number = rand.nextInt(9);
		} while (number < 2);
		return number;
	}

	private static void findAscendingSequence(int numberN) {
		StringBuilder build = new StringBuilder();
		boolean flag = true;
		int minNumber = calculationMinNumber(numberN);
		int maxNumber = calculationMaxNumber(numberN);
		build.append("Натуральные ").append(numberN);
		build.append("-значные числа с строго возрастающей последовательностью цифр (от ");
		build.append(minNumber).append(" до ").append(maxNumber).append("):");
		System.out.println(build);
		for (int number = minNumber; number <= maxNumber; number++) {
			flag = checkNumber(number);
			if (flag == true) {
				System.out.print(number + " ");
			}
		}
	}

	private static int calculationMinNumber(int numberN) {
		int minNumber = (int) pow(10, numberN - 1);
		return minNumber;
	}

	private static int calculationMaxNumber(int numberN) {
		int maxNumber = (int) pow(10, numberN) - 1;
		return maxNumber;
	}

	private static boolean checkNumber(int number) {
		boolean flag = dividingByDigits(number);
		return flag;
	}

	private static boolean dividingByDigits(int number) {
		int count = 0;
		int remainderOld = 0;
		int remainderNew = 0;
		boolean flag = true;
		while (number >= 1 && flag == true) {
			if (count == 0) {
				remainderOld = number % 10;
			} else if (count > 0) {
				remainderNew = number % 10;
				if (remainderNew != remainderOld - 1) {
					flag = false;
				} else {
					remainderOld = remainderNew;
					remainderNew = 0;
				}
			}
			number /= 10;
			count++;
		}
		return flag;
	}
}