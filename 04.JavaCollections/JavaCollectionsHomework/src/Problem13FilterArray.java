import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem13FilterArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arr = scan.nextLine().split("\\s+");
        List<String> list = Arrays.stream(arr).filter(s -> s.length() > 3).collect(Collectors.toList());
        if (list.size() == 0) {
            System.out.println("(empty)");
        } else {
            System.out.println(list);
        }
    }
}
