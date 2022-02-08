/*Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр. */

package by.koroza.algorithmization.subroutines;

import java.util.Random;

public class NumberEleven {

	public static void main(String[] args) {
		int numberOne = initializationNumber();
		int numberTwo = initializationNumber();
		System.out.println("Первое число: " + numberOne);
		System.out.println("Второе число: " + numberTwo);
		maximumNumberDigits(numberOne, numberTwo);
	}

	private static void maximumNumberDigits(int numberOne, int numberTwo) {
		int countDigitsOne = countingNumberDigits(numberOne);
		int countDigitsTwo = countingNumberDigits(numberTwo);
		printResult(countDigitsOne, countDigitsTwo, numberOne, numberTwo);
	}

	private static void printResult(int countDigitsOne, int countDigitsTwo, int numberOne, int numberTwo) {
		if (countDigitsOne > countDigitsTwo) {
			StringBuilder build = new StringBuilder();
			build.append("В числе ").append(numberOne).append(" больше цифр, чем в числе ").append(numberTwo);
			build.append(", так как в числе ").append(numberOne).append(" количество цифр ").append(countDigitsOne)
					.append(", а в числе ");
			build.append(numberTwo).append(" количество цифр ").append(countDigitsTwo);
			System.out.println(build);
		} else if (countDigitsTwo > countDigitsOne) {
			StringBuilder build = new StringBuilder();
			build.append("В числе ").append(numberTwo).append(" больше цифр, чем в числе ").append(numberOne);
			build.append(", так как в числе ").append(numberTwo).append(" количество цифр ").append(countDigitsTwo)
					.append(", а в числе ");
			build.append(numberOne).append(" количество цифр ").append(countDigitsOne);
			System.out.println(build);
		} else if (countDigitsOne == countDigitsTwo) {
			StringBuilder build = new StringBuilder();
			build.append("В числах ").append(numberOne).append(" и числе ").append(numberTwo)
					.append(" одинаковое количество цифр");
			build.append(", так как в числе ").append(numberOne).append(" количество цифр ").append(countDigitsOne)
					.append(", и в числе ");
			build.append(numberTwo).append(" количество цифр ").append(countDigitsTwo);
			System.out.println(build);
		}
	}

	private static int initializationNumber() {
		Random rand = new Random();
		int number = 0;
		do {
			number = rand.nextInt();
		} while (number < 0);
		return number;
	}

	private static int countingNumberDigits(int number) {
		int count = 1;
		while (number >= 10) {
			number = number / 10;

			count++;
		}
		return count;
	}
}