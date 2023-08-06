package Aug2;

import java.util.*;

public class CycleDetectionDirectedGraphDFS {
    private int V;
    private List<List<Integer>> adjList;

    public CycleDetectionDirectedGraphDFS(int vertices) {
        V = vertices;
        adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
    }

    public List<Integer> findCycle() {
        boolean[] visited = new boolean[V];
        boolean[] inPath = new boolean[V];
        int[] parent = new int[V];
        Arrays.fill(parent, -1);
        List<Integer> cycleElements = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i] && dfs(i, visited, inPath, parent, cycleElements)) {
                return cycleElements;
            }
        }

        return cycleElements;
    }

    private boolean dfs(int current, boolean[] visited, boolean[] inPath, int[] parent, List<Integer> cycleElements) {
        visited[current] = true;
        inPath[current] = true;

        for (int neighbor : adjList.get(current)) {
            if (inPath[neighbor]) {
                // Cycle detected
                int cycleStart = neighbor;
                int cycleEnd = current;
                while (cycleStart != cycleEnd) {
                    cycleElements.add(cycleStart);
                    cycleStart = parent[cycleStart];
                }
                cycleElements.add(cycleEnd);
                return true;
            }

            if (!visited[neighbor]) {
                parent[neighbor] = current;
                if (dfs(neighbor, visited, inPath, parent, cycleElements)) {
                    return true;
                }
            }
        }

        inPath[current] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 11;
        CycleDetectionDirectedGraphDFS graph = new CycleDetectionDirectedGraphDFS(V);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(8, 2);
        graph.addEdge(3, 7);
        graph.addEdge(4, 5);
        graph.addEdge(7, 5);
        graph.addEdge(5, 7);
        graph.addEdge(5, 6);
        graph.addEdge(8, 9);
        graph.addEdge(9, 10);
        graph.addEdge(10, 8); // Cycle: 8 -> 9 -> 10 -> 8

        List<Integer> cycleElements = graph.findCycle();
        if (!cycleElements.isEmpty()) {
            System.out.println("Cycle is present in the graph.");
            System.out.println("Nodes involved in forming the cycle: " + cycleElements);
        } else {
            System.out.println("No cycle found in the graph.");
        }
    }
}
