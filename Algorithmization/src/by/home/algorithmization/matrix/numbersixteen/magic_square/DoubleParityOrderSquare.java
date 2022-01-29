package by.home.algorithmization.matrix.numbersixteen.magic_square;

public class DoubleParityOrderSquare {

	public void buildingDoubleParityOrderSquare(int size) {
		int[][] matrix = new int[size][size];
		int magicConstant = calculateMagicConstant(size);
		System.out.println("Магическая сумма:" + magicConstant);
		matrix = buildingMagicSquareCornerAndCenterElements(matrix);
		buildingMagicSquareExtremeElements(matrix);
		printMagicSquare(matrix);
		sumColumn(matrix);
		sumRows(matrix);
		sumDiagonalFromLeftToRight(matrix);
		sumDiagonalFromRightToLeft(matrix);
	}

	private int calculateMagicConstant(int size) {
		int magicConstant = (size * ((int) Math.pow(size, 2) + 1)) / 2;
		return magicConstant;
	}

	private int[][] buildingMagicSquareCornerAndCenterElements(int[][] matrix) {
		int beginningCentralSquareTop = matrix.length / 4 - 1;
		int beginningCentralSquareBottom = matrix.length - beginningCentralSquareTop - 1;
		int beginningCentralSquareLeft = beginningCentralSquareTop;
		int beginningCentralSquareRight = beginningCentralSquareBottom;
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				count++;
				if ((i == 0 || i == matrix.length - 1) && ((j == 0) || (j == matrix[i].length - 1))) {
					matrix[i][j] = count;
				} else if ((i > beginningCentralSquareTop && i < beginningCentralSquareBottom)
						&& (j > beginningCentralSquareLeft && j < beginningCentralSquareRight)) {
					matrix[i][j] = count;
				}
			}
		}
		return matrix;
	}

	private int[][] buildingMagicSquareExtremeElements(int[][] matrix) {
		int beginningCentralSquareTop = matrix.length / 4 - 1;
		int beginningCentralSquareBottom = matrix.length - beginningCentralSquareTop - 1;
		int beginningCentralSquareLeft = beginningCentralSquareTop + 1;
		int beginningCentralSquareRight = beginningCentralSquareBottom - 1;
		int count = 0;
		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = matrix[i].length - 1; j >= 0; j--) {
				count++;
				if ((i == 0 || i == matrix.length - 1) && (j > 0 && j < matrix[i].length - 1)) {
					matrix[i][j] = count;
				} else if ((i > beginningCentralSquareTop && i < beginningCentralSquareBottom)
						&& (j < beginningCentralSquareLeft || j > beginningCentralSquareRight)) {
					matrix[i][j] = count;
				} else if ((i > 0 && i <= beginningCentralSquareTop)
						|| (i < matrix.length - 1 && i >= beginningCentralSquareBottom)) {
					matrix[i][j] = count;
				}
			}
		}
		return matrix;
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