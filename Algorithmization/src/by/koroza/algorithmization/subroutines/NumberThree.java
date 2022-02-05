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

	private static double calculatingAreaTriangle(int sideHexagon) {
		int heightTriangle = 0;
		double areaTriangle = 0.5 * sideHexagon * heightTriangle;

		return areaTriangle;
	}

	private static void calculatingAreaHexagon(int sideHexagon) {
		double heightTriangle = calculatingAreaTriangle(sideHexagon);

	}

	private static void calculatingHeightTriangle(int sideHexagon) {

	}
}