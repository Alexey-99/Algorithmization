/* Даны натуральные числа К и N. 
 * Написать метод(методы) формирования массива А, элементами которого являются числа, 
 * сумма цифр которых равна К и которые не большее N. 
 * */

package by.koroza.algorithmization.subroutines;

import java.util.Random;

public class NumberTwelve {

	public static void main(String[] args) {
		int numberK = initializationNumberK();
		int numberN = initializationNumberN(numberK);
		System.out.println("Число K: " + numberK);
		System.out.println("Число N: " + numberN);
		arrayCreation(numberN, numberK);
	}

	private static int initializationNumberK() {
		Random rand = new Random();
		int number = 0;
		do {
			number = rand.nextInt(50);
		} while (number < 0);
		return number;
	}

	private static int initializationNumberN(int numberK) {
		Random rand = new Random();
		int number = 0;
		do {
			number = rand.nextInt(numberK);
		} while (number < 0);
		return number;
	}

	private static void arrayCreation(int numberN, int numberK) {
		Random rand = new Random();
		int[] array = new int[numberK];
		int i = 0;
		int sum = 0;
		int number = 0;
		while (sum < numberK) {
			number = rand.nextInt(numberN - 1) + 1;
			if ((number + sum <= numberK)) {
				array[i] = number;
				sum += number;
				i++;
			}
		}
		printArray(array, i);
	}
	
	private static void printArray(int[] array, int i) {
		System.out.print("Массив удовлетворяющий условие имеет вид: ");
		for (int j = 0; j < i; j++) {
			System.out.print(array[j] + " ");
		}
	}
}