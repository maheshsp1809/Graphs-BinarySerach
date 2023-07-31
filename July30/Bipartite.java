package July30;

import java.util.*;

class Bipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n]; // 0: not colored, 1: color 1, -1: color -1

        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) { // If the node is not colored yet
                if (!bfs(graph, i, colors)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean bfs(int[][] graph, int start, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        colors[start] = 1; // Color the starting node with color 1

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            int currColor = colors[currNode];

            for (int neighbor : graph[currNode]) {
                if (colors[neighbor] == 0) { // If the neighbor is not colored yet
                    colors[neighbor] = -currColor; // Color the neighbor with the opposite color
                    queue.offer(neighbor);
                } else if (colors[neighbor] == currColor) {
                    return false; // If the neighbor is colored with the same color, the graph is not bipartite
                }
            }
        }

        return true;
    }
}
