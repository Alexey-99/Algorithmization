/* Заданы два одномерных массива с различным количеством элементов и натуральное число k. 
 * Объединить их в один массив, включив второй массив между k-м и (k+1)-м элементами первого, 
 * при этом не используя дополнительный массив. */

package by.koroza.algorithmization.sorting;

import java.util.Arrays;
import java.util.Random;

public class NumberOne {

	public static void main(String[] args) {
		int lengthFirstArray = matrixLengthInitialization();
		int numberK = findingRandomNumber(lengthFirstArray);
		int lengthSecondArray = matrixLengthInitialization();
		int[] firstArray = new int[lengthFirstArray + lengthSecondArray];
		int[] secondArray = new int[lengthSecondArray];
		assigningRandomNumbersArray(firstArray, lengthFirstArray);
		System.out.println(Arrays.toString(firstArray));
		assigningRandomNumbersArray(secondArray, lengthSecondArray);
		System.out.println(Arrays.toString(secondArray));
		unionArrays(firstArray, secondArray, numberK);
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
			array[i] = rand.nextInt(10) + 1;
		}
	}

	private static int findingRandomNumber(int lengthFirstArray) {
		Random rand = new Random();
		int k = 0;
		do {
			k = rand.nextInt(lengthFirstArray);
		} while (k > lengthFirstArray - 2);
		System.out.println(k + " ");
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
		System.out.println(Arrays.toString(firstArray));
	}
}