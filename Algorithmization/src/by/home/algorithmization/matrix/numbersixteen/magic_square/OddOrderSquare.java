package by.home.algorithmization.matrix.numbersixteen.magic_square;

public class OddOrderSquare {

	public void buildOddOrderSquare(int size) {
		int[][] matrixEnlarged = new int[size + (size - 1)][size + (size - 1)];
		int[][] matrix = new int[size][size];
		buildOddOrderSquareEnlarged(matrixEnlarged, matrix);
		printMagicSquare(matrixEnlarged);

	}

	private void buildOddOrderSquareEnlarged(int[][] matrixEnlarged, int[][] matrix) {
		double iCount = (double) matrixEnlarged.length / 2 - 0.5;
		int count = 0;
		int jCount = 0;
		for (int f = 0; f < matrix.length; f++) {
			jCount = f;
			for (int i = (int) iCount; i >= iCount - (matrix.length - 1); i--) {
				count++;
				for (int j = jCount; j <= jCount; j++) {
					matrixEnlarged[i][j] = count;
				}
				jCount++;
			}
			iCount++;
		}
		iCount = (double) matrixEnlarged.length / 2 - 0.5;
		printMagicSquare(matrixEnlarged);
		matrixEnlarged[matrixEnlarged.length - 2][(int) iCount] = matrixEnlarged[0][(int) iCount];
		printMagicSquare(matrixEnlarged);
		matrixEnlarged[(int) iCount][1] = matrixEnlarged[(int) iCount][matrixEnlarged.length - 1];
		printMagicSquare(matrixEnlarged);
		matrixEnlarged[1][(int) iCount] = matrixEnlarged[matrixEnlarged.length - 1][(int) iCount];
		printMagicSquare(matrixEnlarged);
	}

	private void printMagicSquare(int[][] matrix) {
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}