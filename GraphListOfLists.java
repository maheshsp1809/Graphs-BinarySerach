import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

class GraphListOfLists {
    private int V; // Number of vertices
    private List<List<Integer>> adj; // Adjacency Matrix using lists

    @SuppressWarnings("unchecked")
    GraphListOfLists(int numVertices) {
        V = numVertices;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Method to add an edge to the graph
    void addEdge(int source, int destination) {
        adj.get(source).add(destination);
        // For undirected graph, add the reverse edge as well
        adj.get(destination).add(source);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int v = scanner.nextInt();

        GraphListOfLists g = new GraphListOfLists(v);

        System.out.print("Enter the number of edges: ");
        int e = scanner.nextInt();

        System.out.println("Enter the edges (source and destination vertices):");
        for (int i = 0; i < e; ++i) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            g.addEdge(source, destination);
        }

        scanner.close();

        // Print the adjacency matrix
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < v; i++) {
            System.out.print(i + ": ");
            for (int j : g.adj.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
