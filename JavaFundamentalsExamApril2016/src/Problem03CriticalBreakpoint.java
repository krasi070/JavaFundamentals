import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem03CriticalBreakpoint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        ArrayList<ArrayList<Long>> lines = new ArrayList<>();

        while (!line.equals("Break it.")){
            String[] coordinates = line.split("\\s+");
            long x1 = Long.parseLong(coordinates[0]);
            long y1 = Long.parseLong(coordinates[1]);
            long x2 = Long.parseLong(coordinates[2]);
            long y2 = Long.parseLong(coordinates[3]);
            ArrayList<Long> currCoordinates = new ArrayList<>();
            currCoordinates.add(x1);
            currCoordinates.add(y1);
            currCoordinates.add(x2);
            currCoordinates.add(y2);
            lines.add(currCoordinates);

            line = scan.nextLine();
        }

        long critRatio = 0;
        boolean critBreakpointExist = true;
        for (int i = 0; i < lines.size(); i++) {
            long currCritRatio =
                    Math.abs((lines.get(i).get(2) + lines.get(i).get(3)) - (lines.get(i).get(0) + lines.get(i).get(1)));

            lines.get(i).add(currCritRatio);
        }

        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).get(4) != 0) {
                critRatio = lines.get(i).get(4);
                break;
            }
        }

        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).get(4) != 0 && lines.get(i).get(4) != critRatio) {
                critBreakpointExist = false;
            }
        }
        
        if (critBreakpointExist){
            for (int i = 0; i < lines.size(); i++) {
                System.out.print("Line: [");
                for (int j = 0; j < 4; j++) {
                    if (j != 3) {
                        System.out.print(lines.get(i).get(j) + ", ");
                    } else {
                        System.out.print(lines.get(i).get(j));
                    }
                }

                System.out.println("]");
            }

            BigInteger critBreakpoint = new BigInteger("1");
            for (int i = 0; i < lines.size(); i++) {
                critBreakpoint = critBreakpoint.multiply(new BigInteger("" + critRatio));
            }

            critBreakpoint = critBreakpoint.mod(new BigInteger("" + lines.size()));
            System.out.println("Critical Breakpoint: " + critBreakpoint);
        } else {
            System.out.println("Critical breakpoint does not exist.");
        }
    }
}
