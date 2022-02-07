/* Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми. */

package by.koroza.algorithmization.subroutines;

import java.util.Random;

public class NumberSix {

	public static void main(String[] args) {
		int[] array = new int[3];
		assigningRandomNumbersArray(array);
		checkNumbersAreCoprime(array);
	}

	private static void assigningRandomNumbersArray(int[] array) {
		Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(20) + 1;
		}
	}

	private static void checkNumbersAreCoprime(int[] array) {
		int[] arrayDivisorsElementOne = checkingDivisorsWithoutRemainderElementOne(array);
		int[] arrayDivisorsElementTwo = checkingDivisorsWithoutRemainderElementTwo(array);
		int[] arrayDivisorsElementThree = checkingDivisorsWithoutRemainderElementThree(array);
		int[] concatenationArraysWithDivisors = concatenationArraysWithDivisors(arrayDivisorsElementOne,
				arrayDivisorsElementTwo, arrayDivisorsElementThree);
		sortConcatenationArraysWithDivisors(concatenationArraysWithDivisors);
		printArray(concatenationArraysWithDivisors);
		boolean flag = checkingForRepetitionDivisors(concatenationArraysWithDivisors);
		if (flag == true) {
			System.out.println("Данные числа являются взаимно простыми");
		} else {
			System.out.println("Данные числа не являются взаимно простыми");
		}

	}

	private static int[] checkingDivisorsWithoutRemainderElementOne(int[] array) {
		int length = countingDivisorsWithoutRemainder(array[0]);
		int[] arrayDivisorsElementOne = new int[length];
		fillingArrayDivisorsDivisorsWithoutRemainder(array[0], arrayDivisorsElementOne);
		return arrayDivisorsElementOne;
	}

	private static int[] checkingDivisorsWithoutRemainderElementTwo(int[] array) {
		int length = countingDivisorsWithoutRemainder(array[1]);
		int[] arrayDivisorsElementTwo = new int[length];
		fillingArrayDivisorsDivisorsWithoutRemainder(array[1], arrayDivisorsElementTwo);
		return arrayDivisorsElementTwo;
	}

	private static int[] checkingDivisorsWithoutRemainderElementThree(int[] array) {
		int length = countingDivisorsWithoutRemainder(array[2]);
		int[] arrayDivisorsElementThree = new int[length];
		fillingArrayDivisorsDivisorsWithoutRemainder(array[2], arrayDivisorsElementThree);
		return arrayDivisorsElementThree;
	}

	private static int[] concatenationArraysWithDivisors(int[] arrayDivisorsElementOne, int[] arrayDivisorsElementTwo,
			int[] arrayDivisorsElementThree) {
		int[] array = new int[arrayDivisorsElementOne.length + arrayDivisorsElementTwo.length
				+ arrayDivisorsElementThree.length];
		for (int i = 0; i < array.length; i++) {
			if (i < arrayDivisorsElementOne.length) {
				array[i] = arrayDivisorsElementOne[i];
			} else if (i >= arrayDivisorsElementOne.length
					&& i < arrayDivisorsElementTwo.length + arrayDivisorsElementOne.length) {
				array[i] = arrayDivisorsElementTwo[i - arrayDivisorsElementOne.length];
			} else {
				array[i] = arrayDivisorsElementThree[i
						- (arrayDivisorsElementOne.length + arrayDivisorsElementTwo.length)];
			}
		}
		return array;
	}

	private static int countingDivisorsWithoutRemainder(int element) {
		System.out.println(element);
		int count = 0;
		int divisors = element;
		while (divisors >= -element) {
			if (divisors != 0) {
				if (element % divisors == 0) {
					count++;
				}
			}
			divisors--;
		}
		return count;
	}

	private static void fillingArrayDivisorsDivisorsWithoutRemainder(int element, int[] array) {
		int index = 0;
		int divisors = element;
		while (divisors >= -element) {
			if (divisors != 0) {
				if (element % divisors == 0) {
					array[index] = divisors;
					index++;
				}
			}
			divisors--;
		}
	}

	private static void sortConcatenationArraysWithDivisors(int[] array) {
		int half = array.length / 2;
		while (half > 0) {
			for (int i = 0; i < array.length - half; i++) {
				int j = i;
				while (j >= 0) {
					if (array[j] > array[j + half]) {
						int tmp = array[j];
						array[j] = array[j + half];
						array[j + half] = tmp;
					}
					j--;
				}
			}
			half = half / 2;
		}
	}

	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	private static boolean checkingForRepetitionDivisors(int[] array) {
		boolean flag = true;
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			count = 0;
			for (int j = 0; j < array.length; j++) {
				if (array[i] == array[j]) {
					count++;
				}
			}
			if (count == 3 && (array[i] != 1 && array[i] != -1)) {
				flag = false;
			}
		}
		return flag;
	}
}