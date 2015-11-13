import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem03SchmoogleCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String lineOfCSharpCode = scan.nextLine();
        String cSharpCode = "";
        while (!lineOfCSharpCode.equals("//END_OF_CODE")) {
            cSharpCode += lineOfCSharpCode;
            lineOfCSharpCode = scan.nextLine();
        }

        Pattern intPat = Pattern.compile("int ([a-z][A-Za-z]*)");
        Matcher intMatcher = intPat.matcher(cSharpCode);
        Pattern doublePat = Pattern.compile("double ([a-z][A-Za-z]*)");
        Matcher doubleMatcher = doublePat.matcher(cSharpCode);

        List<String> integers = new ArrayList<>();
        List<String> doubles = new ArrayList<>();

        while (intMatcher.find()) {
            integers.add(intMatcher.group(1));
        }
        while (doubleMatcher.find()) {
            doubles.add(doubleMatcher.group(1));
        }

        List<String> allIntegers = integers.stream()
                .sorted()
                .collect(Collectors.toList());

        List<String> allDoubles = doubles.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.print("Doubles: ");
        if (allDoubles.size() == 0) {
            System.out.println("None");
        } else {
            for (int i = 0; i < allDoubles.size(); i++) {
                if (i == allDoubles.size() - 1) {
                    System.out.print(allDoubles.get(i) + "\n");
                } else {
                    System.out.print(allDoubles.get(i) + ", ");
                }
            }
        }

        System.out.print("Ints: ");
        if (allIntegers.size() == 0) {
            System.out.println("None");
        } else {
            for (int i = 0; i < allIntegers.size(); i++) {
                if (i == allIntegers.size() - 1) {
                    System.out.print(allIntegers.get(i) + "\n");
                } else {
                    System.out.print(allIntegers.get(i) + ", ");
                }
            }
        }
    }
}
