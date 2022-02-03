/*Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел. */

package by.koroza.algorithmization.subroutines;

import java.util.Random;

public class NumberTwo {

	public static void main(String[] args) {
		int numberA = assigningRandomNumbers();
		int numberB = assigningRandomNumbers();
		int numberC = assigningRandomNumbers();
		int numberD = assigningRandomNumbers();
		System.out.println("Первое число: " + numberA);
		System.out.println("Второе число: " + numberB);
		System.out.println("Третье число: " + numberC);
		System.out.println("Четвёртое число: " + numberD);
		int[] arrayNumbers = {numberA, numberB, numberC, numberD};
	}
	
	private static int assigningRandomNumbers() {
		int number = 0;
		Random rand = new Random();
		number = rand.nextInt(30) + 1;
		return number;
	}
	
	private static int calculationNOD(int[] arrayNumbers) {
		int minNumber = findMinNumber(int[] arrayNumbers);
		int nod = minNumber;
		boolean flag = true;
		while (flag == true && nod > 0) {
			flag = false;
			if (numberA % nod != 0 || numberB % nod != 0) {
				flag = true;
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
	
}