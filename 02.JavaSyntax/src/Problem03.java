import java.util.Locale;
import java.util.Scanner;

public class Problem03 {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US"));
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        double b = scan.nextDouble();
        double c = scan.nextDouble();
        System.out.printf("|%-10X|%s|%10.2f|%-10.3f|", a, String.format("%10s", Integer.toBinaryString(a)).replace(" ", "0"), b, c);
        System.out.println();
    }
}
