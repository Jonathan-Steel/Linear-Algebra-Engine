import java.util.ArrayList;

public class Matrix {
    private final int height;
    private final int width;
    private int[][] matrix;

    public Matrix(int height, int width)
    {
        this.height = height;
        this.width = width;
        this.matrix = new int[height][width];
    }

    public Matrix(int[][] init)
    {
        this.height = init.length;
        this.width = init[0].length;
        this.matrix = init;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrixCell(int row, int col, int value) {
        matrix[row][col] = value;
    }

    public int[] getMatrixCol(int col) {
        int[] colArray = new int[height];
        for (int i = 0; i < matrix.length; ++i) {
            colArray[i] = matrix[i][col];
        }
        return colArray;
    }

    public void display() {

        for (int[] row : matrix)
        {
            for (int item : row)
            {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

}
