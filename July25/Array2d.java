package July25;

public class Array2d {

    public static int[][] adjList(int[][] edges, int v) {
        int[][] adj = new int[v][];
        for (int i = 0; i < v; ++i) {
            adj[i] = new int[1];
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int w = edge[1];
            adj[u] = addElement(adj[u], w);
            adj[w] = addElement(adj[w], u);
        }
        return adj;
    }

    public static int[] addElement(int[] arr, int element) {
        int newarr[] = new int[arr.length + 1];
        for (int i = 0; i < arr.length; ++i) {
            newarr[i] = arr[i];
        }
        newarr[arr.length] = element;
        return newarr;
    }

    public static void main(String[] args) {
        int[][] edges = {
                { 0, 1 },
                { 0, 2 },
                { 1, 2 },
                { 2, 3 },
                { 3, 4 }
        };

        int V = 5;
        int[][] adj = adjList(edges, V);

        // Print the adjacency list
        for (int i = 0; i < V; i++) {
            System.out.print("Adjacency list for vertex " + i + ": ");
            for (int j = 0; j < adj[i].length; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }
}
