package Aug6;

import java.util.*;

class Edge {
    int u;
    int v;
    int weight;

    public Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}

class Solution {
    public List<Edge> primMST(List<List<Edge>> graph, int startVertex) {
        List<Edge> mst = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        visited.add(startVertex);
        pq.addAll(graph.get(startVertex));

        while (!pq.isEmpty() && visited.size() < graph.size()) {
            Edge edge = pq.poll();
            int u = edge.u;
            int v = edge.v;

            if (visited.contains(u) && !visited.contains(v)) {
                mst.add(edge);
                visited.add(v);
                pq.addAll(graph.get(v));
            } else if (visited.contains(v) && !visited.contains(u)) {
                mst.add(edge);
                visited.add(u);
                pq.addAll(graph.get(u));
            }
        }

        return mst;
    }
}
