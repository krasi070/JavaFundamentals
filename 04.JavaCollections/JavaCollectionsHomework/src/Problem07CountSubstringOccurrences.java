import java.util.Scanner;

public class Problem07CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arr = scan.nextLine().toLowerCase().split("[^a-zA-Z]+");
        String substring = scan.next().toLowerCase();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length() - (substring.length() - 1); j++) {
                if (arr[i].substring(j, j + substring.length()).equals(substring)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
