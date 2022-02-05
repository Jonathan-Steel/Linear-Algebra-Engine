public class Main {
    public static void main(String[] args) {
        Matrix matrixOne = new Matrix( new int[][] { {1, 0}, {0, 1} } );
        Matrix matrixTwo = new Matrix( new int[][] { {1, 0}, {0, 1} } );
        Matrix matrixThree = MatrixOperations.multiply(matrixOne, matrixTwo);

        Matrix matrixFour = new Matrix( new int[][] { {1, 2}, {3, 4}, {5, 6} } );

        MatrixOperations.transpose(matrixFour).display();
    }
}

