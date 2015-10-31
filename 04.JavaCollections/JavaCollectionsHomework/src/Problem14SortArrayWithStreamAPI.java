import java.util.Arrays;
import java.util.Scanner;

public class Problem14SortArrayWithStreamAPI {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        int[] arr = new int[input.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        String sortingOrder = scan.nextLine();
        int[] endArr = Arrays.stream(arr).sorted().toArray();
        if (sortingOrder.equals("Ascending")) {
            for (int i : endArr) {
                System.out.print(i + " ");
            }
        } else if (sortingOrder.equals("Descending")) {
            for (int i = endArr.length - 1; i >= 0 ; i--) {
                System.out.print(endArr[i] + " ");
            }
        }

    }
}
