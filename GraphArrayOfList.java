import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class GraphArrayOfList {
    private int V; // Number of vertices
    private List<Integer>[] adjMatrix; // Adjacency Matrix using lists

    @SuppressWarnings("unchecked")
    GraphArrayOfList(int numVertices) {
        V = numVertices;
        adjMatrix = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjMatrix[i] = new ArrayList<>();
        }
    }

    // Method to add an edge to the graph
    void addEdge(int source, int destination) {
        adjMatrix[source].add(destination);
        // For undirected graph, add the reverse edge as well
        adjMatrix[destination].add(source);
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
            for (int j : g.adjMatrix[i]) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}