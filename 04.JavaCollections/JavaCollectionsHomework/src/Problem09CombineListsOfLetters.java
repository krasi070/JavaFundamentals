import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem09CombineListsOfLetters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] fstArr = scan.nextLine().split("\\s+");
        List<String> fstList = Arrays.asList(fstArr);
        String[] sndArr = scan.nextLine().split("\\s+");
        List<String> sndList = Arrays.asList(sndArr);
        List<String> combinedList = new ArrayList<>();
        combinedList.addAll(fstList);
        for (int i = 0; i < sndList.size(); i++) {
            if (!fstList.contains(sndList.get(i))) {
                combinedList.add(sndList.get(i));
            }
        }
        System.out.println(combinedList);
    }
}
