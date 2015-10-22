import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        Pattern pattern = Pattern.compile("(\\b[A-Z][a-zA-Z]*[A-Z]\\b)");
        for (int i = 0; i < input.length; i++) {
            Matcher matcher = pattern.matcher(input[i]);
            if (matcher.find()) {
                System.out.printf("%s ", matcher.group());
            }
        }
        System.out.println();
    }
}
