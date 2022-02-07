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
		int[] arrayCoordinate = new int[amountPoints * 2];
		
		
	}

	private static int initializationAmountPoints() {
		Random rand = new Random();
		int amountPoints = 0;
		do {
			amountPoints = rand.nextInt(20);
		} while (amountPoints < 3);
		return amountPoints;
	}
	
	private static void fillingRandomNumbersArrayCoordinates() {
		
	}
}