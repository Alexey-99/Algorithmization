/* Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры. 
 * Определить также, сколько четных цифр в найденной сумме. 
 * Для решения задачи использовать декомпозицию. 
 * */

package by.koroza.algorithmization.subroutines;

import java.util.Random;

public class NumberSixty {

	public static void main(String[] args) {
		int numberN = initializationNumber();
		sumDigitsNumber(numberN);
	}
	
	private static int initializationNumber() {
		Random rand = new Random();
		int number = 0;
		do {
			number = rand.nextInt(5);
		} while (number < 1);
		return number;
	}
	
	private static void sumDigitsNumber(int numberN) {
		
	}

}