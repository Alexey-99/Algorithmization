/*Заданы два одномерных массива с различным количеством элементов и натуральное число k. 
 * Объединить их в один массив, включив второй массив между k-м и (k+1)-м элементами первого, 
 * при этом не используя дополнительный массив. */

package by.koroza.algorithmization.sorting;

import java.util.Random;

public class NumberOne {

	public static void main(String[] args) {
		int k = 2;
		int[] array1 = new int[matrixLengthInitialization()];
		int[] array2 = new int[matrixLengthInitialization()];
		assigningRandomNumbersArray(array1);
		assigningRandomNumbersArray(array2);
	}

	private static int matrixLengthInitialization() {
		Random rand = new Random();
		int length = 0;
		length = rand.nextInt(20) + 1;
		return length;
	}
	
	private static void assigningRandomNumbersArray(int[] array) {
		Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(10) + 1;
		}
	}

}