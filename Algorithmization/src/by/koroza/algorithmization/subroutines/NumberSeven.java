/* Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9. */

package by.koroza.algorithmization.subroutines;

public class NumberSeven {

	public static void main(String[] args) {
		int minFactorial = 1;
		int maxFactorial = 9;
		sumFactorialCalculation(minFactorial, maxFactorial);
	}

	private static void sumFactorialCalculation(int minFactorial, int maxFactorial) {
		int[] arrayFactorial = calculationFactorialsOddNumbers(minFactorial, maxFactorial);
		int sum = calculationSum(arrayFactorial);
		System.out.println("Сумма факториалов всех нечетных чисел от 1 до 9 равна: " + sum);
	}

	private static int[] calculationFactorialsOddNumbers(int minFactorial, int maxFactorial) {
		int numberOddNumbersFromOneToNine = numberFactorialsOddNumbers(minFactorial, maxFactorial);
		int[] arrayFactorial = new int[numberOddNumbersFromOneToNine];
		int index = 0;
		int factorial = minFactorial;
		for (int i = minFactorial; i < maxFactorial; i += 2) {
			factorial = minFactorial;
			int j = minFactorial;
			while (j <= i) {
				factorial *= j;
				j++;
			}
			arrayFactorial[index] = factorial;
			index++;
		}
		return arrayFactorial;
	}

	private static int calculationSum(int[] arrayFactorial) {
		int sum = 0;
		for (int i = 0; i < arrayFactorial.length; i++) {
			sum += arrayFactorial[i];
		}
		return sum;
	}

	private static int numberFactorialsOddNumbers(int minFactorial, int maxFactorial) {
		int count = 0;
		for (int i = minFactorial; i <= maxFactorial; i++) {
			if (i % 2 != 0) {
				count++;
			}
		}
		return count;
	}
}