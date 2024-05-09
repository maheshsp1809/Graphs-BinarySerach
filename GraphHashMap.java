import java.util.*;

class GraphHashMap {
    private int V; // Number of vertices
    private Map<Integer, List<Integer>> adMap; // Adjacency Matrix using lists

    @SuppressWarnings("unchecked")
    GraphHashMap(int numVertices) {
        V = numVertices;
        adMap = new HashMap<>();
        for (int i = 0; i < V; i++) {
            adMap.put(i, new ArrayList<>());
        }
    }

    // Method to add an edge to the graph
    void addEdge(int source, int destination) {
        adMap.get(source).add(destination);
        // For undirected graph, add the reverse edge as well
        adMap.get(destination).add(source);
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
            for (int j : g.adMap.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
