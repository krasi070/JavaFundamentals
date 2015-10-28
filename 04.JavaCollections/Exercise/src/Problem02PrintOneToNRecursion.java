import java.util.Scanner;

public class Problem02PrintOneToNRecursion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        printRecursive(1, n);
    }
    public static void printRecursive (int i, int n) {
        if (i > n) {
            return;
        }
        System.out.println(i);
        printRecursive(i + 1, n);
    }
}
