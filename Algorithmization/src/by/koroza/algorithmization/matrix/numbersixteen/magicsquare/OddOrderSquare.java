package by.koroza.algorithmization.matrix.numbersixteen.magicsquare;

public class OddOrderSquare {

	public void buildOddOrderSquare(int size) {
		calculateMagicConstant(size);
		int[][] matrixEnlarged = new int[size + (size - 1)][size + (size - 1)];
		int[][] matrix = new int[size][size];
		buildOddOrderSquareEnlarged(matrixEnlarged, matrix);
		transferFromMagnifiedSquareToMagicSquare(matrixEnlarged, matrix);
		printMagicSquare(matrix);
		sumColumn(matrix);
		sumRows(matrix);
		sumDiagonalFromLeftToRight(matrix);
		sumDiagonalFromRightToLeft(matrix);
	}
	
	private void calculateMagicConstant(int size) {
		int magicConstant = (size * ((int) Math.pow(size, 2) + 1)) / 2;
		System.out.println("Магическая сумма: " + magicConstant);
	}

	private void buildOddOrderSquareEnlarged(int[][] matrixEnlarged, int[][] matrix) {
		int numberSideMargins = 2;
		double iStartCount = (double) matrixEnlarged.length / numberSideMargins - 0.5;
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
		int numberSideMargins = 2;
		int emptyCage = 0;
		int iStartCount = (matrixEnlarged.length - matrix.length) / numberSideMargins;
		for (int i = 0; i < iStartCount; i++) {
			for (int j = 0; j < matrixEnlarged.length; j++) {
				if (matrixEnlarged[i][j] != emptyCage) {
					matrixEnlarged[i + matrix.length][j] = matrixEnlarged[i][j];
				}
			}
		}
	}

	private void rightMarginCheck(int[][] matrixEnlarged, int[][] matrix) {
		int numberSideMargins = 2;
		int emptyCage = 0;
		int iStartCount = (matrixEnlarged.length - matrix.length) / numberSideMargins;
		for (int i = iStartCount; i < matrixEnlarged.length; i++) {
			for (int j = matrixEnlarged.length - iStartCount; j < matrixEnlarged.length; j++) {
				if (matrixEnlarged[i][j] != emptyCage) {
					matrixEnlarged[i][j - matrix.length] = matrixEnlarged[i][j];
				}
			}
		}
	}

	private void bottomMarginCheck(int[][] matrixEnlarged, int[][] matrix) {
		int numberSideMargins = 2;
		int emptyCage = 0;
		int iStartCount = (matrixEnlarged.length - matrix.length) / numberSideMargins;
		for (int i = matrixEnlarged.length - iStartCount; i < matrixEnlarged.length; i++) {
			for (int j = 0; j < matrixEnlarged.length; j++) {
				if (matrixEnlarged[i][j] != emptyCage) {
					matrixEnlarged[i - matrix.length][j] = matrixEnlarged[i][j];
				}
			}
		}
	}

	private void leftMarginCheck(int[][] matrixEnlarged, int[][] matrix) {
		int numberSideMargins = 2;
		int emptyCage = 0;
		int iStartCount = (matrixEnlarged.length - matrix.length) / numberSideMargins;
		for (int i = iStartCount; i < matrixEnlarged.length; i++) {
			for (int j = 0; j < iStartCount; j++) {
				if (matrixEnlarged[i][j] != emptyCage) {
					matrixEnlarged[i][j + matrix.length] = matrixEnlarged[i][j];
				}
			}
		}
	}

	private void transferFromMagnifiedSquareToMagicSquare(int[][] matrixEnlarged, int[][] matrix) {
		int numberSideMargins = 2;
		int iCount = (matrixEnlarged.length - matrix.length) / numberSideMargins;
		for (int i = iCount; i < matrixEnlarged.length - iCount; i++) {
			for (int j = (matrixEnlarged.length - matrix.length) / numberSideMargins; j < matrixEnlarged[i].length - iCount; j++) {
				matrix[i - iCount][j - iCount] = matrixEnlarged[i][j];
			}
		}
	}

	private void printMagicSquare(int[][] matrix) {
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%2d ", matrix[i][j]);
			}
			System.out.println();
		}
	}

	private void sumColumn(int[][] matrix) {
		System.out.println();
		System.out.print("Суммы чисел по столбцам: ");
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			sum = 0;
			for (int j = 0; j < matrix[i].length; j++) {
				sum += matrix[j][i];
			}
			System.out.print(sum + " ");
		}
		System.out.println();
	}

	private void sumRows(int[][] matrix) {
		System.out.print("Суммы чисел по строкам: ");
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			sum = 0;
			for (int j = 0; j < matrix[i].length; j++) {
				sum += matrix[i][j];
			}
			System.out.print(sum + " ");
		}
		System.out.println();
	}

	private void sumDiagonalFromLeftToRight(int[][] matrix) {
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j <= i; j++) {
				sum += matrix[i][j];
			}
		}
		System.out.println("Cумма диагонали с лева на права: " + sum);
	}

	private void sumDiagonalFromRightToLeft(int[][] matrix) {
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = matrix.length - 1 - i; j < matrix.length - i; j++) {
				sum += matrix[i][j];
			}
		}
		System.out.println("Сумма диагональ с права на лево: " + sum);
	}
}