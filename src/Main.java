public class Main {
    public static void main(String[] args) {
        Matrix matrixOne = new Matrix( new double[][] { {1, 0}, {0, 1} } );
        Matrix matrixTwo = new Matrix( new double[][] { {1, 2}, {3, 4} } );
        Matrix matrixThree = new Matrix ( new double[][] { {1, 0, 0}, {0, 1, 0}, {0, 0, 1} } );
        Matrix matrixFour = new Matrix ( new double[][] { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} } );
        Matrix matrixFive = new Matrix ( new double[][] { {1, 3, 5, 9}, {1, 3, 1, 7}, {4, 3, 9, 7}, {5, 2, 0, 9} } );

        Matrix matrixResult = MatrixOperations.determinant(matrixFive);

        matrixResult.display();
    }
}

