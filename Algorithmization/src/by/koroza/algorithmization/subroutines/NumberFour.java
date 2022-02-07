/* На плоскости заданы своими координатами n точек. 
 * Написать метод(методы), определяющие, между какими из пар точек самое большое расстояние. 
 * Указание. Координаты точек занести в массив. 
 */

package by.koroza.algorithmization.subroutines;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.util.Random;

public class NumberFour {

	public static void main(String[] args) {
		int amountPoints = initializationAmountPoints();
		int[] arrayCoordinateXAndY = new int[amountPoints * 2];
		int planeLength = 10;
		int[][] plane = new int[planeLength][planeLength];
		fillingRandomNumbersArrayCoordinates(arrayCoordinateXAndY, plane);
		calculatingMaximumDistanceBetweenPoints(arrayCoordinateXAndY);
	}

	private static int initializationAmountPoints() {
		Random rand = new Random();
		int amountPoints = 0;
		do {
			amountPoints = rand.nextInt(20);
		} while (amountPoints < 3);
		return amountPoints;
	}

	private static void fillingRandomNumbersArrayCoordinates(int[] arrayCoordinateXAndY, int[][] plane) {
		Random rand = new Random();
		for (int i = 0; i < arrayCoordinateXAndY.length; i++) {
			arrayCoordinateXAndY[i] = rand.nextInt(plane.length - 1);
		}
	}

	private static void calculatingMaximumDistanceBetweenPoints(int[] arrayCoordinateXAndY) {
		double maximumDistance = 0;
		double distance = 0;
		for (int i = 0; i < arrayCoordinateXAndY.length; i += 2) {
			for (int j = i; j < arrayCoordinateXAndY.length; j += 2) {
				int xPointA = i;
				int yPointA = i + 1;
				int xPointB = j;
				int yPointB = j + 1;
				distance = sqrt(pow(xPointB - xPointA, 2) + pow(yPointB - yPointA, 2));
				if (maximumDistance < distance) {
					maximumDistance = distance;
				}
			}
		}
	}
}