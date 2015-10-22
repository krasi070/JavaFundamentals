import java.util.Scanner;

public class Problem05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int decimalNumber = scan.nextInt();
        int timesTen = 1;
        int sevenBaseNumber = 0;
        do {
            sevenBaseNumber += (decimalNumber % 7) * timesTen;
            decimalNumber /= 7;
            timesTen *= 10;
        }
        while (decimalNumber != 0);
        System.out.println(sevenBaseNumber);
    }
}
