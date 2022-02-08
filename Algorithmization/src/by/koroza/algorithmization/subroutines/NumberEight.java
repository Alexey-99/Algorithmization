/* Задан массив D. 
 * Определить следующие суммы: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] + D[5] + D[6]. 
 * Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных 
 * элементов массива с номерами от k до m. 
 */

package by.koroza.algorithmization.subroutines;

import java.util.Random;

public class NumberEight {

	public static void main(String[] args) {
		int length = initializationLengthArray();
		int[] array = new int[length];
		assigningRandomNumbersArray(array);
		calculatingSumThreeElements(array);
	}

	private static int initializationLengthArray() {
		Random rand = new Random();
		int lengthArray = 0;
		int minlengthArray = 4;
		lengthArray = rand.nextInt(20) + minlengthArray;
		return lengthArray;
	}

	private static void assigningRandomNumbersArray(int[] array) {
		Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(20);
		}
	}

	private static void calculatingSumThreeElements(int[] array) {
		int sum = 0;
		printArray(array);
		int indexElementBeginningCalculationSum = initializationIndexElementBeginningCalculationSum(array);
		System.out.println("Индекс элемента начала отсчёта суммы: " + indexElementBeginningCalculationSum);
		for (int i = indexElementBeginningCalculationSum; i < indexElementBeginningCalculationSum + 3; i++) {
			sum += array[i];
		}
		System.out.println("Сумма равна: " + sum);
	}

	private static int initializationIndexElementBeginningCalculationSum(int[] array) {
		Random rand = new Random();
		int indexElementBeginningCalculationSum = 0;
		indexElementBeginningCalculationSum = rand.nextInt(array.length - 4);
		return indexElementBeginningCalculationSum;
	}

	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}