import java.util.*;

class Graph {
    private int V;
    private ArrayList<Integer>[] adjacencyList;

    public Graph(int vertices) {
        V = vertices;
        adjacencyList = new ArrayList[V];
        for (int i = 0; i < V; ++i)
            adjacencyList[i] = new ArrayList();
    }

    void addEdge(int v, int w) {
        adjacencyList[v].add(w);
        adjacencyList[w].add(v);
    }

    void printGraph() {
        for (int i = 0; i < V; ++i) {
            System.out.println("Adjacency list of vertex " + i);
            System.out.print("head");
            for (Integer vertex : adjacencyList[i]) {
                System.out.print(" -> " + vertex);
            }
            System.out.println();
        }
    }
}
