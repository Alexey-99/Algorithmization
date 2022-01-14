/* Дан массив действительных чисел, размерность которого N. 
 * Подсчитать, сколько в нем отрицательных, положительных и нулевых элементов.
 */

package onedimensionalarrays;

import java.util.Arrays;
import java.util.Random;

public class NumberThree {

	public static void main(String[] args) {
		StringBuilder build = new StringBuilder();
		Random rand = new Random();
		int size = 100;
		double[] array = new double[size];
		int countNegativeNumbers = 0;
		int countZeroValues = 0;
		int countPositiveNumbers = 0;

		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(100) - 50;
		}

		for (Double element : array) {
			if (element < 0) {
				countNegativeNumbers++;
			} else if (element == 0) {
				countZeroValues++;
			} else if (element > 0) {
				countPositiveNumbers++;
			}
		}

		System.out.println(Arrays.toString(array));
		build.append("В массиве ").append(countNegativeNumbers).append(" отрицательных чисел.").append("\n");
		build.append("В массиве ").append(countZeroValues).append(" чисел равных нулю.").append("\n");
		build.append("В массиве ").append(countPositiveNumbers).append(" положительных чисел.");
		System.out.println(build);
	}
}