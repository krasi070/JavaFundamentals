import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem04Events {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashMap<String, HashMap<String, ArrayList<String>>> eventInfo = new HashMap<>();
        Pattern pattern = Pattern.compile("^#([A-Za-z]+):\\s*@([A-Za-z]+)\\s*(([0-1][0-9]|2[0-3]):([0-5][0-9]))$");
        int numberOfEvents = Integer.parseInt(scan.nextLine());

        for (int currEvent = 0; currEvent < numberOfEvents; currEvent++) {
            String event = scan.nextLine();
            Matcher matcher = pattern.matcher(event);
            Matcher secondMatcher = pattern.matcher(event);
            if (matcher.find()) {
                while (secondMatcher.find()) {
                    String person = secondMatcher.group(1);
                    String location = secondMatcher.group(2);
                    String time = secondMatcher.group(3);

                    if (!eventInfo.containsKey(location)) {
                        eventInfo.put(location, new HashMap<>());
                    }

                    if (!eventInfo.get(location).containsKey(person)) {
                        eventInfo.get(location).put(person, new ArrayList<>());
                    }

                    eventInfo.get(location).get(person).add(time);
                }
            }
        }

        Comparator<String> nameComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        String[] wantedLocations = scan.nextLine().split(",");
        ArrayList<String> wantedLocationsList = new ArrayList<>();
        for (String location : wantedLocations) {
            wantedLocationsList.add(location);
        }

        wantedLocationsList.sort(nameComparator);

        Comparator<String> timeComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] firstTime = o1.split(":");
                int firstHour = Integer.parseInt(firstTime[0]);
                int firstMinutes = Integer.parseInt(firstTime[1]);

                String[] secondTime = o2.split(":");
                int secondHour = Integer.parseInt(secondTime[0]);
                int secondMinutes = Integer.parseInt(secondTime[1]);

                int comparer = Integer.compare(firstHour, secondHour);
                if (comparer == 0) {
                    return Integer.compare(firstMinutes, secondMinutes);
                }

                return comparer;
            }
        };

        for (String location : wantedLocationsList) {
            System.out.println(location + ":");
            int personCounter = 1;
            List<String> people = eventInfo.get(location).keySet()
                    .stream()
                    .map(s -> s.toString())
                    .collect(Collectors.toList());
            people.sort(nameComparator);

            for (String person : people) {
                ArrayList<String> times = eventInfo.get(location).get(person);
                times.sort(timeComparator);

                System.out.println(personCounter + ". " + person + " -> " + String.join(", ", times));

                personCounter++;
            }
        }
    }
}
