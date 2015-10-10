package _1_matrix_filling;

import java.util.Random;

public class MatrixFilling {

    public static void main(String[] args) {
        Random random = new Random();
        int width = random.nextInt(20) + 5;
        int height = random.nextInt(20) + width;
        String[][] matrix = new String[height][width];

        for (int rowIndex = 0; rowIndex < height; rowIndex++) {
            for (int colIndex = 0; colIndex < width; colIndex++) {
                if (rowIndex % width == colIndex | (width - rowIndex % width) == colIndex + 1)
                    matrix[rowIndex][colIndex] = "X";
                else
                    matrix[rowIndex][colIndex] = ".";
                System.out.print(matrix[rowIndex][colIndex] + " ");
            }
            System.out.println();
        }
    }
}