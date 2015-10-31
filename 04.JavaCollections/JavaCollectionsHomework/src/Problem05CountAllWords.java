import java.util.Scanner;

public class Problem05CountAllWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arr = scan.nextLine().split("[^a-zA-Z]+");
        System.out.println(arr.length);
    }
}
