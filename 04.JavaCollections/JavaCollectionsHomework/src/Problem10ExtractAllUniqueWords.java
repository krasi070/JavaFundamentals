import java.util.Scanner;
import java.util.TreeSet;

public class Problem10ExtractAllUniqueWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arr = scan.nextLine().toLowerCase().split("[^a-zA-Z]+");
        TreeSet<String> set = new TreeSet<>();
        for (String s : arr) {
            set.add(s);
        }
        System.out.println(set);
    }
}
