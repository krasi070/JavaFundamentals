import java.util.Scanner;

public class Problem02Monopoly {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] dimensions = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        char[][] matrix = readMatrix(rows, cols, scan);
        int currTurn = 0;
        int numberOfHotels = 0;
        int money = 50;
        int timeInJail = 0;

        for (int currRow = 0; currRow < rows; currRow++) {
            if (currRow % 2 == 0) {
                for (int currCol = 0; currCol < cols; currCol++) {
                    if (timeInJail <= 0) {
                        switch (matrix[currRow][currCol]) {
                            case 'H':
                                int spentMoney = money;
                                money = 0;
                                numberOfHotels++;
                                System.out.println("Bought a hotel for " + spentMoney + ". Total hotels: " + numberOfHotels + ".");
                                break;
                            case 'S':
                                int shopMoney = (currCol + 1) * (currRow + 1);
                                System.out.println("Spent " + Math.min(shopMoney, money) + " money at the shop.");
                                money -= Math.min(shopMoney, money);
                                break;
                            case 'J':
                                timeInJail = 3;
                                System.out.println("Gone to jail at turn " + currTurn + ".");
                                break;
                        }
                    }

                    currTurn++;
                    money += numberOfHotels * 10;
                    if (timeInJail > 0) {
                        timeInJail--;
                        if (timeInJail != 0) {
                            currCol--;
                        }
                    }
                }
            } else {
                for (int currCol = cols - 1; currCol >= 0; currCol--) {
                    if (timeInJail <= 0) {
                        switch (matrix[currRow][currCol]) {
                            case 'H':
                                int spentMoney = money;
                                money = 0;
                                numberOfHotels++;
                                System.out.println("Bought a hotel for " + spentMoney + ". Total hotels: " + numberOfHotels + ".");
                                break;
                            case 'S':
                                int shopMoney = (currCol + 1) * (currRow + 1);
                                System.out.println("Spent " + Math.min(shopMoney, money) + " money at the shop.");
                                money -= Math.min(shopMoney, money);
                                break;
                            case 'J':
                                timeInJail = 3;
                                System.out.println("Gone to jail at turn " + currTurn + ".");
                                break;
                        }
                    }

                    currTurn++;
                    money += numberOfHotels * 10;
                    if (timeInJail > 0) {
                        timeInJail--;
                        if (timeInJail != 0) {
                            currCol++;
                        }
                    }
                }
            }
        }

        System.out.println("Turns " + currTurn);
        System.out.println("Money " + money);
    }
    
    private static char[][] readMatrix(int rows, int cols, Scanner scan) {
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            char[] currRow = scan.nextLine().trim().toCharArray();
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = currRow[j];
            }
        }

        return matrix;
    } 
}
