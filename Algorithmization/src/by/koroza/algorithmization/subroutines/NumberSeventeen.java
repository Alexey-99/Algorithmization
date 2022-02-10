/* Из заданного числа вычли сумму его цифр. 
 * Из результата вновь вычли сумму его цифр и т.д. 
 * Сколько таких действий надо произвести, чтобы получился нуль? 
 * Для решения задачи использовать декомпозицию. */

package by.koroza.algorithmization.subroutines;

import java.util.Random;

public class NumberSeventeen {

	public static void main(String[] args) {
		int number = initializationNumber();
		countSubtractionSumDigits(number);
	}

	private static int initializationNumber() {
		Random rand = new Random();
		int number = 0;
		do {
			number = rand.nextInt(10000);
		} while (number < 1);
		return number;
	}
	
	private static void countSubtractionSumDigits(int number) {
		int count = 0;
		int sum = 0;
		System.out.print("С числом " + number);
		while (number > 0) {
			sum = sum(number);
			number -= sum;
			count++;
		}
		System.out.print(" произведено " + count + " операций");
	}
	
	private static int sum(int number) {
		int remainder = 0;
		int sum = 0;
		while (number >= 1) {
			remainder = number % 10;
			sum += remainder;
			number /= 10;
		}
		return sum;
	}
}