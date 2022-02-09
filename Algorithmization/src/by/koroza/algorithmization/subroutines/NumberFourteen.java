/* Натуральное число, в записи которого n цифр, 
 * называется числом Армстронга, если сумма его цифр, возведенная в степень n, равна самому числу. 
 * Найти все числа Армстронга от 1 до k. Для решения задачи использовать декомпозицию.
 * */

package by.koroza.algorithmization.subroutines;

import java.util.Random;

public class NumberFourteen {

	public static void main(String[] args) {
		int numberK = initializationNumber();
		System.out.println("Числа Армстронга от " + 1 + " до " + numberK);
		findArmstrongNumbers(numberK);
	}

	private static int initializationNumber() {
		Random rand = new Random();
		int number = 0;
		do {
			number = rand.nextInt(10000);
		} while (number < 1);
		return number;
	}

	private static void findArmstrongNumbers(int numberK) {
		for (int i = 1; i <= numberK; i++) {
			int[] arrayDigits = split(i);
			int sum = sum(arrayDigits);
			double sumPow = raisingPower(sum, arrayDigits);
			printResult(sumPow, i, arrayDigits);
		}
	}

	private static int[] split(int number) {
		int numberN = countingDigitsInNumber(number);
		int[] arrayDigits = new int[numberN];
		for (int i = arrayDigits.length - 1; i >= 0; i--) {
			int remainder = number % 10;
			arrayDigits[i] = remainder;
			number /= 10;
		}
		return arrayDigits;
	}

	private static int countingDigitsInNumber(int number) {
		int count = 1;
		while (number >= 10) {
			number /= 10;
			count++;
		}
		return count;
	}

	private static int sum(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}

	private static double raisingPower(int sum, int[] array) {
		double sumPow = Math.pow(sum, array.length);
		return sumPow;
	}

	private static void printResult(double sumPow, int number, int[] array) {
		if (sumPow == number) {
			StringBuilder build = new StringBuilder();
			build.append("Число ").append(number);
			build.append(" является числом Армстронга, так как сумма его цифр, возведенная в степень ");
			build.append(array.length).append(" (количество цифр в числе) равняется самому числу ").append(number);
			System.out.println(build);
		}
	}
}