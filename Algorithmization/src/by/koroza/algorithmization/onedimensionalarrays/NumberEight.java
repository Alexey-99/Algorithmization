/* Дана последовательность целых чисел a1, a2 ,,, an. 
 * Образовать новую последовательность, выбросив из исходной те члены, которые равны min(a1, a2 ,,, an). 
 */

package by.koroza.algorithmization.onedimensionalarrays;

import java.util.Arrays;
import java.util.Random;

public class NumberEight {

	public static void main(String[] args) {
		int length = creatingLengthArray();
		int[] array = new int[length];
		array = fillingArrayRandomNumbers(array);
		creatingNewArrayWithoutMinValueAndPrintArrayAndMinValueAndQuantityAndArrayNew(array);
	}

	private static int creatingLengthArray() {
		Random rand = new Random();
		int length = rand.nextInt(100);
		return length;
	}

	private static int[] fillingArrayRandomNumbers(int[] array) {
		Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(50);
		}
		return array;
	}

	private static void creatingNewArrayWithoutMinValueAndPrintArrayAndMinValueAndQuantityAndArrayNew(int[] array) {
		int min = findMin(array);
		int count = countMinNumbers(array);
		int index = 0;
		int[] arrayNew = new int[array.length - count];
		for (int element : array) {
			if (element != min) {
				arrayNew[index] = element;
				index++;
			}
		}
		printArrayAndMinValueAndQuantityAndArrayNew(array, min, count, arrayNew);
	}

	private static int findMin(int[] array) {
		int min = array[0];
		for (int i = 0; i < array.length; i++) {
			if (min > array[i]) {
				min = array[i];
			}
		}
		return min;
	}

	private static int countMinNumbers(int[] array) {
		int count = 0;
		int min = findMin(array);
		for (int i = 0; i < array.length; i++) {
			if (array[i] == min) {
				count++;
			}
		}
		return count;
	}

	private static void printArrayAndMinValueAndQuantityAndArrayNew(int[] array, int min, int count, int[] arrayNew) {
		StringBuilder build = new StringBuilder();
		build.append("Минимальное значение в массиве: ").append(min).append(".").append("\n");
		build.append("Минимальное значение в массива встречается ").append(count).append(" раз.");
		System.out.println("Массив чисел первоначальный: " + Arrays.toString(array));
		System.out.println("Длинна первоначального массива равна: " + array.length);
		System.out.println(build);
		System.out.println("Массив чисел без минимального значения : " + Arrays.toString(arrayNew));
		System.out.println("Длинна массива чисел без минимального значения : " + arrayNew.length);
	}
}