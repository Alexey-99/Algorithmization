/* Дано натуральное число N. 
 * Написать метод(методы) для формирования массива, элементами которого являются цифры числа N. */

package by.koroza.algorithmization.subroutines;

import java.util.Random;

public class NumberTen {

	public static void main(String[] args) {
		double number = initializationNumber();
		
	}

	private static int initializationNumber() {
		Random rand = new Random();
		int number = 0;
		number =  rand.nextInt();
		return number;
	}
}
