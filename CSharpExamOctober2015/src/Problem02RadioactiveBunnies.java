import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem02RadioactiveBunnies {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);
        String[][] matrix = new String[rows][cols];
        int characterCurrRow = 0;
        int characterCurrCol = 0;
        for (int i = 0; i < rows; i++) {
            String inputLine = scan.nextLine();
            for (int j = 0; j < cols; j++) {
                if (inputLine.charAt(j) == '.') {
                    matrix[i][j] = ".";
                } else if (inputLine.charAt(j) == 'B') {
                    matrix[i][j] = "B";
                } else if (inputLine.charAt(j) == 'P') {
                    matrix[i][j] = "P";
                    characterCurrRow = i;
                    characterCurrCol = j;
                }
            }
        }
        String commands = scan.nextLine().toUpperCase();

        for (int i = 0; i < commands.length(); i++) {
            boolean win = false;
            switch (commands.charAt(i)) {
                case 'R':
                    if (characterCurrCol == cols - 1) {
                        matrix[characterCurrRow][characterCurrCol] = ".";
                    } else if (matrix[characterCurrRow][characterCurrCol + 1].equals(".")) {
                        matrix[characterCurrRow][characterCurrCol + 1] = "P";
                        matrix[characterCurrRow][characterCurrCol] = ".";
                        characterCurrCol++;
                    } else if (matrix[characterCurrRow][characterCurrCol + 1].equals("B")) {
                        matrix[characterCurrRow][characterCurrCol] = ".";
                        characterCurrCol++;
                    }
                    break;
                case 'L':
                    if (characterCurrCol == 0) {
                        matrix[characterCurrRow][characterCurrCol] = ".";
                    } else if (matrix[characterCurrRow][characterCurrCol - 1].equals(".")) {
                        matrix[characterCurrRow][characterCurrCol - 1] = "P";
                        matrix[characterCurrRow][characterCurrCol] = ".";
                        characterCurrCol--;
                    } else if (matrix[characterCurrRow][characterCurrCol - 1].equals("B")) {
                        matrix[characterCurrRow][characterCurrCol] = ".";
                        characterCurrCol--;
                    }
                    break;
                case 'U':
                    if (characterCurrRow == 0) {
                        matrix[characterCurrRow][characterCurrCol] = ".";
                    } else if (matrix[characterCurrRow - 1][characterCurrCol].equals(".")) {
                        matrix[characterCurrRow - 1][characterCurrCol] = "P";
                        matrix[characterCurrRow][characterCurrCol] = ".";
                        characterCurrRow--;
                    } else if (matrix[characterCurrRow - 1][characterCurrCol].equals("B")) {
                        matrix[characterCurrRow][characterCurrCol] = ".";
                        characterCurrRow--;
                    }
                    break;
                case 'D':
                    if (characterCurrRow == rows - 1) {
                        matrix[characterCurrRow][characterCurrCol] = ".";
                    } else if (matrix[characterCurrRow + 1][characterCurrCol].equals(".")) {
                        matrix[characterCurrRow + 1][characterCurrCol] = "P";
                        matrix[characterCurrRow][characterCurrCol] = ".";
                        characterCurrRow++;
                    } else if (matrix[characterCurrRow + 1][characterCurrCol].equals("B")) {
                        matrix[characterCurrRow][characterCurrCol] = ".";
                        characterCurrRow++;
                    }
                    break;
            }
            if (matrix[characterCurrRow][characterCurrCol].equals(".")) {
                win = true;
            }
            spreadBunnies(matrix);
            if (!matrix[characterCurrRow][characterCurrCol].equals("P")) {
                if (win) {
                    playerWin(matrix, characterCurrRow, characterCurrCol);
                    break;
                } else {
                    playerLose(matrix, characterCurrRow, characterCurrCol);
                    break;
                }
            }
        }
    }
    public static void spreadBunnies(String[][] matrix) {
        List<String> babyBunnies = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("B") && !babyBunnies.contains(i + "" + j)) {
                    if (!matrix[Math.max(i - 1, 0)][j].equals("B")) {
                        matrix[Math.max(i - 1, 0)][j] = "B";
                        babyBunnies.add((i - 1) + "" + j);
                    }
                    if (!matrix[Math.min(i + 1, matrix.length - 1)][j].equals("B")) {
                        matrix[Math.min(i + 1, matrix.length - 1)][j] = "B";
                        babyBunnies.add((i + 1) + "" + j);
                    }
                    if (!matrix[i][Math.max(j - 1, 0)].equals("B")) {
                        matrix[i][Math.max(j - 1, 0)] = "B";
                        babyBunnies.add(i + "" + (j - 1));
                    }
                    if (!matrix[i][Math.min(j + 1, matrix[i].length - 1)].equals("B")) {
                        matrix[i][Math.min(j + 1, matrix[i].length - 1)] = "B";
                        babyBunnies.add(i + "" + (j + 1));
                    }
                }
            }
        }
    }
    public static void playerWin (String[][] matrix, int characterCurrRow, int characterCurrCol) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.printf("won: %d %d\n", characterCurrRow, characterCurrCol);
    }
    public static void playerLose (String[][] matrix, int characterCurrRow, int characterCurrCol) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.printf("dead: %d %d\n", characterCurrRow, characterCurrCol);
    }
}
