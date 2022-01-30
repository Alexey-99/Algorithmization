package by.koroza.algorithmization.matrix.numbersixteen.magicsquare;

public class SingleParityOrderSquare {

	public void buildSingleParityOrderSquare(int size) {
		calculateMagicConstant(size);
		int[][] matrixEnlarged = new int[size + 1][size + 1];
		int[][] matrix = new int[size][size];
		int count = 0;
		int yCoordinate = 0;
		int xCoordinate = 0;
		int upperLimit = 0;
		int rightLimit = 0;
		int countStart = count;
		int squareSize = matrix.length / 2;
		int numberStepsDown = 2;
		int numberStepsLeft = 1;
		int numberVirtuallyDivisibleSquaresInMagicSquare = 4;
		double x = (double) size / numberVirtuallyDivisibleSquaresInMagicSquare;
		int emptyCage = 0;
		

		for (int i = 0; i < numberVirtuallyDivisibleSquaresInMagicSquare; i++) {
			if (i == 0) {
				yCoordinate = 1;
				xCoordinate = (int) x;
				upperLimit = 0;
				rightLimit = squareSize;
			} else if (i == 1) {
				yCoordinate = squareSize + 1;
				xCoordinate = (int) x + squareSize;
				upperLimit = squareSize;
				rightLimit = squareSize + squareSize;
			} else if (i == 2) {
				yCoordinate = 1;
				xCoordinate = (int) x + squareSize;
				upperLimit = 0;
				rightLimit = squareSize + squareSize;
			} else if (i == 3) {
				yCoordinate = squareSize + 1;
				xCoordinate = (int) x;
				upperLimit = squareSize;
				rightLimit = squareSize;
			}
			for (int j = 0; j < countStart + (squareSize * squareSize); j++) {
				count++;
				if (j == 0) {
					matrixEnlarged[yCoordinate][xCoordinate] = count;
				} else if (j > 0) {
					yCoordinate--;
					xCoordinate++;
					if ((yCoordinate == upperLimit) && (xCoordinate != rightLimit)) {
						yCoordinate += squareSize;
						if (matrixEnlarged[yCoordinate][xCoordinate] == emptyCage) {
							matrixEnlarged[yCoordinate][xCoordinate] = count;
						}
					} else if ((xCoordinate == rightLimit) && (yCoordinate != upperLimit)) {
						xCoordinate -= squareSize;
						matrixEnlarged[yCoordinate][xCoordinate] = count;
						if (matrixEnlarged[yCoordinate][xCoordinate] == emptyCage) {
							matrixEnlarged[yCoordinate][xCoordinate] = count;
						}
					} else if ((yCoordinate == upperLimit) && (xCoordinate == rightLimit)) {
						yCoordinate += numberStepsDown;
						xCoordinate -= numberStepsLeft;
						matrixEnlarged[yCoordinate][xCoordinate] = count;
					} else if ((matrixEnlarged[yCoordinate][xCoordinate] != emptyCage)
							&& (matrixEnlarged[yCoordinate][xCoordinate] != count)) {
						yCoordinate += numberStepsDown;
						xCoordinate -= numberStepsLeft;
						matrixEnlarged[yCoordinate][xCoordinate] = count;
					} else {
						matrixEnlarged[yCoordinate][xCoordinate] = count;
					}
				}
			}
		}
		transferElements(matrixEnlarged);
		transferMagicSquare(matrixEnlarged, matrix);
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

	private void transferElements(int[][] matrixEnlarged) {
		int squareSize = matrixEnlarged.length / 2;
		int lengthLineRearrangedElements = (matrixEnlarged.length / 2 + 1) / 2;
		int numberColumnsElementsRearranged = ((matrixEnlarged.length / 2 + 1) / 2) - 1;
		for (int i = 1; i <= squareSize; i++) {
			for (int j = 0; j < matrixEnlarged[i].length - 1; j++) {
				if (i != lengthLineRearrangedElements && j < numberColumnsElementsRearranged) {
					int tmp = matrixEnlarged[i][j];
					matrixEnlarged[i][j] = matrixEnlarged[i + squareSize][j];
					matrixEnlarged[i + squareSize][j] = tmp;
				} else if (i == lengthLineRearrangedElements && j > 0 && j <= numberColumnsElementsRearranged) {
					int tmp = matrixEnlarged[i][j];
					matrixEnlarged[i][j] = matrixEnlarged[i + squareSize][j];
					matrixEnlarged[i + squareSize][j] = tmp;
				} else if (j >= matrixEnlarged[i].length - numberColumnsElementsRearranged) {
					int tmp = matrixEnlarged[i][j];
					matrixEnlarged[i][j] = matrixEnlarged[i + squareSize][j];
					matrixEnlarged[i + squareSize][j] = tmp;
				}
			}
		}
	}

	private void transferMagicSquare(int[][] matrixEnlarged, int[][] matrix) {
		for (int i = 1; i < matrixEnlarged.length; i++) {
			for (int j = 0; j < matrixEnlarged.length - 1; j++) {
				matrix[i - 1][j] = matrixEnlarged[i][j];
			}
		}
	}

	private void printMagicSquare(int[][] matrix) {
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%3d ", matrix[i][j]);
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