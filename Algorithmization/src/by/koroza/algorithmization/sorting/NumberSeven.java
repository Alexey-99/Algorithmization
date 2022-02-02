/* Пусть даны две неубывающие последовательности действительных чисел a1 <= a2 <= ... <= an и b1 <= b2 <= ... <= bm.
 * Требуется указать те места, на которые нужно вставлять элементы последовательности b1 <= b2 <= ... <= bm в первую последовательность так, 
 * чтобы новая последовательность оставалась возрастающей. 
*/

package by.koroza.algorithmization.sorting;

import java.util.Random;

public class NumberSeven {

	public static void main(String[] args) {
		int lengthfirstArray = arrayLengthInitialization();
		int lengthSecondArray = arrayLengthInitialization();
		double[] firstArray = new double[lengthfirstArray];
		assigningRandomNumbersArray(firstArray, lengthfirstArray);
		sortArray(firstArray);
		System.out.print("Первый массив: ");
		printArray(firstArray);
		double[] secondArray = new double[lengthSecondArray];
		assigningRandomNumbersArray(secondArray, lengthSecondArray);
		sortArray(secondArray);
		System.out.print("Второй массив: ");
		printArray(secondArray);
		System.out.print("Массив объединяющий первый и второй массив: ");
		unionArrays(firstArray, secondArray);
	}

	private static int arrayLengthInitialization() {
		Random rand = new Random();
		int length = 0;
		length = rand.nextInt(20) + 1;
		return length;
	}

	private static void assigningRandomNumbersArray(double[] array, int lengthfirstArray) {
		Random rand = new Random();
		for (int i = 0; i < lengthfirstArray; i++) {
			array[i] = rand.nextInt(10) + 1;
		}
	}

	private static void sortArray(double[] array) {
		int gar = array.length / 2;
		while (gar > 0) {
			for (int i = 0; i < array.length - gar; i++) {
				int j = i;
				while (j >= 0) {
					if (array[j] > array[j + gar]) {
						double tmp = array[j];
						array[j] = array[j + gar];
						array[j + gar] = tmp;
					}
					j--;
				}
			}
			gar = gar / 2;
		}
	}

	private static void printArray(double[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	private static void unionArrays(double[] firstArray, double[] secondArray) {
		double[] arrayThree = new double[firstArray.length + secondArray.length];
		transferElementsArrayAndSortHim(firstArray, arrayThree);
		unionArraysTwoArrays(arrayThree, secondArray);
		printArray(arrayThree);
	}

	private static void unionArraysTwoArrays(double[] firstArray, double[] secondArray) {
		double numberFMinusOne = 0;
		for (int i = 0; i < secondArray.length; i++) {
			for (int j = 0; j < firstArray.length - 1; j++) {
				if ((secondArray[i] >= firstArray[j] && secondArray[i] < firstArray[j + 1])
						|| (secondArray[i] >= firstArray[firstArray.length - 1] && j == firstArray.length - 2)) {
					for (int f = j; f >= 0; f--) {
						if (f > 0) {
							if (f == j) {
								numberFMinusOne = firstArray[f - 1];
								firstArray[f - 1] = firstArray[f];
								firstArray[j] = secondArray[i];
							} else if (f < j) {
								double tmp = numberFMinusOne;
								numberFMinusOne = firstArray[f - 1];
								firstArray[f - 1] = tmp;
							}
						}
					}
				}
			}
		}
	}
	
	private static void transferElementsArrayAndSortHim(double[] firstArray, double[] arrayThree) {
		for (int i = 0; i < firstArray.length; i++) {
			arrayThree[i] = firstArray[i];
		}
		sortArray(arrayThree);
	}
}