package July21;

import java.util.*;

public class NumOfStates {
    public static int findNumOfStates(int[][] roads, int numVertices) {
        // Write your code here.
        return BFS(numVertices, roads);
    }

    public static int BFS(int v, int[][] adj) {
        int ans = 0;
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                queue.offer(i);
                visited[i] = true;
                ++ans;
                while (!queue.isEmpty()) {
                    int currentVertex = queue.poll();
                    for (int neighbor : adj[currentVertex]) {
                        if (!visited[neighbor]) {
                            queue.offer(neighbor);
                            visited[neighbor] = true;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 3;
        int[][] edges = { { 1, 2 }, { 0, 3 }, { 2, 3 } };
        int[][] adj = { { 1, 1, 1, 0 }, { 1, 1, 1, 0 }, { 1, 1, 1, 0 }, { 0, 0, 0, 1 } };
        int ans = findNumOfStates(adj, n);
        System.out.println(ans);
    }
}
