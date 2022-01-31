/* Заданы два одномерных массива с различным количеством элементов и натуральное число k. 
 * Объединить их в один массив, включив второй массив между k-м и (k+1)-м элементами первого, 
 * при этом не используя дополнительный массив. */

package by.koroza.algorithmization.sorting;

import java.util.Random;

public class NumberOne {

	public static void main(String[] args) {
		int lengthFirstArray = arrayLengthInitialization();
		int numberK = findingRandomNumber(lengthFirstArray);
		System.out.println("Индекс элемента после которого будет вставляться второй массив чисел: " + numberK);
		int lengthSecondArray = arrayLengthInitialization();
		int[] firstArray = new int[lengthFirstArray + lengthSecondArray];
		int[] secondArray = new int[lengthSecondArray];
		assigningRandomNumbersArray(firstArray, lengthFirstArray);
		System.out.print("Первый массив чисел: ");
		printArray(firstArray);
		assigningRandomNumbersArray(secondArray, lengthSecondArray);
		System.out.print("Второй массив чисел: ");
		printArray(secondArray);
		unionArrays(firstArray, secondArray, numberK);
		System.out.print("Массив в котором объединены первый и второй массив: ");
		printArray(firstArray);
	}

	private static int arrayLengthInitialization() {
		Random rand = new Random();
		int length = 0;
		length = rand.nextInt(20) + 1;
		return length;
	}

	private static void assigningRandomNumbersArray(int[] array, int lengthArray) {
		Random rand = new Random();
		for (int i = 0; i < lengthArray; i++) {
			array[i] = rand.nextInt(10) + 1;
		}
	}

	private static int findingRandomNumber(int lengthFirstArray) {
		Random rand = new Random();
		int k = 0;
		do {
			k = rand.nextInt(lengthFirstArray);
		} while (k > lengthFirstArray - 2);
		return k;
	}

	private static void unionArrays(int[] firstArray, int[] secondArray, int numberK) {
		int i = 0;
		for (i = 0; i < firstArray.length; i++) {
			if (i == numberK + 1) {
				for (int j = 0; j < secondArray.length; j++) {
					for (int f = firstArray.length - secondArray.length - 1 + j; f >= numberK + 1 + j; f--) {
						int tmp = firstArray[f];
						firstArray[f] = firstArray[f + 1];
						firstArray[f + 1] = tmp;
					}
					firstArray[i + j] = secondArray[j];
					if (j == secondArray.length - 1) {
						i += j;
					}
				}
			}
		}
	}
	
	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}