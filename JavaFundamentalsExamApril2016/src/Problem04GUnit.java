import java.util.*;
import java.util.regex.Pattern;

public class Problem04GUnit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = "([A-Z][A-Za-z0-9]+) \\| ([A-Z][A-Za-z0-9]+) \\| ([A-Z][A-Za-z0-9]+)";
        HashMap<String, HashMap<String, HashSet<String>>> classes = new HashMap<>();
        String line = scan.nextLine();

        while (!line.equals("It's testing time!")) {
            if (line.matches(regex)) {
                String[] testArgs = line.split(" \\| ");
                String className = testArgs[0];
                String methodName = testArgs[1];
                String testName = testArgs[2];

                if (!classes.containsKey(className)) {
                    classes.put(className, new HashMap<>());
                }

                if (!classes.get(className).containsKey(methodName)) {
                    classes.get(className).put(methodName, new HashSet<>());
                }

                classes.get(className).get(methodName).add(testName);
            }

            line = scan.nextLine();
        }

        Comparator<Map.Entry<String, HashMap<String, HashSet<String>>>> classComparator =
                new Comparator<Map.Entry<String, HashMap<String, HashSet<String>>>>() {
            @Override
            public int compare(
                    Map.Entry<String, HashMap<String, HashSet<String>>> o1,
                    Map.Entry<String, HashMap<String, HashSet<String>>> o2) {
                int unitTests1 = 0;
                int unitTests2 = 0;
                int methods1 = o1.getValue().size();
                int methods2 = o2.getValue().size();

                for (Map.Entry<String, HashSet<String>> method : o1.getValue().entrySet()) {
                    unitTests1 += method.getValue().size();
                }

                for (Map.Entry<String, HashSet<String>> method : o2.getValue().entrySet()) {
                    unitTests2 += method.getValue().size();
                }

                int compareTests = Integer.compare(unitTests2, unitTests1);
                if (compareTests == 0) {
                    int compareMethods = Integer.compare(methods1, methods2);
                    if (compareMethods == 0) {
                        return o1.getKey().compareTo(o2.getKey());
                    }

                    return compareMethods;
                }

                return compareTests;
            }
        };

        Comparator<Map.Entry<String, HashSet<String>>> methodComparator =
                new Comparator<Map.Entry<String, HashSet<String>>>() {
            @Override
            public int compare(Map.Entry<String, HashSet<String>> o1, Map.Entry<String, HashSet<String>> o2) {
                int tests1 = o1.getValue().size();
                int tests2 = o2.getValue().size();
                int testComparator = Integer.compare(tests2, tests1);
                if (testComparator == 0) {
                    return o1.getKey().compareTo(o2.getKey());
                }

                return testComparator;
            }
        };

        Comparator<String> testComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int length1 = o1.length();
                int length2 = o2.length();
                int lengthComparator = Integer.compare(length1, length2);
                if (lengthComparator == 0) {
                    return o1.compareTo(o2);
                }

                return lengthComparator;
            }
        };

        ArrayList<String> orderedClasses = new ArrayList<>();
        classes.entrySet().stream()
                .sorted(classComparator)
                .forEach(e -> orderedClasses.add(e.getKey()));

        for (String currClass : orderedClasses) {
            ArrayList<String> orderedMethods = new ArrayList<>();
            classes.get(currClass).entrySet().stream()
                    .sorted(methodComparator)
                    .forEach(e -> orderedMethods.add(e.getKey()));

            System.out.println(currClass + ":");
            for (String currMethod : orderedMethods) {
                ArrayList<String> orderedUnitTests = new ArrayList<>();
                classes.get(currClass).get(currMethod).stream()
                        .sorted(testComparator)
                        .forEach(t -> orderedUnitTests.add(t));

                System.out.println("##" + currMethod);
                for (String currTest : orderedUnitTests) {
                    System.out.println("####" + currTest);
                }
            }
        }
    }
}
