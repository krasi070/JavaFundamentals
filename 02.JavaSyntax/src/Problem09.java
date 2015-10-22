import java.util.Scanner;

public class Problem09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int target = scan.nextInt();
        for (int i = Math.max(1, target - 20); i < 21; i++) {
            if (i <= target) {
                System.out.printf("%d + %d = %d\n", i, target - i, target);
            } else {
                System.out.printf("%d - %d = %d\n", i, i - target, target);
            }
        }
    }
}
