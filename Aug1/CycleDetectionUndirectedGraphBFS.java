package Aug1;

import java.util.*;

public class CycleDetectionUndirectedGraphBFS {
    private int V;
    private List<List<Integer>> adjList;

    public CycleDetectionUndirectedGraphBFS(int vertices) {
        V = vertices;
        adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u); // For undirected graph
    }

    public List<Integer> findCycle() {
        boolean[] visited = new boolean[V];
        List<Integer> cycleElements = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(i, visited, cycleElements)) {
                    return cycleElements;
                }
            }
        }

        return cycleElements;
    }

    private boolean bfs(int start, boolean[] visited, List<Integer> ans) {
        int[] parent = new int[V];
        Arrays.fill(parent, -1);
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    parent[neighbor] = current;
                } else if (neighbor != parent[current]) {
                    ans.add(neighbor);
                    int curr = current;
                    while (curr != neighbor) {
                        ans.add(curr);
                        curr = parent[curr];
                    }
                    ans.add(neighbor); // Add the starting node of the cycle to complete the cycle
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        CycleDetectionUndirectedGraphBFS graph = new CycleDetectionUndirectedGraphBFS(V);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1); // Cycle: 1 -> 2 -> 3 -> 4 -> 1

        List<Integer> cycleElements = graph.findCycle();
        if (cycleElements.isEmpty()) {
            System.out.println("No cycle found in the graph.");
        } else {
            System.out.println("Nodes involved in forming the cycle: " + cycleElements);
        }
    }
}
