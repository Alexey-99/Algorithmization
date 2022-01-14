/* Задана последовательность N вещественных чисел. 
 * Вычислить сумму чисел, порядковые номера которых являются простыми числами.
 */

package onedimensionalarrays;

import java.util.Arrays;
import java.util.Random;

public class NumberSix {

	public static void main(String[] args) {
		Random rand = new Random();
		int length = rand.nextInt(100);
		double[] array = new double[length];
		double sum = 0;
		int countWithoutTrace = 0;

		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(50);
		}

		for (int i = 2; i < array.length; i++) {
			countWithoutTrace = 0;
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					countWithoutTrace++;
				}
			}
			if (countWithoutTrace == 2) {
				sum += array[i];
			}
		}
		System.out.println(Arrays.toString(array));
		System.out.println("Сумма чисел, порядковые номера которых являются простыми числами равняется: " + sum);
	}
}