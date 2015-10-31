import java.util.Scanner;

public class Problem02SequenceOfEqualStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arr = scan.nextLine().split("\\s+");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
            if (!arr[i].equals(arr[i + 1])) {
                System.out.println();
            }
        }
        System.out.print(arr[arr.length - 1]);
    }
}
