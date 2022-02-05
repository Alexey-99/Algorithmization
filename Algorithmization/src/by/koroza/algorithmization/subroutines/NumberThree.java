/* Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади треугольника. */

package by.koroza.algorithmization.subroutines;

import java.util.Random;

public class NumberThree {

	public static void main(String[] args) {
		int sideHexagon = assigningRandomNumbersSideHexagon();
		System.out.println("Сторона шестиугольника равна: " + sideHexagon);
		calculatingAreaHexagon(sideHexagon);
	}

	private static int assigningRandomNumbersSideHexagon() {
		int number = 0;
		Random rand = new Random();
		number = rand.nextInt(30) + 1;
		return number;
	}

	private static void calculatingAreaHexagon(int sideHexagon) {
		double areaTriangle = calculatingAreaTriangle(sideHexagon);
		double areaHexagon = areaTriangle * 6;
		printAreaHexagon(areaHexagon);
	}

	private static double calculatingAreaTriangle(int sideHexagon) {
		double heightTriangle = calculatingHeightTriangle(sideHexagon);
		double areaTriangle = 0.5 * sideHexagon * heightTriangle;
		return areaTriangle;
	}

	private static double calculatingHeightTriangle(int sideHexagon) {
		double heightTriangle = Math.sqrt((Math.pow(sideHexagon, 2) - Math.pow((sideHexagon / 2), 2)));
		return heightTriangle;
	}

	private static void printAreaHexagon(double areaHexagon) {
		System.out.println("Площадь шестиугольника равна: " + areaHexagon);
	}
}