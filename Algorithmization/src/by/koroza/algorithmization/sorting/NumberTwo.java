/* Даны две последовательности a1 <= a2 <= ... <= an и b1 <= b2 <= ... <= bm. 
 * Образовать из них новую последовательность чисел так, чтобы она тоже была неубывающей. 
 * Примечание. Дополнительный массив не использовать. 
 * */

package by.koroza.algorithmization.sorting;

import java.util.Random;

public class NumberTwo {

	public static void main(String[] args) {
		int lengthFirstArray = matrixLengthInitialization();
		int lengthSecondArray = matrixLengthInitialization();
		int[] firstArray = new int[lengthFirstArray + lengthSecondArray];
		fillingFirstArrayWithRandomNumbersAndSortingThem(firstArray, lengthFirstArray);
		int[] secondArray = new int[lengthSecondArray];
		fillingSecondArrayWithRandomNumbersAndSortingThem(secondArray);
		concatenatingFirstAndSecondArrayAndSortingIt(firstArray, secondArray);
	}

	private static void fillingFirstArrayWithRandomNumbersAndSortingThem(int[] firstArray, int lengthFirstArray) {
		System.out.print("Первый массив без сортировки: ");
		assigningRandomNumbersArray(firstArray, lengthFirstArray);
		printArray(firstArray);
		sortElementsArray(firstArray);
		System.out.print("Первый массив c сортировкой: ");
		printArray(firstArray);
	}

	private static void fillingSecondArrayWithRandomNumbersAndSortingThem(int[] secondArray) {
		assigningRandomNumbersArray(secondArray, secondArray.length);
		System.out.print("Второй массив без сортировки: ");
		printArray(secondArray);
		sortElementsArray(secondArray);
		System.out.print("Второй массив с сортировкой: ");
		printArray(secondArray);
	}

	private static void concatenatingFirstAndSecondArrayAndSortingIt(int[] firstArray, int[] secondArray) {
		concatenationFirstAndSecondArrays(firstArray, secondArray);
		System.out.print("Первый массив (после объединения) без сортировки: ");
		printArray(firstArray);
		sortElementsArray(firstArray);
		System.out.print("Первый массив (после объединения) c сортировкой: ");
		printArray(firstArray);
	}

	private static int matrixLengthInitialization() {
		Random rand = new Random();
		int length = 0;
		length = rand.nextInt(20) + 1;
		return length;
	}

	private static void assigningRandomNumbersArray(int[] array, int lengthArray) {
		Random rand = new Random();
		for (int i = 0; i < lengthArray; i++) {
			array[i] = rand.nextInt(10);
		}
	}

	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	private static void sortElementsArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				if (array[i] > array[j]) {
					int tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}
	}

	private static void concatenationFirstAndSecondArrays(int[] firstArray, int[] secondArray) {
		for (int i = 0; i < secondArray.length; i++) {
			firstArray[i] = secondArray[i];
		}
	}
}