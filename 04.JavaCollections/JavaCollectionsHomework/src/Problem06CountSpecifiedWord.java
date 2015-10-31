import java.util.Scanner;

public class Problem06CountSpecifiedWord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arr = scan.nextLine().toLowerCase().split("[^a-zA-Z]+");
        String specifiedWord = scan.nextLine().toLowerCase();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(specifiedWord)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
