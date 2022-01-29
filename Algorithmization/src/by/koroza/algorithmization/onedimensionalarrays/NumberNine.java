/*В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. 
 * Если таких чисел несколько, то определить наименьшее из них. 
 */

package by.koroza.algorithmization.onedimensionalarrays;

import java.util.Arrays;
import java.util.Random;

public class NumberNine {

	public static void main(String[] args) {
		int length = randIntLength();
		int[] array = new int[length];

		array = randIntArray(array);
		System.out.println("Первоначальный массив чисел: " + Arrays.toString(array));
		array = sort(array);
		findMostFrequentlyOccurringElement(array);
	}

	private static int randIntLength() {
		Random rand = new Random();
		int length = 0;
		while (length == 0) {
			length = rand.nextInt(30);
		}
		return length;
	}

	private static int[] randIntArray(int[] array) {
		Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(50);
		}
		return array;
	}

	private static int[] sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				if (array[i] > array[j]) {
					int tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}
		System.out.println("Сортированный массив чисел: " + Arrays.toString(array));
		return array;
	}

	private static void findMostFrequentlyOccurringElement(int[] array) {
		int countRepetitions = 1;
		int countMaxRepetitions = 0;
		if (array.length > 1) {
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] == array[i + 1]) {
					countRepetitions++;
				} else if (array[i] != array[i + 1]) {
					countRepetitions = 1;
				}
				if (countMaxRepetitions < countRepetitions) {
					countMaxRepetitions = countRepetitions;
				}
			}
		} else if (array.length == 1) {
			countMaxRepetitions = 1;
		}
		numberElementsWithCount(array, countMaxRepetitions);
	}

	private static void numberElementsWithCount(int[] array, int countMaxRepetitions) {
		int counterElementsWithMaximumEqualNumber = 0;
		int[] arrayRepet = new int[array.length];
		int countRepetitions = 1;
		int indexArrayRepet = 0;
		if (array.length > 1) {
			for (int i = 0; i < array.length; i++) {
				if (i < array.length - 1) {
					if (array[i] == array[i + 1]) {
						countRepetitions++;
					} else if (array[i] != array[i + 1]) {
						countRepetitions = 1;
					}
					if (countRepetitions == countMaxRepetitions) {
						arrayRepet[indexArrayRepet] = array[i];
						indexArrayRepet++;
						counterElementsWithMaximumEqualNumber++;
					}
				}
				if ((i == array.length - 1) && (countMaxRepetitions == 1)) {
					arrayRepet[indexArrayRepet] = array[i];
					counterElementsWithMaximumEqualNumber++;
				}
			}
		} else if (array.length == 1) {
			arrayRepet[indexArrayRepet] = array[0];
			counterElementsWithMaximumEqualNumber++;
		}

		minValueInArray(arrayRepet, counterElementsWithMaximumEqualNumber);
	}

	private static void minValueInArray(int[] arrayRepet, int counterElementsWithMaximumEqualNumber) {
		int min = arrayRepet[0];
		System.out.print("Наиболее часто встречаются числа: ");
		for (int i = 0; i < counterElementsWithMaximumEqualNumber; i++) {
			System.out.print(arrayRepet[i] + " ");
			if (arrayRepet[i] < min) {
				min = arrayRepet[i];
			}
		}
		System.out.println();
		System.out.println("Наименьшее число из наиболее часто встречаемых чисел в массиве: " + min);
	}
}