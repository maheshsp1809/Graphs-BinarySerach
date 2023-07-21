package July21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    public static void main(String[] args) {
        int n = 9;
        int m = 10;
        int[][] edges = { { 0, 8 }, { 1, 6 }, { 1, 7 }, { 1, 8 }, { 5, 8 }, { 6, 0 }, { 7, 3 }, { 7, 4 }, { 2, 5 } };
        ArrayList<Integer> ans = BFS(n, edges);
        System.out.println(ans);

    }

    public static ArrayList<Integer> BFS(int v, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = printAdjacency(v, edges);
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>(); // Use LinkedList as a concrete implementation of Queue

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                queue.offer(i);
                visited[i] = true;

                while (!queue.isEmpty()) {
                    int currentVertex = queue.poll();
                    ans.add(currentVertex);

                    for (int neighbor : adj.get(currentVertex)) {
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
