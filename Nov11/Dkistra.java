package Nov11;

import java.util.*;

public class Dkistra {
    static class Pair {
        int v, wt;

        Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    public static List<Integer> dijkstra(int[][] edge, int vertices, int edges, int source) {
        List<List<Pair>> l = new ArrayList<>();
        Queue<Pair> pq = new PriorityQueue<>((x, y) -> x.wt - y.wt);
        pq.add(new Pair(source, 0));
        for (int i = 0; i < vertices; i++) {
            List<Pair> tem = new ArrayList<>();
            l.add(tem);
        }
        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1], c = edge[i][2];
            l.get(a).add(new Pair(b, c));
            l.get(b).add(new Pair(a, c));
        }
        int dis[] = new int[vertices];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[source] = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.peek();
            int weight = p.wt;
            int ve = p.v;
            pq.poll();
            for (Pair curr : l.get(p.v)) {
                if (weight + curr.wt < dis[curr.v]) {
                    dis[curr.v] = weight + curr.wt;
                    pq.add(new Pair(curr.v, dis[curr.v]));

                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i : dis)
            ans.add(i);
        return ans;
    }

    public static void main(String[] args) {
        int vertices = 5;
        int edges = 7;
        int source = 0;
        int[][] edge = {
                { 0, 1, 2 },
                { 0, 4, 1 },
                { 1, 2, 3 },
                { 1, 3, 9 },
                { 2, 3, 6 },
                { 2, 4, 4 },
                { 3, 4, 5 }
        };

        List<Integer> result = dijkstra(edge, vertices, edges, source);

        System.out.println("Shortest distances from source " + source + " to all vertices: " + result);
    }
}
