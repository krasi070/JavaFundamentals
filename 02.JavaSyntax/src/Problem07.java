import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Problem07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        do {
            int temp = random.nextInt(Math.abs(n - m) + 1) + Math.min(n, m);
            if (!list.contains(temp)) {
                list.add(temp);
                System.out.print(temp + " ");
            }
        }
        while (list.size() != Math.abs(n - m) + 1);
        System.out.println();
    }
}
