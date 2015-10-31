import java.util.*;

public class Problem12CardsFrequencies {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] cards = scan.nextLine().split("\\s+");
        List<String> faces = new ArrayList<>();
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < cards.length; i++) {
            faces.add(cards[i].substring(0, cards[i].length() - 1));
            set.add(cards[i].substring(0, cards[i].length() - 1));
        }
        List<String> list = new ArrayList<>();
        list.addAll(set);
        double appearances = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < faces.size(); j++) {
                if (list.get(i).equals(faces.get(j))) {
                    appearances++;
                }
            }
            double percentage = (appearances / faces.size()) * 100;
            System.out.printf("%s -> %.2f", list.get(i), percentage);
            System.out.println("%");
            appearances = 0;
        }
    }
}
