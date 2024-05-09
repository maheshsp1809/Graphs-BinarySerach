import java.util.*;

public class Tarjan {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int V = scanner.nextInt();
        System.out.println("Enter the number of edges:");
        int E = scanner.nextInt();

        GraphListOfLists graph = new GraphListOfLists(V);
        System.out.println("Enter the edges (vertex1 vertex2):");
        for (int i = 0; i < E; ++i) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph.addEdge(v, w);
        }
        graph.printGraph();
    }
}
