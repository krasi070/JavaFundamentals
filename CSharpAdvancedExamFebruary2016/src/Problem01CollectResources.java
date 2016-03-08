import java.util.ArrayList;
import java.util.Scanner;

public class Problem01CollectResources {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] resources = scan.nextLine().split("\\s+");
        int numberOfPaths = Integer.parseInt(scan.nextLine());
        int bestPath = 0;

        for (int currPath = 0; currPath < numberOfPaths; currPath++) {
            String[] pathArgs = scan.nextLine().split("\\s+");
            int position = Integer.parseInt(pathArgs[0]);
            int step = Integer.parseInt(pathArgs[1]);
            int currResourcesCollected = 0;
            ArrayList<Integer> collectedPlaces = new ArrayList<>();

            while (!collectedPlaces.contains(position)) {
                String[] resourceArgs = resources[position].split("_");
                String resourceType = resourceArgs[0];
                int quantity = 1;
                if (resourceArgs.length > 1) {
                    quantity = Integer.parseInt(resourceArgs[1]);
                }

                if (resourceType.equals("wood") ||
                    resourceType.equals("stone") ||
                    resourceType.equals("food") ||
                    resourceType.equals("gold")) {
                    currResourcesCollected += quantity;
                }

                collectedPlaces.add(position);

                position = (position + step) % resources.length;
            }

            if (bestPath < currResourcesCollected) {
                bestPath = currResourcesCollected;
            }
        }

        System.out.println(bestPath);
    }
}
