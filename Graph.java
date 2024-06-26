import java.util.Scanner;

class Graph {
    private int V; // Number of vertices
    private int[][] adjMatrix; // Adjacency Matrix

    Graph(int numVertices) {
        V = numVertices;
        adjMatrix = new int[V][V];
    }

    // Method to add an edge to the graph
    void addEdge(int source, int destination) {
        adjMatrix[source][destination] = 1;
        // For undirected graph, add the reverse edge as well
        adjMatrix[destination][source] = 1;
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
            for (int j = 0; j < v; j++) {
                System.out.print(g.adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}