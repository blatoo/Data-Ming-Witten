package useful;

public class Cal {

	public static int arraySum(int... arr) {

		int sum = 0;

		for (int i = 0; i < arr.length; i++) {

			sum += arr[i];

		}

		return sum;
	}

	public static int[] matrixRowSum(int[][] Matrix) {

		int numberOfRow = Matrix.length;
		int numberOfClumn = Matrix[0].length;

		int[] sumOfRows = new int[numberOfRow];

		for (int i = 0; i < numberOfRow; i++) {

			for (int j = 0; j < numberOfClumn; j++) {

				sumOfRows[i] += Matrix[i][j];

			}

		}

		return sumOfRows;
	}

	public static int[] matrixColSum(int[][] Matrix) {

		int numberOfLine = Matrix.length;
		int numberOfColumn = Matrix[0].length;

		int[] sumOfCols = new int[numberOfColumn];

		for (int j = 0; j < numberOfColumn; j++) {

			for (int i = 0; i < numberOfLine; i++) {

				sumOfCols[j] += Matrix[i][j];
			}
		}

		return sumOfCols;

	}

	public static void main(String[] args) {

		int[][] Matrix = new int[][] { { 3, 2 }, { 4, 0 }, { 3, 2 } };

//		System.out.println(matrixColSum(Matrix)[0]);
//		System.out.println(matrixColSum(Matrix)[1]);
		System.out.println(matrixRowSum(Matrix)[0]);
		System.out.println(matrixRowSum(Matrix)[1]);
		System.out.println(matrixRowSum(Matrix)[2]);
	}

}
