import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem04LongestIncreasingSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        int[] arr = new int[input.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int count = 1;
        int longestSequence = 0;
        List<Integer> list = new ArrayList<>();
        List<Integer> longestList = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                list.add(arr[i + 1]);
                count++;
            } else {
                if (longestSequence < count) {
                    longestSequence = count;
                    longestList.clear();
                    longestList.addAll(list);
                }
                count = 1;
                System.out.println(list);
                list.clear();
                list.add(arr[i + 1]);
            }
        }
        System.out.println(list);
        if (longestSequence < count) {
            longestSequence = count;
            longestList.clear();
            longestList.addAll(list);
        }
        System.out.println("Longest: " + longestList);
    }
}
