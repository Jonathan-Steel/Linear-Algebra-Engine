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

    public static Matrix addMany(Matrix[] matrices) {
        Matrix newMatrix = new Matrix(matrices[0].getHeight(), matrices[1].getWidth());
        for (Matrix matrix : matrices) {
            newMatrix = add(newMatrix, matrix);
        }
        return newMatrix;
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

    // Constant Multiplication
    public static Matrix constantMultiply(Matrix matrix, double constant) {
        Matrix newMatrix = new Matrix(matrix.getHeight(), matrix.getWidth());
        for (int i = 0; i < matrix.getHeight(); i++) {
            for (int j = 0; j < matrix.getWidth(); j++) {
                newMatrix.setMatrixCell(i, j, constant * matrix.getMatrix()[i][j]);
            }
        }
        return newMatrix;
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
    public static double dot_product(double[] firstVector, double[] secondVector) {
        double[] products = new double[firstVector.length];
        for (int i = 0; i < firstVector.length; ++i) {
            products[i] = firstVector[i] * secondVector[i];
        }
        double sum = 0;
        for (double value: products) {
            sum += value;
        }
        return sum;
    }

    public static double dot_product(Matrix firstMatrix, Matrix secondMatrix) {
        double[] firstVector = vector_to_array(firstMatrix);
        double[] secondVector = vector_to_array(secondMatrix);

        double[] products = new double[firstVector.length];
        for (int i = 0; i < firstVector.length; ++i) {
            products[i] = firstVector[i] * secondVector[i];
        }
        double sum = 0;
        for (double value: products) {
            sum += value;
        }
        return sum;
    }

    // Vector to Array
    public static double[] vector_to_array(Matrix matrix) {
        if (matrix.getHeight() == 1) {
            return matrix.getMatrix()[0];
        } else if (matrix.getWidth() == 1) {
            return matrix.getMatrixCol(0);
        } else {
            throw new RuntimeException("Please enter a vector not a matrix.");
        }
    }

    // Cross Product
    public static double[] cross_product(double[] firstVector, double[] secondVector) {
        if (firstVector.length != 3 || secondVector.length != 3) {
            throw new RuntimeException("Please enter a 3x1 vector.");
        }
        return new double[] {firstVector[1] * secondVector[2] - firstVector[2] * secondVector[1],
                             firstVector[2] * secondVector[0] - firstVector[0] * secondVector[2],
                             firstVector[0] * secondVector[1] - firstVector[1] * secondVector[0]};
    }

    // Determinant
    public static Matrix determinant(Matrix matrix) {
        if (matrix.getHeight() != matrix.getWidth()) {
            throw new RuntimeException("You can only calculate determinants of nxn matrices");
        }
        if (matrix.getHeight() == 1) {
            return matrix;
        }
        Matrix[] sumArray = new Matrix[matrix.getWidth()];
        for (int i = 0; i < matrix.getWidth(); i++) {
            sumArray[i] = constantMultiply(cofactor(matrix, 0, i), matrix.getMatrix()[0][i]);
        }
        return addMany(sumArray);
    }

    // Cofactor
    public static Matrix cofactor(Matrix matrix, int row, int col) {
        if (matrix.getHeight() != matrix.getWidth()) {
            throw new RuntimeException("You can only calculate determinants of nxn matrices");
        }
        return constantMultiply( determinant( deleteCol( deleteRow(matrix, row) , col ) ), Math.pow(-1, row + col) );
    }

    public static Matrix deleteRow(Matrix matrix, int row) {
        if (matrix.getHeight() == 1) {
            throw new RuntimeException("The matrix must be taller than a 1xn");
        }

        Matrix newMatrix = new Matrix(matrix.getHeight() - 1, matrix.getWidth());

        int i2 = 0, j2 = 0;
        for (int i = 0; i < matrix.getHeight(); i++) {
            if (i == row) {
                continue;
            }
            j2 = 0;
            for (int j = 0; j < matrix.getWidth(); j++) {
                newMatrix.setMatrixCell(i2, j2, matrix.getMatrix()[i][j]);
                j2++;
            }
            i2++;
        }

        return newMatrix;
    }

    public static Matrix deleteCol(Matrix matrix, int col) {
        if (matrix.getWidth() == 1) {
            throw new RuntimeException("The matrix must be taller than a nx1");
        }

        Matrix newMatrix = new Matrix(matrix.getHeight(), matrix.getWidth() - 1);

        int i2 = 0, j2 = 0;
        for (int i = 0; i < matrix.getHeight(); i++) {
            j2 = 0;
            for (int j = 0; j < matrix.getWidth(); j++) {
                if (j == col) {
                    continue;
                }
                newMatrix.setMatrixCell(i2, j2, matrix.getMatrix()[i][j]);
                j2++;
            }
            i2++;
        }

        return newMatrix;
    }

    // Eigenvalues

    // Eigenvectors

    // Invert

    // ----------------------------------

    // Diagonalise

    // Gaussian Elimination
}
