import java.util.ArrayList;
import java.util.Scanner;

public class Problem14 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        char[] fstWord = input[0].toCharArray();
        char[] sndWord = input[1].toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < fstWord.length; i++) {
            if (list.contains(fstWord[i])) {
                if (list.indexOf(fstWord[i]) % 2 == 0) {
                    list.add(fstWord[i]);
                    list.add(list.get(list.indexOf(fstWord[i]) + 1));
                } else {
                    list.add(fstWord[i]);
                    list.add(sndWord[i]);
                }
            } else {
                list.add(fstWord[i]);
                list.add(sndWord[i]);
            }
        }
        char[] exchangableWord = new char[sndWord.length];
        int count = 0;
        for (int i = 0; i < exchangableWord.length; i++) {
            exchangableWord[i] = list.get(i * 2 + 1);
            if (exchangableWord[i] == sndWord[i]) {
                count++;
            }
        }
        if (count == sndWord.length) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
