import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem03BasicMarkUpLanguage {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int currCommand = 1;
        Pattern inversePattern = Pattern.compile("\\s*<\\s*inverse\\s*content\\s*=\\s*\"(.+)\"\\s*\\/\\s*>\\s*");
        Pattern reversePattern = Pattern.compile("\\s*<\\s*reverse\\s*content\\s*=\\s*\"(.+)\"\\s*\\/\\s*>\\s*");
        Pattern repeatPattern = Pattern.compile("\\s*<\\s*repeat\\s*value\\s*=\\s*\"(\\d+)\"\\s*content\\s*=\\s*\"(.+)\"\\s*\\/\\s*>\\s*");


        String command = scan.nextLine();
        while (!command.equals("<stop/>")) {
            if (command.matches("\\s*<\\s*inverse\\s*content\\s*=\\s*\"(.+)\"\\s*\\/\\s*>\\s*")) {
                Matcher matcher = inversePattern.matcher(command);
                String line = "";
                while (matcher.find()) {
                    line = matcher.group(1);
                }

                String result = inverseString(line);
                System.out.println(currCommand + ". " + result);
                currCommand++;
            } else if (command.matches("\\s*<\\s*reverse\\s*content\\s*=\\s*\"(.+)\"\\s*\\/\\s*>\\s*")) {
                Matcher matcher = reversePattern.matcher(command);
                String line = "";
                while (matcher.find()) {
                    line = matcher.group(1);
                }

                String result = reverseString(line);
                System.out.println(currCommand + ". " + result);
                currCommand++;

            } else if (command.matches("\\s*<\\s*repeat\\s*value\\s*=\\s*\"(\\d+)\"\\s*content\\s*=\\s*\"(.+)\"\\s*\\/\\s*>\\s*")) {
                Matcher matcher = repeatPattern.matcher(command);
                String line = "";
                int value = 0;
                while (matcher.find()) {
                    value = Integer.parseInt(matcher.group(1));
                    line = matcher.group(2);
                }

                for (int i = 0; i < value; i++) {
                    System.out.println(currCommand + ". " + line);
                    currCommand++;
                }
            }

            command = scan.nextLine();
        }
    }

    private static String inverseString(String str) {
        String result = "";
        char[] array = str.toCharArray();

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 'A' && array[i] <= 'Z') {
                result += (char)(array[i] + 32);
            } else if (array[i] >= 'a' && array[i] <= 'z') {
                result += (char)(array[i] - 32);
            } else {
                result += (char)array[i];
            }
        }

        return result;
    }

    private static String reverseString(String str) {
        char[] array = str.toCharArray();
        String reslut = "";

        for (int i = array.length - 1; i >= 0 ; i--) {
            reslut += (char)array[i];
        }

        return reslut;
    }
}
