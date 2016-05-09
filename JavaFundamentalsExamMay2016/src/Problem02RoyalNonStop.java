import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Problem02RoyalNonStop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String dimensions = scan.nextLine();
        String[] prices = scan.nextLine().split("\\s+");
        BigDecimal lukankaPrice = new BigDecimal(prices[0]);
        BigDecimal rakijaPrice = new BigDecimal(prices[1]);

        int numberOfCustomers = 0;
        BigDecimal moneyEarned = BigDecimal.valueOf(0);
        String line = scan.nextLine();
        while (!line.equals("Royal Close")) {
            String[] target = line.split("\\s+");
            long targetRow = Long.parseLong(target[0]);
            long targetCol = Long.parseLong(target[1]);
            moneyEarned = moneyEarned.add(sellCustomerProducts(targetRow, targetCol, lukankaPrice, rakijaPrice));

            numberOfCustomers++;
            line = scan.nextLine();
        }

        DecimalFormat decimalFormat = new DecimalFormat("0.000000");
        System.out.println(decimalFormat.format(moneyEarned));
        System.out.println(numberOfCustomers);
    }

    private static BigDecimal sellCustomerProducts(long row, long col, BigDecimal lukankaPrice, BigDecimal rakijaPrice) {
        BigDecimal amountSpent = BigDecimal.valueOf(0);
        if (row >= col) {
            for (long currCol = col; currCol >= 0; currCol--) {
                if (row % 2 == 0 && (row != 0 || currCol != 0)) {
                    amountSpent = amountSpent.add(lukankaPrice.multiply(BigDecimal.valueOf((row + 1) * (currCol + 1))));
                } else if (row % 2 == 1 && (row != 0 || currCol != 0)) {
                    amountSpent = amountSpent.add(rakijaPrice.multiply(BigDecimal.valueOf((row + 1) * (currCol + 1))));
                }
            }

            for (long currRow = row - 1; currRow > 0; currRow--) {
                if (currRow % 2 == 0) {
                    amountSpent = amountSpent.add(lukankaPrice.multiply(BigDecimal.valueOf(currRow + 1)));
                } else {
                    amountSpent = amountSpent.add(rakijaPrice.multiply(BigDecimal.valueOf(currRow + 1)));
                }
            }
        } else {
            for (long currRow = row; currRow >= 0; currRow--) {
                if (currRow % 2 == 0 && (currRow != 0 || col != 0)) {
                    amountSpent = amountSpent.add(lukankaPrice.multiply(BigDecimal.valueOf((currRow + 1) * (col + 1))));
                } else if (currRow % 2 == 1 && (currRow != 0 || col != 0)) {
                    amountSpent = amountSpent.add(rakijaPrice.multiply(BigDecimal.valueOf((currRow + 1) * (col + 1))));
                }
            }

            for (long currCol = col - 1; currCol > 0; currCol--) {
                    amountSpent = amountSpent.add(lukankaPrice.multiply(BigDecimal.valueOf(currCol + 1)));
            }
        }

        return amountSpent;
    }
}
