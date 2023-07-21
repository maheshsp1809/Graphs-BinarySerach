package July19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomImpl {
    class Graph {
        private int V; // Number of vertices
        private List<List<Integer>> adjList; // Adjacency list

        // Constructor to initialize the Graph
        public Graph(int V) {
            this.V = V;
            adjList = new ArrayList<>(V);
            for (int i = 0; i < V; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        // Method to add an edge to the graph
        public void addEdge(int u, int v) {
            adjList.get(u).add(v);
            adjList.get(v).add(u); // Uncomment this line for an undirected graph
        }

        // Method to print the adjacency list
        public void printAdjList() {
            for (int i = 0; i < V; i++) {
                System.out.print("Vertex " + i + " -> ");
                for (int neighbor : adjList.get(i)) {
                    System.out.print(neighbor + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanobj = new Scanner(System.in);
        System.out.println("Enter number of vertices: ");
        int V = scanobj.nextInt();
        System.out.println("Enter number of edges:");
        int E = scanobj.nextInt();

        // Create the Graph object
        CustomImpl customImpl = new CustomImpl();
        Graph graph = customImpl.new Graph(V);

        System.out.println("Enter the edges of the graph:");
        for (int i = 0; i < E; i++) {
            int u = scanobj.nextInt();
            int v = scanobj.nextInt();
            // Adding the edge to the graph
            graph.addEdge(u, v);
        }

        // Print the adjacency list
        graph.printAdjList();
    }

}
