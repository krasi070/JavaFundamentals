import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem08ExtractEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        Pattern pattern = Pattern.compile("([a-zA-Z0-9]+([a-zA-Z._0-9]|[-])+[a-zA-Z0-9]@([a-zA-Z0-9]+[.-])+[a-zA-Z0-9]+)");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}
