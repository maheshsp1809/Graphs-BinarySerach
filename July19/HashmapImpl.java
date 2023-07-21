package July19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HashmapImpl {
    public static void main(String[] args) {
        Scanner scanobj = new Scanner(System.in);
        System.out.println("Enter number of vertices: ");
        int V = scanobj.nextInt();
        System.out.println("Enter number of edges:");
        int E = scanobj.nextInt();

        List<List<Integer>> edges = new ArrayList<>(E);

        System.out.println("Enter the edges of the graph:");
        for (int i = 0; i < E; i++) {
            int u = scanobj.nextInt();
            int v = scanobj.nextInt();
            // Adding the edge to the list
            List<Integer> edge = Arrays.asList(u, v);
            edges.add(edge);
        }
        Map<Integer, List<Integer>> adjMap = adjMapFun(V, E, edges);

        // Print adjMap
        for (Map.Entry<Integer, List<Integer>> entry : adjMap.entrySet()) {
            int vertex = entry.getKey();
            List<Integer> neighbors = entry.getValue();

            System.out.print("Vertex " + vertex + " -> ");
            for (int neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }

    }

    public static Map<Integer, List<Integer>> adjMapFun(int V, int E, List<List<Integer>> edges) {
        Map<Integer, List<Integer>> adjMap = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < V; ++i) {
            adjMap.put(i, new ArrayList<Integer>());

        }
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adjMap.get(u).add(v);
            adjMap.get(v).add(u);
        }
        return adjMap;

    }
}
