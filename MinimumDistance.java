package Graphs_BinarySerach;

import java.util.Arrays;

public class MinimumDistance {

    public static int[] minDistances(int N, int[] locations) {
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            int[] distances = new int[N];
            for (int j = 0; j < N; j++) {
                distances[j] = Math.abs(locations[j] - locations[i]);
            }

            Arrays.sort(distances);

            int totalDistance = 0;
            for (int j = 0; j < N - 2; j++) {
                totalDistance += distances[j];
            }

            result[i] = totalDistance;
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 3;
        int[] locations = { 1, 3, 8 };

        int[] result = minDistances(N, locations);

        System.out.println("Output: " + Arrays.toString(result));
    }
}
