package Aug7;

import java.util.*;

public class NumberOfProvinces {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] vis = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; ++i) {
            if (!vis[i]) {
                count++;
                bfs(i, adj, V, vis);
            }
        }
        return count;
    }

    public static void bfs(int start, ArrayList<ArrayList<Integer>> adj, int V, boolean[] vis) {
        vis[start] = true;
        Queue<Integer> pq = new LinkedList<>();
        pq.add(start);
        while (!pq.isEmpty()) {
            int node = pq.poll();
            for (int i = 0; i < adj.get(node).size(); ++i) {
                int neighbor = adj.get(node).get(i);
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    pq.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 3; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        // Add edges (1-based indexing)
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);

        int provinces = numProvinces(adj, V);
        System.out.println("Number of provinces: " + provinces);
    }
}
