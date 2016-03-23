import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Problem01ArrangeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] numbers = scan.nextLine().split(", ");
        ArrayList<String> numbersInLetters = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            String currNumber = "";
            char[] array = numbers[i].toCharArray();
            for (int j = 0; j < array.length; j++) {
                switch (array[j]) {
                    case '1':
                        currNumber += "one";
                        break;
                    case '2':
                        currNumber += "two";
                        break;
                    case '3':
                        currNumber += "three";
                        break;
                    case '4':
                        currNumber += "four";
                        break;
                    case '5':
                        currNumber += "five";
                        break;
                    case '6':
                        currNumber += "six";
                        break;
                    case '7':
                        currNumber += "seven";
                        break;
                    case '8':
                        currNumber += "eight";
                        break;
                    case '9':
                        currNumber += "nine";
                        break;
                    case '0':
                        currNumber += "zero";
                }

                if (j != array.length - 1) {
                    currNumber += "-";
                }
            }

            numbersInLetters.add(currNumber);
        }

        Comparator<String> numberComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        numbersInLetters.sort(numberComparator);
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < numbersInLetters.size(); i++) {
            String[] currNumber = numbersInLetters.get(i).split("-");
            String number = "";
            for (int j = 0; j < currNumber.length; j++) {
                switch (currNumber[j]) {
                    case "one":
                        number += "1";
                        break;
                    case "two":
                        number += "2";
                        break;
                    case "three":
                        number += "3";
                        break;
                    case "four":
                        number += "4";
                        break;
                    case "five":
                        number += "5";
                        break;
                    case "six":
                        number += "6";
                        break;
                    case "seven":
                        number += "7";
                        break;
                    case "eight":
                        number += "8";
                        break;
                    case "nine":
                        number += "9";
                        break;
                    case "zero":
                        number += "0";
                        break;
                }
            }

            result.add(number);
        }

        System.out.println(String.join(", ", result));
    }
}
