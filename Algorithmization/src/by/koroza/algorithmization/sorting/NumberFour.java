/* Сортировка обменами. 
 * Дана последовательность чисел a1 <= a2 <= ... <= an. 
 * Требуется переставить числа в порядке возрастания. 
 * Для этого сравниваются два соседних числа ai и ai+1. Если ai > ai+1, то делается перестановка. 
 * Так продолжается до тех пор, пока все элементы не станут расположены в порядке возрастания. 
 * Составить алгоритм сортировки, подсчитывая при этом количества перестановок. 
 * */

package by.koroza.algorithmization.sorting;

import java.util.Random;

public class NumberFour {

	public static void main(String[] args) {
		int lenght = arrayLengthInitialization();
		int[] array = new int[lenght];
		System.out.print("Массив не сортированный: ");
		assigningRandomNumbersArray(array);
		printArray(array);
		System.out.print("Массив сортированный по возростанию: ");
		sortingExchangesInAscendingOrder(array);
		System.out.print("Массив сортированный по убыванию: ");
		sortingExchangesInDescendingOrder(array);
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

	private static void sortingExchangesInAscendingOrder(int[] array) { 
		boolean flag = true;
		int counterPermutation = 0;
		while (flag) {
			flag = false;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					int tmp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = tmp;
					flag = true;
					counterPermutation++;
				}
			}
		}
		printArray(array);
		System.out.println("Количество перестановок: " + counterPermutation);
	}

	private static void sortingExchangesInDescendingOrder(int[] array) {
		boolean flag = true;
		int counterPermutation = 0;
		while (flag) {
			flag = false;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] < array[i + 1]) {
					int tmp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = tmp;
					flag = true;
					counterPermutation++;
				}
			}
		}
		printArray(array);
		System.out.println("Количество перестановок: " + counterPermutation);
	}

	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}