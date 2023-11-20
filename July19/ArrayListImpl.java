package July19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayListImpl {
    public static void main(String[] args) {
        try (Scanner scanobj = new Scanner(System.in)) {
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
            List<List<Integer>> ansList = adjaList(V, E, edges);
            for (List<Integer> row : ansList) {
                System.out.println(row);
            }
        }

    }

    public static List<List<Integer>> adjaList(int V, int E, List<List<Integer>> edges) {
        List<List<Integer>> AdjList = new ArrayList<List<Integer>>();
        for (int i = 0; i < V; ++i) {
            AdjList.add(new ArrayList<>());
            AdjList.get(i).add(i);
        }
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            AdjList.get(u).add(v);
            AdjList.get(v).add(u);
        }
        return AdjList;

    }

}
