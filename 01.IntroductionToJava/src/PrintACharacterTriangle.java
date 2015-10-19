import java.util.ArrayList;
import java.util.Scanner;

public class PrintACharacterTriangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = Integer.parseInt(sc.nextLine());
        ArrayList<Character> list = new ArrayList<>();
        for (char i = 'a'; i < input * 2 - 1 + 'a'; i++) {
            if (i < input + 'a') {
                list.add(i);
                for (int j = 0; j < list.size(); j++) {
                    System.out.print(list.get(j) + " ");
                }
            }
            else {
                list.remove(list.size() - 1);
                for (int j = 0; j < list.size(); j++) {
                    System.out.print(list.get(j) + " ");
                }
            }
            System.out.println();
        }
    }
}
