package July21;

import java.util.ArrayList;
import java.util.List;

public class Dfs {
    public static void main(String[] args) {
        int n = 5;
        int m = 4;
        int[][] edges = { { 0, 2 }, { 0, 1 }, { 1, 2 }, { 3, 4 } };
        List<List<Integer>> ans = depthFirstSearch(n, m, edges);
        System.out.println(ans);

    }

    public static void dfs(int root, List<Integer> temp, List<Integer>[] adj, boolean[] vis) {
        vis[root] = true;
        temp.add(root);
        for (int i : adj[root]) {
            if (!vis[i]) {
                dfs(i, temp, adj, vis);
            }
        }
    }

    public static List<List<Integer>> depthFirstSearch(int V, int E, int[][] edges) {
        // Creating adjacency list
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            adj[x].add(y);
            adj[y].add(x);
        }

        // Creating visited array and answer list of lists to return ans
        boolean[] visited = new boolean[V];
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                List<Integer> temp = new ArrayList<>();
                dfs(i, temp, adj, visited);
                ans.add(temp);
            }
        }
        return ans;
    }

}
