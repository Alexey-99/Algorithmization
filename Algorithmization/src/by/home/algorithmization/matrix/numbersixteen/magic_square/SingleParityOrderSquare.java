package by.home.algorithmization.matrix.numbersixteen.magic_square;

public class SingleParityOrderSquare {

	public void buildSingleParityOrderSquare(int size) {
		int[][] matrix = new int[size][size];
		int count = 0;
		while (count < 9) {
			count++;
			
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