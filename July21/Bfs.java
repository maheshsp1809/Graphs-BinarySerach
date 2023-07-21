package July21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int[][] edges = { { 0, 1 }, { 0, 3 }, { 1, 2 }, { 2, 3 } };
        ArrayList<Integer> ans = BFS(n, edges);
        System.out.println(ans);

    }

    public static ArrayList<Integer> BFS(int v, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = printAdjacency(v, edges);
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[v];
        Queue<Integer> q = new LinkedList<>(); // Use LinkedList as a concrete implementation of Queue
        q.add(0);
        vis[0] = true;
        while (!q.isEmpty()) {
            int node = q.poll(); // Use poll() method to remove and retrieve the head of the queue
            ans.add(node);
            for (int it : adj.get(node)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return ans;
    }

    public static ArrayList<ArrayList<Integer>> printAdjacency(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; ++i) {
            int u = edges[i][0];
            int v = edges[i][1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        return list;
    }
}
