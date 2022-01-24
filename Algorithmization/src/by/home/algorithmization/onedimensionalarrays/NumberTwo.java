/* Дана последовательность действительных чисел а1 ,а2 ,..., ап. 
 * Заменить все ее члены, большие данного Z, этим числом. 
 * Подсчитать количество замен.
 */

package by.home.algorithmization.onedimensionalarrays;

import java.util.Arrays;
import java.util.Random;

public class NumberTwo {

	public static void main(String[] args) {
		double[] array = new double[20];
		Random rand = new Random();
		int countChange = 0;

		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextDouble() * 10;
		}
		System.out.println(Arrays.toString(array));

		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				if (array[i] > array[j]) {
					double tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
					countChange++;
				}
			}
		}
		System.out.println(Arrays.toString(array));
		System.out.println("Замен произошло: " + countChange);
	}
}