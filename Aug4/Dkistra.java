package Aug4;

import java.util.*;

class Dkistra {

    public int[] shortestPath(int n, int M, int[][] edges, int src) {
        List<int[]>[] adj = makeAdj(edges, n);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] { src, 0 });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int distance = curr[1];

            if (distance > dist[node])
                continue;

            for (int[] edge : adj[node]) {
                int to = edge[0];
                int weight = edge[1];
                if (dist[node] + weight < dist[to]) {
                    dist[to] = dist[node] + weight;
                    pq.add(new int[] { to, dist[to] });
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }
        return dist;
    }

    public static List<int[]>[] makeAdj(int[][] edges, int n) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adj[u].add(new int[] { v, weight });
        }
        return adj;
    }

    public static void main(String[] args) {
        Dkistra solution = new Dkistra();
        int n = 6; // Number of nodes
        int M = 7; // Number of edges
        int[][] edges = {
                { 0, 1, 2 },
                { 0, 2, 3 },
                { 1, 2, 4 },
                { 1, 3, 7 },
                { 2, 3, 1 },
                { 2, 4, 2 },
                { 3, 5, 5 }
        };
        int src = 0; // Source node

        int[] shortestPaths = solution.shortestPath(n, M, edges, src);

        System.out.println("Shortest paths from node " + src + " to all other nodes:");
        for (int i = 0; i < shortestPaths.length; i++) {
            System.out.println("Node " + i + ": " + shortestPaths[i]);
        }
    }
}
