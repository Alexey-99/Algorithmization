// Даны действительные числа а1 ,а2 ,..., аn. Поменять местами наибольший и наименьший элементы. 

package by.koroza.algorithmization.onedimensionalarrays;

import java.util.Arrays;
import java.util.Random;

public class NumberFour {

	public static void main(String[] args) {
		Random rand = new Random();
		double[] array = new double[10];
		double max = 0;
		double min = 0;
		int iMaxNumber = 0;
		int iMinNumber = 0;

		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(50);
		}

		System.out.println(Arrays.toString(array));
		min = array[0];
		max = array[0];

		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
				iMinNumber = i;
			}
			if (array[i] > max) {
				max = array[i];
				iMaxNumber = i;
			}
		}

		double tmp = array[iMaxNumber];
		array[iMaxNumber] = array[iMinNumber];
		array[iMinNumber] = tmp;

		System.out.println("Минимальное число массива: " + min + " с индексом " + iMinNumber);
		System.out.println("Максимальное число массива: " + max + " с индексом " + iMaxNumber);
		System.out.println(Arrays.toString(array));
	}
}