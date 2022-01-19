/*В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить на 
 * соответствующие им позиции другого, а его элементы второго переместить в первый. 
 * Номера столбцов вводит пользователь с клавиатуры. 
 */

package matrix;

import java.util.Random;

public class NumberEight {

	public static void main(String[] args) {
		int linesCount = matrixLengthInitialization();
		int columnCount = matrixLengthInitialization();
		int[][] matrix = new int[linesCount][columnCount];
		matrix = fillingMatrixRandomNumbers(matrix);
		
	}

	private static int matrixLengthInitialization() {
		int length = 0;
		Random rand = new Random();
		while (length <= 1) {
			length = rand.nextInt(10);
		}
		return length;
	}
	
	private static int[][] fillingMatrixRandomNumbers(int[][] matrix){
		Random rand = new Random();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = rand.nextInt(9) + 1;
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		return matrix;
	}
	
}
