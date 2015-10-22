import java.util.Locale;
import java.util.Scanner;

public class Problem04 {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US"));
        Scanner scan = new Scanner(System.in);
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();
        double fOne = Math.pow((a * a + b * b) / (a * a - b * b), (a + b + c) / Math.sqrt(c));
        double fTwo = Math.pow((a * a + b * b - c * c * c), a - b);
        double diff = Math.abs(average(a, b, c) - average(fOne, fTwo));
        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", fOne, fTwo, diff);
    }
    private static double average(double fstNumber, double sndNumber, double trdNumber) {
        double average = (fstNumber + sndNumber + trdNumber) / 3;
        return  average;
    }
    private static double average(double fstNumber, double sndNumber) {
        double average = (fstNumber + sndNumber) / 2;
        return average;
    }
}
