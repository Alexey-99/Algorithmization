// Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых аi > i

package by.koroza.algorithmization.onedimensionalarrays;

import java.util.Arrays;
import java.util.Random;

public class NumberFive {

	public static void main(String[] args) {
		int[] array = new int[100];
		Random rand = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(50);
		}

		System.out.println(Arrays.toString(array));
		int count = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] > i) {
				System.out.print(array[i] + " ");
				count++;
			}
		}
		System.out.println("");
		System.out.println("Колличество вывведенных чисел: " + count);
	}
}