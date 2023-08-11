package Aug1;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionUndirectedGraphDFS {

    public static void main(String[] args) {
        int V = 8; // Number of vertices
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to create an undirected graph with a cycle
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 2, 6);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 5);
        addEdge(adj, 4, 7);
        addEdge(adj, 5, 6); // Cycle: 1 -> 2 -> 3 -> 4 -> 1
        ArrayList<Integer> ans = new ArrayList<>();
        if (hasCycle(V, adj, ans)) {
            System.out.println("Cycle is present in the graph.");
            System.out.println("Nodes involved in forming the cycle: " + ans);
        } else {
            System.out.println("No cycle found in the graph.");
        }
    }

    public static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static boolean hasCycle(int V, List<List<Integer>> adj, ArrayList<Integer> ans) {
        boolean[] vis = new boolean[V];
        int[] parent = new int[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, -1, vis, parent, adj, ans))
                    return true;
            }
        }
        return false;
    }

    public static boolean dfs(int node, int parent, boolean[] vis, int[] parenta, List<List<Integer>> adj,
            ArrayList<Integer> ans) {
        vis[node] = true;
        parenta[node] = parent;
        for (int neighbour : adj.get(node)) {
            if (!vis[neighbour]) {
                if (dfs(neighbour, node, vis, parenta, adj, ans))
                    return true;
            } else if (neighbour != parenta[node]) {
                ans.add(neighbour);
                int current = node;
                while (current != neighbour) {
                    ans.add(current);
                    current = parenta[current];
                }
                ans.add(neighbour); // Add the starting node of the cycle to complete the cycle
                return true;
            }
        }
        return false;
    }
}
