import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem01ArrayManipulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        String[] input = scan.nextLine().split("\\s+");
        for (int i = 0; i < input.length; i++) {
            arr.add(Integer.parseInt(input[i]));
        }

        String command = scan.nextLine();

        while (!command.equals("end")) {
            if (command.startsWith("exchange")) {
                int index = Integer.parseInt(command.split("\\s+")[1]);
                if (index < arr.size() && index > -1) {
                    exchange(arr, index);
                } else {
                    System.out.println("Invalid index");
                }
            } else if (command.startsWith("max")) {
                String type = command.split("\\s+")[1];
                findIndexOfMaxElement(arr, type);
            } else if (command.startsWith("min")) {
                String type = command.split("\\s+")[1];
                findIndexOfMinElement(arr, type);
            } else if (command.startsWith("first")) {
                int number = Integer.parseInt(command.split("\\s+")[1]);
                String type = command.split("\\s+")[2];
                if (number <= arr.size()) {
                    printFirstElements(arr, number, type);
                } else {
                    System.out.println("Invalid count");
                }
            } else if (command.startsWith("last")) {
                int number = Integer.parseInt(command.split("\\s+")[1]);
                String type = command.split("\\s+")[2];
                if (number <= arr.size()) {
                    printLastElements(arr, number, type);
                } else {
                    System.out.println("Invalid count");
                }
            }
            command = scan.nextLine();
        }

        System.out.println(arr);
    }
    public static void exchange(List<Integer> arr, int index) {
        List<Integer> fstSubArr = new ArrayList<>();
        List<Integer> sndSubArr = new ArrayList<>();

        for (int i = 0; i <= index; i++) {
            fstSubArr.add(arr.get(i));
        }

        for (int i = index + 1; i < arr.size(); i++) {
            sndSubArr.add(arr.get(i));
        }

        arr.clear();
        arr.addAll(sndSubArr);
        arr.addAll(fstSubArr);
    }
    public static void findIndexOfMaxElement(List<Integer> arr, String type) {
        int max = Integer.MIN_VALUE;
        int index = -1;

        if(type.equals("odd")) {
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) % 2 == 1) {
                    if (max <= arr.get(i)) {
                        max = arr.get(i);
                        index = i;
                    }
                }
            }
        } else if(type.equals("even")) {
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) % 2 == 0) {
                    if (max <= arr.get(i)) {
                        max = arr.get(i);
                        index = i;
                    }
                }
            }
        }

        if (index == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(index);
        }
    }
    public static void findIndexOfMinElement(List<Integer> arr, String type) {
        int min = Integer.MAX_VALUE;
        int index = -1;

        if(type.equals("odd")) {
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) % 2 == 1) {
                    if (min >= arr.get(i)) {
                        min = arr.get(i);
                        index = i;
                    }
                }
            }
        } else if(type.equals("even")) {
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) % 2 == 0) {
                    if (min >= arr.get(i)) {
                        min = arr.get(i);
                        index = i;
                    }
                }
            }
        }

        if (index == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(index);
        }
    }
    public static void printFirstElements(List<Integer> arr, int number, String type) {
        List<Integer> listOfElements = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (type.equals("odd")) {
                if (arr.get(i) % 2 == 1) {
                    listOfElements.add(arr.get(i));
                    count++;
                }
            } else if (type.equals("even")) {
                if (arr.get(i) % 2 == 0) {
                    listOfElements.add(arr.get(i));
                    count++;
                }
            }
            if (count == number) {
                break;
            }
        }

        System.out.println(listOfElements);
    }
    public static void printLastElements(List<Integer> arr, int number, String type) {
        List<Integer> listOfElements = new ArrayList<>();
        int count = 0;

        for (int i = arr.size() - 1; i >= 0; i--) {
            if (type.equals("odd")) {
                if (arr.get(i) % 2 == 1) {
                    listOfElements.add(arr.get(i));
                    count++;
                }
            } else if (type.equals("even")) {
                if (arr.get(i) % 2 == 0) {
                    listOfElements.add(arr.get(i));
                    count++;
                }
            }
            if (count == number) {
                break;
            }
        }

        List<Integer> lastElements = new ArrayList<>();
        for (int i = listOfElements.size() - 1; i >= 0; i--) {
            lastElements.add(listOfElements.get(i));
        }
        System.out.println(lastElements);
    }
}
