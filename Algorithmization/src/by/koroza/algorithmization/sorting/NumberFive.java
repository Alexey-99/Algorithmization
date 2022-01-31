/* Сортировка вставками. 
 * Дана последовательность чисел a1, a2, ... , an. Требуется переставить числа в порядке возрастания. 
 * Делается это следующим образом. Пусть a1, a2, ... , an - упорядоченная последовательность, т. е. a1 <= a2 <= ... <= an. 
 * Берется следующее число ai+1 и вставляется в последовательность так, чтобы новая последовательность была тоже возрастающей. 
 * Процесс производится до тех пор, пока все элементы от i+1 до n не будут перебраны. 
 * Примечание. Место помещения очередного элемента в отсортированную часть производить с помощью двоичного поиска. 
 * Двоичный поиск оформить в виде отдельной функции. 
 * */

package by.koroza.algorithmization.sorting;

import java.util.Random;

public class NumberFive {

	public static void main(String[] args) {
		int length = arrayLengthInitialization();
		int[] array = new int[length];
		System.out.print("Массив не сортированный: ");
		assigningRandomNumbersArray(array);
		printArray(array);
		System.out.print("Массив сортированный по возростанию: ");
		insertionSortAscending(array);
		printArray(array);
	}

	private static int arrayLengthInitialization() {
		Random rand = new Random();
		int length = 0;
		length = rand.nextInt(20) + 1;
		return length;
	}

	private static void assigningRandomNumbersArray(int[] array) {
		Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(10);
		}
	}

	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	private static void insertionSortAscending(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int value = array[i];
			int j = i - 1;
			for (; j >= 0; j--) {
				if (value < array[j]) {
					array[j + 1] = array[j];
				} else {
					break;
				}
			}
			array[j + 1] = value;
		}
	}
}