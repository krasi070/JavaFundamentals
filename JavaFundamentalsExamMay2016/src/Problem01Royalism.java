import java.util.ArrayList;
import java.util.Scanner;

public class Problem01Royalism {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] strings = scan.nextLine().split("\\s+");
        ArrayList<String> royalists = new ArrayList<>();
        ArrayList<String> nonRoyalists = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            int sum = 0;
            for (int j = 0; j < strings[i].length(); j++) {
                sum += strings[i].charAt(j);
                while (sum > 26) {
                    sum -= 26;
                }
            }

            if (sum == 18) {
                royalists.add(strings[i]);
            } else {
                nonRoyalists.add(strings[i]);
            }
        }

        if (royalists.size() >= nonRoyalists.size()) {
            System.out.println("Royalists - " + royalists.size());
            for (String royalist : royalists) {
                System.out.println(royalist);
            }

            System.out.println("All hail Royal!");
        } else {
            for (String nonRoyalist : nonRoyalists) {
                System.out.println(nonRoyalist);
            }

            System.out.println("Royalism, Declined!");
        }
    }
}