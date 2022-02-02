/*Даны дроби 
 * 
 * P1  P2       Pn
 * - , - , ... ,-   (Pi и Qi - натуральные).
 * Q1  Q2       Qn
 * 
 * Составить программу, которая приводит эти дроби к общему знаменателю и упорядочивает их в порядке возрастания.
 */

package by.koroza.algorithmization.sorting;

import java.util.Random;

public class NumberEight {

	public static void main(String[] args) {
		int lengthArrayPAndQ = arrayLengthInitialization();
		int[] arrayP = new int[lengthArrayPAndQ];
		int[] arrayQ = new int[lengthArrayPAndQ];
		assigningRandomNumbersArray(arrayP);
		printArray(arrayP);
		assigningRandomNumbersArray(arrayQ);
		printArray(arrayQ);
		calculationCommonDenominator(arrayQ);
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
			array[i] = rand.nextInt(10) + 1;
		}
	}
	
	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	private static void calculationCommonDenominator(int[] arrayQ) {
		calculationCommonDivisor(arrayQ);
	}
	
	private static void calculationCommonDivisor(int[] arrayQ) {
		int number = 1;
		boolean flag = true;
		while (flag == true) {
			flag = false;
			for (int i = 0; i < arrayQ.length; i++) {
				if (number % arrayQ[i] != 0) {
					flag = true;
				}
			}
			if (flag == true) {
				number++;
			}
		}
		System.out.println("Множитель: " + number);
	}
	
	
}