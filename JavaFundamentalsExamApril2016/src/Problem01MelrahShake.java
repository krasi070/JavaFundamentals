import java.util.Scanner;

public class Problem01MelrahShake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        String pattern = scan.nextLine();

        while (!text.equals(shake(text, pattern))){
            text = shake(text, pattern);
            int index = pattern.length() / 2;
            pattern = pattern.substring(0, index) + pattern.substring(index + 1);
            System.out.println("Shaked it.");
        }

        System.out.println("No shake.");
        System.out.println(text);
    }

    private static String shake(String text, String pattern){
        int start = text.indexOf(pattern);
        int end = text.lastIndexOf(pattern);

        if ((start != -1 || end != -1) && !(pattern.equals(""))){
            String result = text.substring(0, start) + text.substring(start + pattern.length(), end) + text.substring(end + pattern.length());

            return result;
        }
        else {
            return text;
        }
    }
}
