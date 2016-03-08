import java.math.BigInteger;
import java.util.Scanner;

public class Problem03SoftuniNumerals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String softuniNumeral = scan.nextLine();
        String normalNumerals = "";

        while (!softuniNumeral.equals("")) {
            if (softuniNumeral.startsWith("aa")) {
                normalNumerals = "0" + normalNumerals;
                softuniNumeral = softuniNumeral.substring(2, softuniNumeral.length());
            } else if (softuniNumeral.startsWith("aba")) {
                normalNumerals = "1" + normalNumerals;
                softuniNumeral = softuniNumeral.substring(3, softuniNumeral.length());
            } else if (softuniNumeral.startsWith("bcc")) {
                normalNumerals = "2" + normalNumerals;
                softuniNumeral = softuniNumeral.substring(3, softuniNumeral.length());
            } else if (softuniNumeral.startsWith("cc")) {
                normalNumerals = "3" + normalNumerals;
                softuniNumeral = softuniNumeral.substring(2, softuniNumeral.length());
            } else if (softuniNumeral.startsWith("cdc")) {
                normalNumerals = "4" + normalNumerals;
                softuniNumeral = softuniNumeral.substring(3, softuniNumeral.length());
            }
        }

        BigInteger number = convertFifthBaseToDecimal(normalNumerals);
        System.out.println(number);
    }

    private static BigInteger convertFifthBaseToDecimal(String fifthBaseNumber) {
        BigInteger decimalNumber = new BigInteger("0");
        for (int pow = 0; pow < fifthBaseNumber.length(); pow++) {
            BigInteger power = new BigInteger("1");
            for (int i = 0; i < pow; i++) {
                power = power.multiply(new BigInteger("5"));
            }

            BigInteger currDigit;
            if (fifthBaseNumber.charAt(pow) == '0') {
                currDigit = new BigInteger("0");
            }
            else if (fifthBaseNumber.charAt(pow) == '1') {
                currDigit = new BigInteger("1");
            }
            else if (fifthBaseNumber.charAt(pow) == '2') {
                currDigit = new BigInteger("2");
            }
            else if (fifthBaseNumber.charAt(pow) == '3') {
                currDigit = new BigInteger("3");
            }
            else {
                currDigit = new BigInteger("4");
            }

            decimalNumber = decimalNumber.add(currDigit.multiply(power));
        }

        return decimalNumber;
    }
}
