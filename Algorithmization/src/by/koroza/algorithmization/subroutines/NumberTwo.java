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
		
	}
	
	private static int assigningRandomNumbers() {
		int number = 0;
		Random rand = new Random();
		number = rand.nextInt(30) + 1;
		return number;
	}
	
}