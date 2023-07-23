package July21;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    // Helper class to store coordinates (row and column)
    static class Coordinate {
        int row;
        int col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Direction arrays to represent 4-directional movement (up, down, left, right)
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        Queue<Coordinate> queue = new LinkedList<>();
        int freshOranges = 0;
        int minutes = 0;

        // Count the number of fresh oranges and add rotten oranges to the queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                } else if (grid[i][j] == 2) {
                    queue.add(new Coordinate(i, j));
                }
            }
        }

        // Special case: No fresh oranges
        if (freshOranges == 0) {
            return 0;
        }

        // Perform BFS to rot fresh oranges and calculate the minutes
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinate curr = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int newRow = curr.row + dx[k];
                    int newCol = curr.col + dy[k];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2; // Rot the fresh orange
                        freshOranges--;
                        queue.add(new Coordinate(newRow, newCol));
                    }
                }
            }
            if (!queue.isEmpty()) {
                minutes++;
            }
        }

        // If there are still fresh oranges left, return -1 (they cannot be rotten)
        return freshOranges == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };

        System.out.println("Minimum time to rot all oranges: " + orangesRotting(grid)); // Output: Minimum time to rot
                                                                                        // all oranges: 4
    }
}
