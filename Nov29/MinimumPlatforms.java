package Nov29;

import java.util.Arrays;

public class MinimumPlatforms {

    public static int findMinimumPlatforms(int[] arrivals, int[] departures) {
        // Sort the arrival and departure times in ascending order
        Arrays.sort(arrivals);
        Arrays.sort(departures);

        // Initialize the number of platforms and the maximum number of platforms
        // required
        int platforms = 1, maxPlatforms = 1;

        // Initialize the index for arrivals and departures
        int arrivalIndex = 1, departureIndex = 0;

        // Iterate until all trains have been processed
        while (arrivalIndex < arrivals.length) {
            // If the next arrival time is earlier than or equal to the departure time, we
            // need an additional platform
            if (arrivals[arrivalIndex] <= departures[departureIndex]) {
                platforms++;
                maxPlatforms = Math.max(maxPlatforms, platforms);
                arrivalIndex++;
            }

            // If a train has departed, we can free up a platform
            else if (arrivals[arrivalIndex] > departures[departureIndex]) {
                platforms--;
                departureIndex++;
            }
        }

        // Return the maximum number of platforms required
        return maxPlatforms;
    }

    public static void main(String[] args) {
        int[] arrivals = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00};
        int[] departures = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00};

        int minimumPlatforms = findMinimumPlatforms(arrivals, departures);
        System.out.println("Minimum number of platforms required: " + minimumPlatforms);
    }
}
