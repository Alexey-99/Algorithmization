/* Дано натуральное число N. 
 * Написать метод(методы) для формирования массива, элементами которого являются цифры числа N. 
 * */

package by.koroza.algorithmization.subroutines;

import java.util.Random;

public class NumberTen {

	public static void main(String[] args) {
		int number = initializationNumber();
		System.out.println(number);
		formingArrayWithElementsDigitsNumberAndPrintHim(number);
	}

	private static int initializationNumber() {
		Random rand = new Random();
		int number = 0;
		do {
			number = rand.nextInt() + 1235;
		} while (number < 0);
		return number;
	}
	
	private static void formingArrayWithElementsDigitsNumberAndPrintHim(int number) {
		int lengthArray = countingNumberDigits(number);
		int[] array = new int[lengthArray];
		for (int i = array.length - 1; i >= 0; i--) {
			int remainder = number % 10;
			array[i] = remainder;
			number /= 10; 
			}
		printArray(array);
		}
	
	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	private static int countingNumberDigits(int number) {
		int count = 0;
		while(number >= 10) {
			int mod = number / 10;
			number = mod;
			count++;
		}
		return count + 1;
	}
}