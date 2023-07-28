package July28;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Isalands2Bfs {

    public int numDistinctIslands(int[][] grid) {
        // Base case: if the grid is empty or null, there are no islands.
        if (grid == null || grid.length == 0)
            return 0;

        int m = grid.length; // Number of rows in the grid
        int n = grid[0].length; // Number of columns in the grid

        Set<List<String>> res = new HashSet<>(); // Set to store distinct islands
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    List<String> list = new ArrayList<>(); // List to store the shape of the current island
                    bfs(grid, i, j, list); // Perform BFS traversal to find the current island
                    res.add(list); // Add the island shape to the set of distinct islands
                }
            }
        }

        return res.size(); // Return the number of distinct islands
    }

    // BFS traversal to explore the current island
    private void bfs(int[][] grid, int r1, int c1, List<String> list) {
        int m = grid.length; // Number of rows in the grid
        int n = grid[0].length; // Number of columns in the grid
        int[][] moves = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { r1, c1 }); // Add the starting cell to the queue
        grid[r1][c1] = -1; // Mark the cell as visited

        while (!q.isEmpty()) {
            int[] curr = q.poll(); // Dequeue the current cell

            for (int[] move : moves) {
                int r2 = curr[0] + move[0]; // Calculate the row index of the neighboring cell
                int c2 = curr[1] + move[1]; // Calculate the column index of the neighboring cell

                // Check if the neighboring cell is within the grid and is part of the current
                // island
                if (r2 >= 0 && c2 >= 0 && r2 < m && c2 < n && grid[r2][c2] == 1) {
                    grid[r2][c2] = -1; // Mark the neighboring cell as visited
                    list.add((r2 - r1) + "," + (c2 - c1)); // Add the relative position of the cell to the list
                    q.offer(new int[] { r2, c2 }); // Enqueue the neighboring cell for further exploration
                }
            }
        }
    }
}
