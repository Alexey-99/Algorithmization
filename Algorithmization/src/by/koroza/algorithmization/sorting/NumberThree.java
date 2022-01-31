/* Сортировка выбором. 
 * Дана последовательность чисел a1 <= a2 <= ... <= an. 
 * Требуется переставить элементы так, чтобы они были расположены по убыванию. 
 * Для этого в массиве, начиная с первого, выбирается наибольший элемент и ставится на первое место, 
 * а первый - на место наибольшего. 
 * Затем, начиная со второго, эта процедура повторяется. 
 * Написать алгоритм сортировки выбором. */

package by.koroza.algorithmization.sorting;

import java.util.Random;

public class NumberThree {

	public static void main(String[] args) {
		int length = arrayLengthInitialization();
		int[] array = new int[length];
		

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
}