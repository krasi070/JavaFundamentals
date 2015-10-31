import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem03LargestSequenceOfEqualStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arr = scan.nextLine().split("\\s+");
        int count = 1;
        int longestSequence = 0;
        List<String> list = new ArrayList<>();
        List<String> longestList = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].equals(arr[i + 1])) {
                list.add(arr[i + 1]);
                count++;
            } else {
                if (longestSequence < count) {
                    longestSequence = count;
                    longestList.clear();
                    longestList.addAll(list);
                }
                count = 1;
                list.clear();
                list.add(arr[i + 1]);
            }
        }
        if (longestSequence < count) {
            longestSequence = count;
            longestList.clear();
            longestList.addAll(list);
        }
        System.out.println(longestList);
    }
}
