import java.util.Scanner;

public class Problem12 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        String fstString = input[0];
        String sndString = input[1];
        System.out.println(multiplyCharacters(fstString, sndString));
    }
    private static int multiplyCharacters(String fstString, String sndString) {
        int result = 0;
        char[] fstStringArr = fstString.toCharArray();
        char[] sndStringArr = sndString.toCharArray();
        for (int i = 0; i < Math.max(fstStringArr.length, sndStringArr.length); i++) {
            if (i < Math.min(fstStringArr.length, sndStringArr.length)) {
                result += fstStringArr[i] * sndStringArr[i];
            } else {
                if (fstStringArr.length > sndStringArr.length) {
                    result += fstStringArr[i];
                } else {
                    result += sndStringArr[i];
                }
            }
        }
        return result;
    }
}
