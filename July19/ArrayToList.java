package July19;

import java.util.ArrayList;

public class ArrayToList {
    public static ArrayList<ArrayList<Integer>> printAdjacency(int n, int m, int[][] edges) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; ++i) {
            int u = edges[i][0];
            int v = edges[i][1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        return list;

    }

    public static void main(String[] args) {
        int n = 4;
        int m = 3;
        int[][] edges = { { 1, 2 }, { 0, 3 }, { 2, 3 } };
        ArrayList<ArrayList<Integer>> adjList = printAdjacency(n, m, edges);
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
