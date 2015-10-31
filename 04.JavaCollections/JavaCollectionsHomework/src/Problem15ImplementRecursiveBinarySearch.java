import java.util.Scanner;

public class Problem15ImplementRecursiveBinarySearch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        String[] inputArr = scan.nextLine().split("\\s+");
        int[] arr = new int[inputArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(inputArr[i]);
        }
        binarySearch(arr, number, 0, arr.length - 1);
    }
    public static void binarySearch (int[] arr, int number, int start, int end) {
        int middle = (start + end) / 2;
        if (end < start) {
            System.out.println(-1);
            return;
        }
        if (number == arr[middle]) {
            System.out.println(middle);
        } else if (number > arr[middle]) {
            binarySearch(arr, number, middle + 1, end);
        } else if (number < arr[middle]) {
            binarySearch(arr, number, start, middle - 1);
        }
    }
}
