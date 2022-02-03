/* Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади треугольника. */

package by.koroza.algorithmization.subroutines;

import java.util.Random;

public class NumberThree {

	public static void main(String[] args) {
		int sideHexagon = assigningRandomNumbers();
		
	}

	private static int assigningRandomNumbers() {
		int number = 0;
		Random rand = new Random();
		number = rand.nextInt(30) + 1;
		return number;
	}
}
