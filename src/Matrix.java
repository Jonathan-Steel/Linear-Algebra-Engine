import java.text.DecimalFormat;

public class Matrix {
    private final int height;
    private final int width;
    private double[][] matrix;

    public Matrix(int height, int width)
    {
        this.height = height;
        this.width = width;
        this.matrix = new double[height][width];
    }

    public Matrix(double[][] init)
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

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrixCell(int row, int col, double value) {
        matrix[row][col] = value;
    }

    public double[] getMatrixCol(int col) {
        double[] colArray = new double[height];
        for (int i = 0; i < matrix.length; ++i) {
            colArray[i] = matrix[i][col];
        }
        return colArray;
    }

    public void display() {

        // Decimal Format
        DecimalFormat threeDP = new DecimalFormat("###.###");

        System.out.println();
        for (double[] row : matrix)
        {
            System.out.print("| ");
            for (double item : row)
            {
                System.out.print("\t" + threeDP.format(item) + "\t");
            }
            System.out.println(" |");
        }
        System.out.println();
    }

}
