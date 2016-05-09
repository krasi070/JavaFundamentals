import java.util.Scanner;

public class Problem03RoyalFlush {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(scan.nextLine());
        int numberOfFlushes = 0;
        String flushRegex = "10JQKA";

        String spades = "";
        String hearts = "";
        String diamonds = "";
        String clubs = "";
        for (int i = 0; i < numberOfLines; i++) {
            String cards = scan.nextLine();

            for (int j = 0; j < cards.length(); j += 2) {
                String character = cards.charAt(j) == '1' ? "10" : cards.charAt(j) + "";
                if (character.equals("10")) {
                    j++;
                }

                if (cards.charAt(j + 1) == 's') {
                    spades += character;
                } else if (cards.charAt(j + 1) == 'h') {
                    hearts += character;
                } else if (cards.charAt(j + 1) == 'd') {
                    diamonds += character;
                } else if (cards.charAt(j + 1) == 'c') {
                    clubs += character;
                }

                if (spades.matches(".*" + flushRegex + ".*")) {
                    spades = spades.replaceFirst(flushRegex, "");
                    System.out.println("Royal Flush Found - Spades");
                    numberOfFlushes++;
                }

                if (hearts.matches(".*" + flushRegex + ".*")) {
                    hearts = hearts.replaceFirst(flushRegex, "");
                    System.out.println("Royal Flush Found - Hearts");
                    numberOfFlushes++;
                }

                if (diamonds.matches(".*" + flushRegex + ".*")) {
                    diamonds = diamonds.replaceFirst(flushRegex, "");
                    System.out.println("Royal Flush Found - Diamonds");
                    numberOfFlushes++;
                }

                if (clubs.matches(".*" + flushRegex + ".*")) {
                    clubs = clubs.replaceFirst(flushRegex, "");
                    System.out.println("Royal Flush Found - Clubs");
                    numberOfFlushes++;
                }
            }
        }

        System.out.println("Royal's Royal Flushes - " + numberOfFlushes + ".");
    }
}