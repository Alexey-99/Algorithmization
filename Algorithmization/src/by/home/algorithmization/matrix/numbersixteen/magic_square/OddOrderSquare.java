package by.home.algorithmization.matrix.numbersixteen.magic_square;

public class OddOrderSquare {

	public void buildOddOrderSquare(int size) {
		int[][] matrixEnlarged = new int[size + (size - 1)][size + (size - 1)];
		int[][] matrix = new int[size][size];
		buildOddOrderSquareEnlarged(matrixEnlarged, matrix);
		transferFromMagnifiedSquareToMagicSquare(matrixEnlarged, matrix);
		printMagicSquare(matrix);
	}

	private void buildOddOrderSquareEnlarged(int[][] matrixEnlarged, int[][] matrix) {
		double iStartCount = (double) matrixEnlarged.length / 2 - 0.5;
		int count = 0;
		int jCount = 0;
		for (int f = 0; f < matrix.length; f++) {
			jCount = f;
			for (int i = (int) iStartCount; i >= iStartCount - (matrix.length - 1); i--) {
				count++;
				for (int j = jCount; j <= jCount; j++) {
					matrixEnlarged[i][j] = count;
				}
				jCount++;
			}
			iStartCount++;
		}
		fillingFourCellsSquare(matrixEnlarged, matrix);
	}

	private void fillingFourCellsSquare(int[][] matrixEnlarged, int[][] matrix) {
		topMarginCheck(matrixEnlarged, matrix);
		rightMarginCheck(matrixEnlarged, matrix);
		bottomMarginCheck(matrixEnlarged, matrix);
		leftMarginCheck(matrixEnlarged, matrix);
	}

	private void topMarginCheck(int[][] matrixEnlarged, int[][] matrix) {
		int iStartCount = (matrixEnlarged.length - matrix.length) / 2;
		for (int i = 0; i < iStartCount; i++) {
			for (int j = 0; j < matrixEnlarged.length; j++) {
				if (matrixEnlarged[i][j] != 0) {
					matrixEnlarged[i + matrix.length][j] = matrixEnlarged[i][j];
				}
			}
		}
	}

	private void rightMarginCheck(int[][] matrixEnlarged, int[][] matrix) {
		int iStartCount = (matrixEnlarged.length - matrix.length) / 2;
		for (int i = iStartCount; i < matrixEnlarged.length; i++) {
			for (int j = matrixEnlarged.length - iStartCount; j < matrixEnlarged.length; j++) {
				if (matrixEnlarged[i][j] != 0) {
					matrixEnlarged[i][j - matrix.length] = matrixEnlarged[i][j];
				}
			}
		}
	}

	private void bottomMarginCheck(int[][] matrixEnlarged, int[][] matrix) {
		int iStartCount = (matrixEnlarged.length - matrix.length) / 2;
		for (int i = matrixEnlarged.length - iStartCount; i < matrixEnlarged.length; i++) {
			for (int j = 0; j < matrixEnlarged.length; j++) {
				if (matrixEnlarged[i][j] != 0) {
					matrixEnlarged[i - matrix.length][j] = matrixEnlarged[i][j];
				}
			}
		}
	}

	private void leftMarginCheck(int[][] matrixEnlarged, int[][] matrix) {
		int iStartCount = (matrixEnlarged.length - matrix.length) / 2;
		for (int i = iStartCount; i < matrixEnlarged.length; i++) {
			for (int j = 0; j < iStartCount; j++) {
				if (matrixEnlarged[i][j] != 0) {
					matrixEnlarged[i][j + matrix.length] = matrixEnlarged[i][j];
				}
			}
		}
	}

	private void transferFromMagnifiedSquareToMagicSquare(int[][] matrixEnlarged, int[][] matrix) {
		int iCount = (matrixEnlarged.length - matrix.length) / 2;
		for (int i = iCount; i < matrixEnlarged.length - iCount; i++) {
			for (int j = (matrixEnlarged.length - matrix.length) / 2; j < matrixEnlarged[i].length - iCount; j++) {
				matrix[i - iCount][j - iCount] = matrixEnlarged[i][j];
			}
		}
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