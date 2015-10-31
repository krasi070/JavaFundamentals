import java.util.Scanner;
import java.util.TreeSet;

public class Problem11MostFrequentWord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arr = scan.nextLine().toLowerCase().split("[^a-zA-Z]+");
        TreeSet<String> set = new TreeSet<>();
        int count = 0;
        int longestWord = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i].equals(arr[j])) {
                    count++;
                    if (longestWord < count) {
                        longestWord = count;
                        set.clear();
                        set.add(arr[i]);
                    } else if (longestWord == count) {
                        set.add(arr[i]);
                    }
                }
            }
            count = 0;
        }
        for (String s : set) {
            System.out.println(s + " -> " + longestWord + " time(s)");
        }
    }
}
