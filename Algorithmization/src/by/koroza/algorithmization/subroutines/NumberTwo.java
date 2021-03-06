/*Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел. */

package by.koroza.algorithmization.subroutines;

import java.util.Random;

public class NumberTwo {

	public static void main(String[] args) {
		int[] arrayNumbers = new int[4];
		assigningRandomNumbers(arrayNumbers);
		printArray(arrayNumbers);
		calculationNOD(arrayNumbers);
	}

	private static void assigningRandomNumbers(int[] arrayNumbers) {
		Random rand = new Random();
		for (int i = 0; i < arrayNumbers.length; i++) {
			arrayNumbers[i] = rand.nextInt(1000) + 1;
		}
	}

	private static int calculationNOD(int[] arrayNumbers) {
		int minNumber = findMinNumber(arrayNumbers);
		int nod = minNumber;

		boolean flag = true;
		while (flag == true && nod > 0) {
			flag = false;
			for (int i = 0; i < arrayNumbers.length; i++) {
				if (arrayNumbers[i] % nod != 0) {
					flag = true;
				}
			}
			if (flag == true) {
				nod--;
			}
		}
		System.out.println("НОД = " + nod);
		return nod;
	}

	private static int findMinNumber(int[] arrayNumbers) {
		int min = arrayNumbers[0];
		for (int i = 0; i < arrayNumbers.length; i++) {
			if (min > arrayNumbers[i]) {
				min = arrayNumbers[i];
			}
		}
		return min;
	}
	
	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}