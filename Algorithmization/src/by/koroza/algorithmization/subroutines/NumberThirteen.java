/* Два простых числа называются «близнецами», если они отличаются друг от друга на 2 
 * (например, 41 и 43). Найти и напечатать все пары «близнецов» из отрезка [n,2n], 
 * где n - заданное натуральное число больше 2. 
 * Для решения задачи использовать декомпозицию. 
 * */

package by.koroza.algorithmization.subroutines;

import java.util.Random;

public class NumberThirteen {

	public static void main(String[] args) {
		int minNumber = initializationNumber();
		int maxNumber = 2 * minNumber;
		findingAndPrintNumbersTwins(minNumber, maxNumber);
	}

	private static int initializationNumber() {
		Random rand = new Random();
		int number = 0;
		do {
			number = rand.nextInt(50);
		} while (number <= 2);
		return number;
	}
	
	private static void findingAndPrintNumbersTwins(int minNumber, int maxNumber) {
		for (int i = minNumber; i <= maxNumber - 2; i++) {
			System.out.println(i + ", " + (i + 2));
		}
	}
}