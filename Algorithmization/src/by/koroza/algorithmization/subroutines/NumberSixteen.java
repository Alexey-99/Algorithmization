/* Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры. 
 * Определить также, сколько четных цифр в найденной сумме. 
 * Для решения задачи использовать декомпозицию. 
 * */

package by.koroza.algorithmization.subroutines;

import static java.lang.Math.pow;

import java.util.Random;

public class NumberSixteen {

	public static void main(String[] args) {
		int numberN = initializationNumber();
		sumDigitsNumber(numberN);
	}

	private static int initializationNumber() {
		Random rand = new Random();
		int number = 0;
		do {
			number = rand.nextInt(9);
		} while (number < 1);
		return number;
	}

	private static void sumDigitsNumber(int numberN) {
		boolean flag = true;
		int sum = 0;
		int count = 0;
		int minNumber = calculationMinNumber(numberN);
		int maxNumber = calculationMaxNumber(numberN);
		for (int number = minNumber; number <= maxNumber; number++) {
			flag = dividingByDigits(number);
			if (flag == true) {
				sum = sumDigits(number);
				printResultNumber(number, sum);
				count = countEvenDigitsInSum(sum);
				printResultSum(sum, count);
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

	private static boolean dividingByDigits(int number) {
		int remainder = 0;
		boolean flag = true;
		while (number >= 1 && flag == true) {
			remainder = number % 10;
			if (remainder % 2 == 0) {
				flag = false;
			}
			number /= 10;
		}
		return flag;
	}

	private static int sumDigits(int number) {
		int sum = 0;
		int remainder = 0;
		while (number >= 1) {
			remainder = number % 10;
			sum += remainder;
			number /= 10;
		}
		return sum;
	}

	private static int countEvenDigitsInSum(int sum) {
		int count = 0;
		int remainder = 0;
		while (sum >= 1) {
			remainder = sum % 10;
			if (remainder % 2 == 0) {
				count++;
			}
			sum /= 10;
		}
		return count;
	}

	private static void printResultNumber(int number, int sum) {
		System.out.println("В числе " + number + " сумма цифр равна " + sum);
	}

	private static void printResultSum(int sum, int count) {
		System.out.println("В сумме " + sum + " количество чётных цифр равно " + count);
	}

}