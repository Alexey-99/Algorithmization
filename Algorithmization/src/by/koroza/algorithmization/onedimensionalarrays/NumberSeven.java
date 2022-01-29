/* Даны действительные числа a1, a2 ,,, an . Найти  max( a1 + a2n ,a2 + a2n-1,an + an+1).*/

package by.koroza.algorithmization.onedimensionalarrays;

import java.util.Arrays;
import java.util.Random;

public class NumberSeven {

	public static void main(String[] args) {
		int length = (int) (Math.random() * 99) + 1;
		double[] array;

		while (length % 2 != 0) {
			length = (int) (Math.random() * 99) + 1;
		}
		System.out.println("Длинна массива равна: " + length);

		array = new double[length];

		for (int i = 0; i < (length); i++) {
			array[i] = randomDouble();
		}

		System.out.println(Arrays.toString(array));

		double var1 = array[array.length - 1];
		double maxSum = array[0] + var1;

		for (int i = 1; i < array.length / 2; i++) {
			double m2 = array[array.length - i - 1];
			if ((array[i] + m2) > maxSum) {
				maxSum = array[i] + m2;
			}
		}
		System.out.println("max = " + maxSum);
	}

	private static double randomDouble() {
		int min = -100;
		int max = 100;
		Random random = new Random();
		double randomDouble = (max - min) * random.nextDouble();
		randomDouble += min;
		return randomDouble;
	}
}