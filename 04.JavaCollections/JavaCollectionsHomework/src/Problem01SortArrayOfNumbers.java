import java.util.Arrays;
import java.util.Scanner;

public class Problem01SortArrayOfNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfElements = scan.nextInt();
        int[] arr = new int[numberOfElements];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
