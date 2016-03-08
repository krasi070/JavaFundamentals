import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem04SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Integer>> map = new LinkedHashMap<>();
        String venue = "";
        String singer = "";
        int totalMoney = 0;

        String lineOfInput = scan.nextLine();
        while (!lineOfInput.equals("End")) {
            Pattern pat = Pattern.compile("([A-Za-z ]+) @([A-Za-z ]+) ([0-9]+) ([0-9]+)");
            Matcher matcher = pat.matcher(lineOfInput);
            Matcher tempMatcher = pat.matcher(lineOfInput);
            if (tempMatcher.find()) {
                while (matcher.find()) {
                    singer = matcher.group(1);
                    venue = matcher.group(2);
                    int ticketPrice = Integer.parseInt(matcher.group(3));
                    int ticketCount = Integer.parseInt(matcher.group(4));
                    totalMoney = ticketPrice * ticketCount;
                }
                if (!map.containsKey(venue)) {
                    map.put(venue, new LinkedHashMap<>());
                }
                if (!map.get(venue).containsKey(singer)) {
                    map.get(venue).put(singer, totalMoney);
                } else {
                    int money = map.get(venue).get(singer) + totalMoney;
                    map.get(venue).put(singer, money);
                }
            }
            lineOfInput = scan.nextLine();
        }

        for (String v : map.keySet()) {
            System.out.println(v);
            map.get(v).keySet().stream()
                    .sorted((s1, s2) -> map.get(v).get(s2).compareTo(map.get(v).get(s1)))
                    .forEach(s -> System.out.printf("#  %s -> %d\n", s, map.get(v).get(s)));
        }
    }
}
