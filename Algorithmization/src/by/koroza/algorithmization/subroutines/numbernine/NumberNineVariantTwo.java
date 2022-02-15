/* Даны числа X, Y, Z, Т — длины сторон четырехугольника. 
 * Написать метод(методы) вычисления его площади, если угол между сторонами длиной X и Y — прямой. 
 * */

package by.koroza.algorithmization.subroutines.numbernine;

import java.util.Random;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class NumberNineVariantTwo {

	public static void main(String[] args) {
		boolean validationSides = true;
		double sideX = 0;
		double sideY = 0;
		double sideZ = 0;
		double sideT = 0;
		do {
			sideX = initializationSide();
			sideY = initializationSide();
			sideZ = initializationSide();
			sideT = initializationSide();
			validationSides = validationSides(sideX, sideY, sideZ, sideT);
		} while (validationSides == false);
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
		double areaRightTriangle = areaRightTriangle(sideX, sideY);
		double areaSecondTriangle = areaSecondTriangle(sideX, sideY, sideZ, sideT);
		double areaQuadrilateral = areaRightTriangle + areaSecondTriangle;
		System.out.print("Площадь ");
		System.out.printf("%.2f", areaQuadrilateral);
	}

	private static double areaRightTriangle(double sideX, double sideY) {
		double area = 0.5 * sideX * sideY;
		return area;
	}

	private static double areaSecondTriangle(double sideX, double sideY, double sideZ, double sideT) {
		double diagonalLength = diagonalLength(sideX, sideY);
		double thirdSideTriangle = diagonalLength;
		double semiPerimeter = semiPerimeterSecondTriangleCalculation(sideZ, sideT, thirdSideTriangle);
		double areaTriangle = sqrt(semiPerimeter * (semiPerimeter - sideZ) * (semiPerimeter - sideT)
				* (semiPerimeter - thirdSideTriangle));
		return areaTriangle;
	}

	private static double diagonalLength(double sideX, double sideY) {
		double diagonalLength = sqrt(pow(sideX, 2) + pow(sideY, 2));
		return diagonalLength;
	}

	private static double semiPerimeterSecondTriangleCalculation(double sideZ, double sideT, double thirdSideTriangle) {
		double semiPerimeter = (sideZ + sideT + thirdSideTriangle) / 2;
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