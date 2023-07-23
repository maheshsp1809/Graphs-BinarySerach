package July22;

import java.util.*;

public class DetectCycleInUndirectedGraphBFS {

    public static boolean hasCycle(int V, List<Integer>[] adjList) {
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = -1; // Initialize parent array with -1 (no parent assigned yet)
        }

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (hasCycleUtil(i, adjList, visited, parent)) {
                    return true; // Cycle detected in the graph
                }
            }
        }

        return false; // No cycle found
    }

    private static boolean hasCycleUtil(int start, List<Integer>[] adjList, boolean[] visited, int[] parent) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : adjList[node]) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                    parent[neighbor] = node; // Set the parent of the neighbor node
                } else if (neighbor != parent[node]) {
                    return true; // Cycle detected
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        List<Integer>[] adjList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }

        // Adding undirected edges to the graph
        adjList[0].add(1);
        adjList[1].add(0);
        adjList[1].add(2);
        adjList[2].add(1);
        adjList[2].add(3);
        adjList[3].add(2);

        System.out.println("Cycle exists: " + hasCycle(V, adjList)); // Output: Cycle exists: true
    }
}
