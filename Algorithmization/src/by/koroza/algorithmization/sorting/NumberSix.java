 /* Сортировка Шелла. 
  * Дан массив n действительных чисел. 
  * Требуется упорядочить его по возрастанию. 
  * Делается это следующим образом: сравниваются два соседних элемента ai и ai+1. 
  * Если ai <= ai+1, то продвигаются на один элемент вперед. Если ai > ai+1, то производится перестановка и сдвигаются на один элемент назад.
  * Составить алгоритм этой сортировки.*/

package by.koroza.algorithmization.sorting;

import java.util.Random;

public class NumberSix {

	public static void main(String[] args) {
		int length = arrayLengthInitialization();
		double[] array = new double[length];
		System.out.print("Массив не сортированный: ");
		assigningRandomNumbersArray(array);
		printArray(array);
		
	}

	private static int arrayLengthInitialization() {
		Random rand = new Random();
		int length = 0;
		length = rand.nextInt(20) + 1;
		return length;
	}
	
	private static void assigningRandomNumbersArray(double[] array) {
		Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(10);
		}
	}
	
	private static void printArray(double[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	private static void shellSorting(double[] array) {
		for (int i = 0; i < array.length; i++) {
			
		}
	}
}