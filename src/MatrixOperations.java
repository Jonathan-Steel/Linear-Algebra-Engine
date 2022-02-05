public class MatrixOperations {

    // Nullify
    public static Matrix nullify(Matrix matrix) {
        return new Matrix(matrix.getHeight(), matrix.getWidth());
    }

    // Addition
    public static Matrix add(Matrix firstMatrix, Matrix secondMatrix) {
        if (firstMatrix.getHeight() != secondMatrix.getHeight() || firstMatrix.getWidth() != secondMatrix.getWidth()) {
            throw new RuntimeException("The two matrices must have the same widths and heights");
        }
        else {
            Matrix newMatrix = new Matrix(firstMatrix.getHeight(), firstMatrix.getWidth());

            for (int i = 0; i < firstMatrix.getMatrix().length; ++i) {
                for (int j = 0; j < firstMatrix.getMatrix()[0].length; ++j) {
                    newMatrix.setMatrixCell(i, j, (firstMatrix.getMatrix()[i][j] + secondMatrix.getMatrix()[i][j]) );
                }
            }

            return newMatrix;
        }
    }

    // Subtraction
    public static Matrix subtract(Matrix firstMatrix, Matrix secondMatrix) {
        if (firstMatrix.getHeight() != secondMatrix.getHeight() || firstMatrix.getWidth() != secondMatrix.getWidth()) {
            throw new RuntimeException("The two matrices must have the same widths and heights");
        }
        else {
            Matrix newMatrix = new Matrix(firstMatrix.getHeight(), firstMatrix.getWidth());

            for (int i = 0; i < firstMatrix.getMatrix().length; ++i) {
                for (int j = 0; j < firstMatrix.getMatrix()[0].length; ++j) {
                    newMatrix.setMatrixCell(i, j, (firstMatrix.getMatrix()[i][j] - secondMatrix.getMatrix()[i][j]) );
                }
            }

            return newMatrix;
        }
    }

    // Multiplication
    public static Matrix multiply(Matrix firstMatrix, Matrix secondMatrix) {
        if (firstMatrix.getWidth() != secondMatrix.getHeight()) {
            throw new RuntimeException("The matrices must be of the form m x n and n x k, respectively.");
        } else {
            Matrix newMatrix = new Matrix(firstMatrix.getHeight(), secondMatrix.getWidth());
            for (int i = 0; i < firstMatrix.getHeight(); ++i) {
                for (int j = 0; j < secondMatrix.getWidth(); ++j) {
                    newMatrix.getMatrix()[i][j] = dot_product(firstMatrix.getMatrix()[i], secondMatrix.getMatrixCol(j));
                }
            }
            return newMatrix;
        }
    }

    // Transpose
    public static Matrix transpose(Matrix matrix) {
        Matrix transposedMatrix = new Matrix(matrix.getWidth(), matrix.getHeight());

        for (int i = 0; i < transposedMatrix.getHeight(); ++i) {
            for (int j = 0; j < transposedMatrix.getWidth(); ++j) {
                transposedMatrix.setMatrixCell(i, j, matrix.getMatrixCol(i)[j]);
            }
        }

        return transposedMatrix;
    }

    // Dot Product
    public static int dot_product(int[] firstVector, int[] secondVector) {
        int[] products = new int[firstVector.length];
        for (int i = 0; i < firstVector.length; ++i) {
            products[i] = firstVector[i] * secondVector[i];
        }
        int sum = 0;
        for (int value: products) {
            sum += value;
        }
        return sum;
    }

    public static int dot_product(Matrix firstMatrix, Matrix secondMatrix) {
        int[] firstVector = vector_to_array(firstMatrix);
        int[] secondVector = vector_to_array(secondMatrix);

        int[] products = new int[firstVector.length];
        for (int i = 0; i < firstVector.length; ++i) {
            products[i] = firstVector[i] * secondVector[i];
        }
        int sum = 0;
        for (int value: products) {
            sum += value;
        }
        return sum;
    }

    // Vector to Array
    public static int[] vector_to_array(Matrix matrix) {
        if (matrix.getHeight() == 1) {
            return matrix.getMatrix()[0];
        } else if (matrix.getWidth() == 1) {
            return matrix.getMatrixCol(0);
        } else {
            throw new RuntimeException("Please enter a vector not a matrix.");
        }
    }

    // Cross Product

    // Invert

    // Gaussian Elimination
}
