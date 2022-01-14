/*Дан целочисленный массив с количеством элементов п. 
 * Сжать массив, выбросив из него каждый второй элемент (освободившиеся элементы заполнить нулями). 
 * Примечание. Дополнительный массив не использовать. 
 */

package onedimensionalarrays;

import java.util.Arrays;
import java.util.Random;

public class NumberTen {

	public static void main(String[] args) {
		int length = randIntLength();
		int[] array = new int[length];
		array = randIntArray(array);
		System.out.println("Первоначальный массив чисел: " + Arrays.toString(array));
		array = removeEveryOtherElement(array);
		System.out.println("Сжатый массив чисел: " + Arrays.toString(array));

	}

	private static int randIntLength() {
		Random rand = new Random();
		int length = 0;
		while (length == 0) {
			length = rand.nextInt(50);
		}
		return length;
	}

	private static int[] randIntArray(int[] array) {
		Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(50);
		}
		return array;
	}

	private static int[] removeEveryOtherElement(int[] array) {
		for (int i = 1; i < array.length; i += 2) {
			array[i] = 0;
		}
		array = arrayСompression(array);
		return array;
	}

	private static int[] arrayСompression(int[] array) {
		for (int i = 1; i < array.length - i; i++) {
			array[i] = array[i + i];
			array[i + i] = 0;
		}
		return array;
	}
}