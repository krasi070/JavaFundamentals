import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem01FilterArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arr = scan.nextLine().split("\\s+");
        List<Integer> list = Arrays.stream(arr)
                .filter(s -> isNumber(s))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }
    public static boolean isNumber (String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                if (!(i == 0 && str.charAt(i) == '-')) {
                    return  false;
                }
            }
        }
        return true;
    }
}
