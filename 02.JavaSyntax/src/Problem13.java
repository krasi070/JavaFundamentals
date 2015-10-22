import java.util.Scanner;

public class Problem13 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputNumbers = scan.nextLine().split(" ");
        int[] numbers = new int[inputNumbers.length];
        for (int i = 0; i < inputNumbers.length; i++) {
            numbers[i] = Integer.parseInt(inputNumbers[i]);
        }
        String[] command = scan.nextLine().split(" ");
        int numberOfElementsToGet = Integer.parseInt(command[1]);
        String type = command[2];
        for (int i = 0, count = 0; i < numbers.length; i++) {
            if (type.equals("even") && numbers[i] % 2 == 0) {
                System.out.print(numbers[i] + " ");
                count++;
            } else if (type.equals("odd") && numbers[i] % 2 == 1) {
                System.out.print(numbers[i] + " ");
                count++;
            }
            if (count == numberOfElementsToGet) {
                break;
            }
        }
        System.out.println();
    }
}
