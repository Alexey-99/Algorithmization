/* Составить программу, которая в массиве A[N] находит второе по величине число 
 * (вывести на печать число, которое меньше максимального элемента массива, но больше всех других элементов). 
 */

package by.koroza.algorithmization.subroutines;

import java.util.Random;

public class NumberFive {

	public static void main(String[] args) {
		int lengthArray = initializationLengthArray();
		int[] array = new int[lengthArray];
		assigningRandomNumbersArray(array);
		findingSecondLargestNumber(array);

	}

	private static int initializationLengthArray() {
		Random rand = new Random();
		int lengthArray = 0;
		lengthArray = rand.nextInt(10) + 1;
		return lengthArray;
	}

	private static void assigningRandomNumbersArray(int[] array) {
		Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(20);
		}
	}

	private static void findingSecondLargestNumber(int[] array) {
		printArray(array);
		int maxNumber = findingMaximumNumberArray(array);
		sortArray(array);
		printArray(array);

	}

	private static int findingMaximumNumberArray(int[] array) {
		int maxNumber = array[0];
		for (int i = 0; i < array.length; i++) {
			if (maxNumber < array[i]) {
				maxNumber = array[i];
			}
		}
		System.out.println(maxNumber);
		return maxNumber;
	}

	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	private static void sortArray(int[] array) {
		int half = array.length / 2;
		while (half > 0) {
			for (int i = 0; i < array.length - half; i++) {
				int j = i;
				while (j >= 0) {
					if (array[j] < array[j + half]) {
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

}