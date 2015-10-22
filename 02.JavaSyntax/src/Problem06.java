import java.util.Scanner;

public class Problem06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sevenBaseNumber = scan.nextInt();
        int decimalNumber = 0;
        int timesSeven = 1;
        do {
            decimalNumber += (sevenBaseNumber % 10) * timesSeven;
            sevenBaseNumber /= 10;
            timesSeven *= 7;
        }
        while (sevenBaseNumber != 0);
        System.out.println(decimalNumber);
    }
}
