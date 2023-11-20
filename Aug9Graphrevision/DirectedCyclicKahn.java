package Aug9Graphrevision;

import java.util.*;

public class Solution {
    public static Boolean isCyclic(int[][] edges, int v, int e) {
        int[] indeg = new int[v];
        List<Integer>[] adj = makeAdj(edges, v, indeg);

        for (int i = 0; i < v; ++i) {
            if (bfs(i, adj, indeg, v)) {
                return true;
            }
        }
        return false;
    }

    public static boolean bfs(int start, List<Integer>[] adj, int[] indeg, int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        for (int i = 0; i < v; ++i) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbor : adj[node]) {
                indeg[neighbor]--;
                if (indeg[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        for (int i : indeg) {
            if (i != 0) {
                return true; // Cycle detected
            }
        }
        return false;
    }

    public static List<Integer>[] makeAdj(int[][] edges, int v, int[] indeg) {
        List<Integer>[] adj = new ArrayList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int vDest = edge[1]; // Change variable name to vDest
            adj[u].add(vDest);
            indeg[vDest]++;
        }

        return adj;
    }
}
