import java.util.Scanner;

public class GetAverage {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numbers = sc.nextLine();
        double fstNumber = Double.parseDouble(numbers.split(" ")[0]);
        double sndNumber = Double.parseDouble(numbers.split(" ")[1]);
        double trdNumber = Double.parseDouble(numbers.split(" ")[2]);
        System.out.printf("%.2f", averageOfThreeNumbers(fstNumber, sndNumber, trdNumber));
    }

    public static double averageOfThreeNumbers(double fstNumber, double sndNumber, double trdNumber) {
        double average = (fstNumber + sndNumber + trdNumber) / 3;
        return average;
    }
}
