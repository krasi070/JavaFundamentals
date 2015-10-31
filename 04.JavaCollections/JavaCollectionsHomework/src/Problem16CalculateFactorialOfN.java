import java.util.Scanner;

public class Problem16CalculateFactorialOfN {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        calculateFactorial(n, 1);
    }
    public static void calculateFactorial (long n, long result) {
        if (n < 1) {
            System.out.println(result);
            return;
        }
        result *= n;
        calculateFactorial(n - 1, result);
    }
}
