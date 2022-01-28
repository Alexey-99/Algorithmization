package by.home.algorithmization.matrix.numbersixteen.magic_square;

public class SingleParityOrderSquare {

	public void buildSingleParityOrderSquare(int size) {
		int[][] matrixEnlarged = new int[size + 1][size + 1];
		int[][] matrix = new int[size][size];
		int count = 0;
		int countStart = count;
		int squareSize = matrix.length / 2;
		int yCoordinate = 1;
		double x = (double) size / 4;
		int xCoordinate = (int) x;

		while (count < countStart + (squareSize * squareSize)) {
			count++;
			if (count == 1) {
				matrixEnlarged[yCoordinate][xCoordinate] = count;
				printMagicSquare(matrixEnlarged);
			} else if (count > 1) {
				yCoordinate--;
				xCoordinate++;
				if ((yCoordinate == 0) && (xCoordinate != 0)) {
					yCoordinate += squareSize;
					if (matrixEnlarged[yCoordinate][xCoordinate] == 0) {
						matrixEnlarged[yCoordinate][xCoordinate] = count;
						printMagicSquare(matrixEnlarged);
					} else if (matrixEnlarged[yCoordinate][xCoordinate] != 0) {
						matrixEnlarged[yCoordinate + 2][xCoordinate - 1] = count;
						printMagicSquare(matrixEnlarged);
					}
				} else if ((xCoordinate == squareSize) && (yCoordinate != 0)) {
					xCoordinate -= squareSize;
					matrixEnlarged[yCoordinate][xCoordinate] = count;
					printMagicSquare(matrixEnlarged);
					if (matrixEnlarged[yCoordinate][xCoordinate] == 0) {
						matrixEnlarged[yCoordinate][xCoordinate] = count;
						printMagicSquare(matrixEnlarged);
					} else if ((matrixEnlarged[yCoordinate][xCoordinate] != 0)
							&& (matrixEnlarged[yCoordinate][xCoordinate] != count)) {
						matrixEnlarged[yCoordinate + 2][xCoordinate - 1] = count;
						printMagicSquare(matrixEnlarged);
					}
				} else if ((yCoordinate == 0) && (xCoordinate == squareSize)) {
					matrixEnlarged[yCoordinate - 2][xCoordinate - 1] = count;
					printMagicSquare(matrixEnlarged);
				} else if ((matrixEnlarged[yCoordinate][xCoordinate] != 0)
						&& (matrixEnlarged[yCoordinate][xCoordinate] != count)) {
					yCoordinate += 2;
					xCoordinate -= 1;
					matrixEnlarged[yCoordinate][xCoordinate] = count;
					printMagicSquare(matrixEnlarged);
				} else {
					matrixEnlarged[yCoordinate][xCoordinate] = count;
					printMagicSquare(matrixEnlarged);
				}
			}

		}

	}

	private int coordinateYZero(int[][] matrixEnlarged, int yCoordinate, int xCoordinate, int count) {

		return yCoordinate;
	}

	private int coordinateXZero(int[][] matrixEnlarged, int yCoordinate, int xCoordinate, int count) {

		return xCoordinate;
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