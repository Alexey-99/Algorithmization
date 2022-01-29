package by.home.algorithmization.matrix.numbersixteen.magic_square;

public class SingleParityOrderSquare {

	public void buildSingleParityOrderSquare(int size) {
		int[][] matrixEnlarged = new int[size + 1][size + 1];
		int[][] matrix = new int[size][size];
		int count = 0;
		int yCoordinate = 0;
		int xCoordinate = 0;
		int upperLimit = 0;
		int rightLimit = 0;
		int countStart = count;
		int squareSize = matrix.length / 2;
		double x = (double) size / 4;

		for (int i = 0; i < 4; i++) {
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
						if (matrixEnlarged[yCoordinate][xCoordinate] == 0) {
							matrixEnlarged[yCoordinate][xCoordinate] = count;
						} else if (matrixEnlarged[yCoordinate][xCoordinate] != 0) {
							matrixEnlarged[yCoordinate + 2][xCoordinate - 1] = count;
						}
					} else if ((xCoordinate == rightLimit) && (yCoordinate != upperLimit)) {
						xCoordinate -= squareSize;
						matrixEnlarged[yCoordinate][xCoordinate] = count;
						if (matrixEnlarged[yCoordinate][xCoordinate] == 0) {
							matrixEnlarged[yCoordinate][xCoordinate] = count;
						} else if ((matrixEnlarged[yCoordinate][xCoordinate] != 0)
								&& (matrixEnlarged[yCoordinate][xCoordinate] != count)) {
							matrixEnlarged[yCoordinate + 2][xCoordinate - 1] = count;
						}
					} else if ((yCoordinate == upperLimit) && (xCoordinate == rightLimit)) {
						yCoordinate += 2;
						xCoordinate -= 1;
						matrixEnlarged[yCoordinate][xCoordinate] = count;
					} else if ((matrixEnlarged[yCoordinate][xCoordinate] != 0)
							&& (matrixEnlarged[yCoordinate][xCoordinate] != count)) {
						yCoordinate += 2;
						xCoordinate -= 1;
						matrixEnlarged[yCoordinate][xCoordinate] = count;
					} else {
						matrixEnlarged[yCoordinate][xCoordinate] = count;
					}
				}
			}
		}
		printMagicSquare(matrixEnlarged);
		transferElements(matrixEnlarged); // TODO Пересавить элементы
		transferMagicSquare(matrixEnlarged, matrix);
		printMagicSquare(matrix);
	}

	private void transferElements(int[][] matrixEnlarged) {
		int squareSize = matrixEnlarged.length / 2;
		int firstNumberElement = 0;
		int secondNumberElement = 1;
		for (int i = 1; i <= (int) matrixEnlarged.length / 2; i++) {
			for (int j = 0; j < 2; j++) {
				if (i % 2 != 0 && j == firstNumberElement) {
					int tmp = matrixEnlarged[i][firstNumberElement];
					matrixEnlarged[i][firstNumberElement] = matrixEnlarged[i + squareSize][firstNumberElement];
					matrixEnlarged[i + squareSize][firstNumberElement] = tmp;
				}else if (i % 2 == 0 && j == secondNumberElement) {
					int tmp = matrixEnlarged[i][secondNumberElement];
					matrixEnlarged[i][secondNumberElement] = matrixEnlarged[i + squareSize][secondNumberElement];
					matrixEnlarged[i + squareSize][secondNumberElement] = tmp;
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
		int sum = 0;
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			sum = 0;
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%2d ", matrix[i][j]);
				sum += matrix[i][j];
			}
			System.out.print(" - " + sum);
			System.out.println();
		}
	}
}