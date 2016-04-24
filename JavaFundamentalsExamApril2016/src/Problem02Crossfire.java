import java.util.Scanner;

public class Problem02Crossfire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] dimensions = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] matrix = fillMatrix(rows, cols);

        String command = scan.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            String[] crossfireArgs = command.split("\\s+");
            long givenRow = Long.parseLong(crossfireArgs[0]);
            long givenCol = Long.parseLong(crossfireArgs[1]);
            long radius = Long.parseLong(crossfireArgs[2]);
            executeCrossfire(matrix, givenRow, givenCol, radius);
            resetMatrix(matrix);
            removeEmptyRows(matrix);

            command = scan.nextLine();
        }

        printMatrix(matrix);
    }

    private static void resetMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = j + 1; k < matrix[i].length; k++) {
                        if (matrix[i][k] != 0) {
                            matrix[i][j] = matrix[i][k];
                            matrix[i][k] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void removeEmptyRows(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = i; j < matrix.length - 1; j++) {
                    matrix[j] = matrix[j + 1];
                }

                matrix[matrix.length - 1] = new int[matrix[0].length];
            }
        }
    }

    private static void executeCrossfire(int[][] matrix, long row, long col, long radius) {
        if (row >= 0 && row < matrix.length) {
            for (long i = Math.max(0, col - radius); i < Math.min(matrix[0].length, col + radius + 1); i++) {
                matrix[(int)row][(int)i] = 0;
            }
        }

        if (col >= 0 && col < matrix[0].length) {
            for (long i = Math.max(0, row - radius); i < Math.min(matrix.length, row + radius + 1); i++) {
                matrix[(int)i][(int)col] = 0;
            }
        }
    }

    private static int[][] fillMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        int currNumber = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = currNumber;
                currNumber++;
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0){
                continue;
            }

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0){
                    System.out.print(matrix[i][j] + " ");
                }
                else {
                    break;
                }
            }

            System.out.println();
        }
    }
}
