/* Пусть даны две неубывающие последовательности действительных чисел a1 <= a2 <= ... <= an и b1 <= b2 <= ... <= bm.
 * Требуется указать те места, на которые нужно вставлять элементы последовательности b1 <= b2 <= ... <= bm в первую последовательность так, 
 * чтобы новая последовательность оставалась возрастающей. 
*/

package by.koroza.algorithmization.sorting;

import java.util.Random;

public class NumberSeven {

	public static void main(String[] args) {
		int lengthfirstArray = arrayLengthInitialization();
		int lengthSecondArray = arrayLengthInitialization();
		double[] firstArray = new double[lengthfirstArray + lengthSecondArray];
		assigningRandomNumbersArray(firstArray, lengthfirstArray);
		double[] secondArray = new double[lengthSecondArray];
		
	}
	
	private static int arrayLengthInitialization() {
		Random rand = new Random();
		int length = 0;
		length = rand.nextInt(20) + 1;
		return length;
	}
	
	private static void assigningRandomNumbersArray(double[] array, int lengthfirstArray) {
		Random rand = new Random();
		for (int i = 0; i < lengthfirstArray; i++) {
			array[i] = rand.nextInt(10);
		}
	}
}