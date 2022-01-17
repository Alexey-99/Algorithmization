/* Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего. */

package matrix;

import java.util.Random;

public class NumberOne {

	public static void main(String[] args) {
		Random rand = new Random();
		int x = rand.nextInt(10) + 1;
		int y = rand.nextInt(10) + 1;
		int[][] matrix = new int[y][x];
		int[] arrayIndexСolumn = new int[x];
		int indexArrayIndexСolumn = 0;
		

		System.out.println("Первоначатльный многомерный массив:");
		matrix = arrayCreation(matrix);
		System.out.println();
		
		arrayIndexСolumn = findingDesiredColumnsMatrixReturnArrayIndexСolumn(matrix, x);
		indexArrayIndexСolumn = findingDesiredColumnsMatrixReturnIndexСolumn(matrix);
		
		System.out.println("Все нечетные столбцы, у которых первый элемент больше последнего: ");
		printingСolumns(matrix, indexArrayIndexСolumn, arrayIndexСolumn);
		
	}

	private static int[][] arrayCreation(int[][] matrix) {
		Random rand = new Random();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = rand.nextInt(10);
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		return matrix;
	}

	private static int[] findingDesiredColumnsMatrixReturnArrayIndexСolumn(int[][] matrix, int x) {
		int[] arrayIndexСolumn = new int[x];
		int indexArrayIndexСolumn = 0;
		for (int i = 0; i < 1; i++) {
			for (int j = 1; j < matrix[i].length; j += 2) {
				if (matrix[i][j] > matrix[matrix.length - 1][j]) {
					arrayIndexСolumn[indexArrayIndexСolumn] = j;
					indexArrayIndexСolumn++;
				}
			}
		}
		return arrayIndexСolumn;
	}
	
	private static int findingDesiredColumnsMatrixReturnIndexСolumn(int[][] matrix) {
		int indexArrayIndexСolumn = 0;
		for (int i = 0; i < 1; i++) {
			for (int j = 1; j < matrix[i].length; j += 2) {
				if (matrix[i][j] > matrix[matrix.length - 1][j]) {
					indexArrayIndexСolumn++;
				}
			}
		}
		return indexArrayIndexСolumn;
	}
	
	private static void printingСolumns(int[][] matrix, int indexArrayIndexСolumn, int[] arrayIndexСolumn) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < indexArrayIndexСolumn; j++) {
				System.out.print(matrix[i][arrayIndexСolumn[j]] + " ");
			}
			System.out.println();
		}
	}
}