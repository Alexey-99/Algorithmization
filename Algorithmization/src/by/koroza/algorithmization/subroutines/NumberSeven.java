/* Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9. */

package by.koroza.algorithmization.subroutines;

public class NumberSeven {

	public static void main(String[] args) {
		sumFactorialCalculation();
	}

	private static void sumFactorialCalculation() {
		int[] arrayFactorial = calculationFactorialsOddNumbers();
		int sum = calculationSum(arrayFactorial);
		System.out.println("Сумма факториалов всех нечетных чисел от 1 до 9 равна: " + sum);
	}

	private static int[] calculationFactorialsOddNumbers() {
		int numberOddNumbersFromOneToNine = 5;
		int[] arrayFactorial = new int[numberOddNumbersFromOneToNine];
		int index = 0;
		int factorial = 1;
		for (int i = 1; i < 9; i += 2) {
			factorial = 1;
			int j = 1;
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

}
