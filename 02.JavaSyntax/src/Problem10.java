import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String regex = "([a-zA-Z][a-zA-z]+)";
        Pattern pat = Pattern.compile(regex);
        Matcher matcher = pat.matcher(input);
        while (matcher.find()) {
            System.out.printf("%s ", matcher.group());
        }
        System.out.println();
    }
}
