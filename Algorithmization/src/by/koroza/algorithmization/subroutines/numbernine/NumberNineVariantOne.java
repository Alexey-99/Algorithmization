/* Даны числа X, Y, Z, Т — длины сторон четырехугольника. 
 * Написать метод(методы) вычисления его площади, если угол между сторонами длиной X и Y— прямой. 
 * */

package by.koroza.algorithmization.subroutines.numbernine;

import java.util.Random;

public class NumberNineVariantOne {

	public static void main(String[] args) {
		double sideX = initializationSide();
		double sideY = initializationSide();
		double sideZ = initializationSide();
		double sideT = initializationSide();
		System.out.println("Сторона X = " + sideX);
		System.out.println("Сторона Y = " + sideY);
		System.out.println("Сторона Z = " + sideZ);
		System.out.println("Сторона T = " + sideT);
		areaCalculation(sideX, sideY, sideZ, sideT);

	}

	private static int initializationSide() {
		Random rand = new Random();
		int side = 0;
		side = rand.nextInt(20) + 1;
		return side;
	}

	private static void areaCalculation(double sideX, double sideY, double sideZ, double sideT) {
		double semiPerimeter = semiPerimeterCalculation(sideX, sideY, sideZ, sideT);
		double area = Math.sqrt(
				(semiPerimeter - sideX) * (semiPerimeter - sideY) * (semiPerimeter - sideZ) * (semiPerimeter - sideT));
		System.out.println("Площадь " + area);
	}

	private static double semiPerimeterCalculation(double sideX, double sideY, double sideZ, double sideT) {
		double semiPerimeter = (sideX + sideY + sideZ + sideT) / 2;
		return semiPerimeter;
	}

	private static boolean validationSides(double sideX, double sideY, double sideZ, double sideT) {
		boolean flag = true;
		if ((sideX < sideY + sideZ + sideT) && (sideY < sideX + sideZ + sideT) && (sideZ < sideX + sideY + sideT)
				&& (sideT < sideX + sideY + sideZ)) {
		} else {
			flag = false;
		}
		return flag;
	}
}