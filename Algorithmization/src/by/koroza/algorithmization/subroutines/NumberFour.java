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
		findingPairsPointsWithLargestDistanceBetweenPoints(arrayCoordinateXAndY);
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

	private static void findingPairsPointsWithLargestDistanceBetweenPoints(int[] arrayCoordinateXAndY) {
		double maximumDistance = calculatingMaximumDistanceBetweenPoints(arrayCoordinateXAndY);
		findingPointsWithMaximumDistanceBetweenThem(arrayCoordinateXAndY, maximumDistance);
	}

	private static double calculatingMaximumDistanceBetweenPoints(int[] arrayCoordinateXAndY) {
		double maximumDistance = 0;
		double distance = 0;
		for (int i = 0; i < arrayCoordinateXAndY.length; i += 2) {
			for (int j = 0; j < arrayCoordinateXAndY.length; j += 2) {
				int xPointA = arrayCoordinateXAndY[i];
				int yPointA = arrayCoordinateXAndY[i + 1];
				int xPointB = arrayCoordinateXAndY[j];
				int yPointB = arrayCoordinateXAndY[j + 1];
				distance = sqrt(pow(xPointB - xPointA, 2) + pow(yPointB - yPointA, 2));
				if (maximumDistance < distance) {
					maximumDistance = distance;
				}
			}
		}
		return maximumDistance;
	}

	private static void findingPointsWithMaximumDistanceBetweenThem(int[] arrayCoordinateXAndY,
			double maximumDistance) {
		System.out.println("Точки между которыми максимальное расстоянием " + maximumDistance + ", перечиселы ниже: ");
		double distance = 0;
		for (int i = 0; i < arrayCoordinateXAndY.length; i += 2) {
			for (int j = i + 2; j < arrayCoordinateXAndY.length; j += 2) {
				int xPointA = arrayCoordinateXAndY[i];
				int yPointA = arrayCoordinateXAndY[i + 1];
				int xPointB = arrayCoordinateXAndY[j];
				int yPointB = arrayCoordinateXAndY[j + 1];
				distance = sqrt(pow(xPointB - xPointA, 2) + pow(yPointB - yPointA, 2));
				if (distance == maximumDistance) {
					StringBuilder build = new StringBuilder();
					build.append("X - ").append(xPointA).append(" Y - ").append(yPointA);
					build.append(" и X - ").append(xPointB).append(" Y - ").append(yPointB);
					System.out.println(build);
				}

			}
		}
		System.out.println("Точки между которыми максимальное расстоянием " + maximumDistance + ", перечиселы ниже: ");
	}
}