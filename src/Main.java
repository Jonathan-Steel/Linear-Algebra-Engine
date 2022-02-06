public class Main {
    public static void main(String[] args) {
        Matrix matrixOne = new Matrix( new double[][] { {1, 0}, {0, 1} } );
        Matrix matrixTwo = new Matrix( new double[][] { {1, 0}, {0, 1} } );
        Matrix matrixThree = MatrixOperations.multiply(matrixOne, matrixTwo);

        matrixOne.display();
        matrixTwo.display();
        matrixThree.display();
    }
}

