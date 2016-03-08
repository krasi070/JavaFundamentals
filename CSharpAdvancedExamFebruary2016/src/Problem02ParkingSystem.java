import java.util.HashSet;
import java.util.Scanner;

public class Problem02ParkingSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] dimensions = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        HashSet<String> usedParkingSpots = new HashSet<>();
        String command = scan.nextLine();

        while (!command.equals("stop")) {
            String[] parkingArgs = command.split("\\s+");
            int entryRow = Integer.parseInt(parkingArgs[0]);
            int desiredRow = Integer.parseInt(parkingArgs[1]);
            int desiredCol = Integer.parseInt(parkingArgs[2]);

            int distance = Math.abs(entryRow - desiredRow) + desiredCol + 1;
            if (usedParkingSpots.contains(desiredRow + "|" + desiredCol)) {
                int distanceToFreeSpotLeft = cols;
                int nextFreeSpotLeft = 1;
                while (nextFreeSpotLeft < desiredCol) {
                    if (!usedParkingSpots.contains(desiredRow + "|" + (desiredCol - nextFreeSpotLeft))) {
                        distanceToFreeSpotLeft = nextFreeSpotLeft;
                        break;
                    }

                    nextFreeSpotLeft++;
                }

                int distanceToFreeSpotRight = cols;
                int nextFreeSpotRight = 1;
                while (cols > nextFreeSpotRight + desiredCol) {
                    if (!usedParkingSpots.contains(desiredRow + "|" + (desiredCol + nextFreeSpotRight))) {
                        distanceToFreeSpotRight = nextFreeSpotRight;
                        break;
                    }

                    nextFreeSpotRight++;
                }

                if (distanceToFreeSpotLeft <= distanceToFreeSpotRight && distanceToFreeSpotLeft != cols) {
                    distance -= distanceToFreeSpotLeft;
                    usedParkingSpots.add(desiredRow + "|" + (desiredCol - distanceToFreeSpotLeft));
                    System.out.println(distance);
                }
                else if (distanceToFreeSpotRight < distanceToFreeSpotLeft && distanceToFreeSpotRight != cols) {
                    distance += distanceToFreeSpotRight;
                    usedParkingSpots.add(desiredRow + "|" + (desiredCol + distanceToFreeSpotRight));
                    System.out.println(distance);
                }
                else {
                    System.out.println("Row " + desiredRow + " full");
                }
            }
            else {
                usedParkingSpots.add(desiredRow + "|" + desiredCol);
                System.out.println(distance);
            }

            command = scan.nextLine();
        }
    }
}
