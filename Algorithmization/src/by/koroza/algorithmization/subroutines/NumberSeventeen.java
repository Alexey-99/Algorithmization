/* Из заданного числа вычли сумму его цифр. 
 * Из результата вновь вычли сумму его цифр и т.д. 
 * Сколько таких действий надо произвести, чтобы получился нуль? 
 * Для решения задачи использовать декомпозицию. */

package by.koroza.algorithmization.subroutines;

import java.util.Random;

public class NumberSeventeen {

	public static void main(String[] args) {
		int number = initializationNumber();
		
	}

	private static int initializationNumber() {
		Random rand = new Random();
		int number = 0;
		do {
			number = rand.nextInt(50);
		} while (number < 1);
		return number;
	}
}
