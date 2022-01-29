// В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К. 

package by.koroza.algorithmization.onedimensionalarrays;

import java.util.Arrays;
import java.util.Random;

public class NumberOne {

	public static void main(String[] args) {
		int[] arrayA = new int[100];
		Random rand = new Random();
		int k = 13;
		int sum = 0;

		for (int i = 0; i < arrayA.length; i++) {
			arrayA[i] = rand.nextInt(50);
		}
		System.out.println(Arrays.toString(arrayA));
		System.out.print("Числа которые делятся без остатка на " + k + ": ");
		for (Integer element : arrayA) {
			if (element % k == 0) {
				sum += element;
				System.out.print(element + " ");
			}
		}
		System.out.println("");
		System.out.print("Сумма чисел кратных " + k + " равна: " + sum);
	}
}