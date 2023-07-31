package July24;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindStates {
    public static void main(String[] args) {
        Scanner scanObj = new Scanner(System.in);
        System.out.println("Enter number of vertices");
        int n = scanObj.nextInt();
        int[][] roads = new int[n][n];
        System.out.println("Enter road connectivity matrix");
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                roads[i][j] = scanObj.nextInt();
            }
        }
        boolean[] vis = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = findNumOfStates(i, roads, vis, n);
        }
        System.out.println(ans);
    }

    public static int findNumOfStates(int start, int[][] roads, boolean[] vis, int n) {
        // Write your code here.
        vis[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbour : roads[node]) {
                if (neighbour == 1) {
                }
            }
        }

        return 0;
    }
}
