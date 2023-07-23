package July19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LinkedListImpl {
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
    }

}
