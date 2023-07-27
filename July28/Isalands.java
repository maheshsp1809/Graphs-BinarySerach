package July28;

class Isalands {
    private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int numDistinctIslands2(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Set<String> distinctIslands = new HashSet<>();

        // Loop through each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the cell is part of an island and has not been visited yet
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<int[]> shape = new ArrayList<>();
                    // DFS to explore the island and build its shape relative to its starting point
                    // (baseX, baseY)
                    dfs(grid, i, j, i, j, visited, shape);
                    // Convert the shape to its canonical form and add it to the set of distinct
                    // islands
                    distinctIslands.add(canonical(shape));
                }
            }
        }

        // Return the number of distinct islands
        return distinctIslands.size();
    }

    // DFS to explore the island and build its shape relative to its starting point
    // (baseX, baseY)
    private void dfs(int[][] grid, int x, int y, int baseX, int baseY, boolean[][] visited, List<int[]> shape) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0 || visited[x][y]) {
            // If the current cell is out of bounds, not part of an island, or has been
            // visited, return
            return;
        }

        visited[x][y] = true;
        // Add the relative coordinates of the current cell to the island's shape
        shape.add(new int[] { x - baseX, y - baseY });

        // Explore the neighboring cells in all four directions
        for (int[] direction : DIRECTIONS) {
            int nextX = x + direction[0];
            int nextY = y + direction[1];
            dfs(grid, nextX, nextY, baseX, baseY, visited, shape);
        }
    }

    // Convert the island's shape to its canonical form by considering all possible
    // rotations and reflections
    private String canonical(List<int[]> shape) {
        List<String> canonicalShapes = new ArrayList<>();

        // Rotate the shape and store each rotated version
        for (int i = 0; i < 4; i++) {
            List<int[]> rotated = rotate(shape);
            List<int[]> reflected = reflect(rotated);
            shape = rotated;
            canonicalShapes.add(convertToString(reflected));
        }

        // Return the minimum lexicographically string among all the canonical shapes
        return Collections.min(canonicalShapes);
    }

    // Rotate the shape by 90 degrees counterclockwise
    private List<int[]> rotate(List<int[]> shape) {
        List<int[]> rotated = new ArrayList<>();

        for (int[] point : shape) {
            rotated.add(new int[] { point[1], -point[0] });
        }

        return rotated;
    }

    // Reflect the shape across the vertical axis
    private List<int[]> reflect(List<int[]> shape) {
        List<int[]> reflected = new ArrayList<>();

        for (int[] point : shape) {
            reflected.add(new int[] { point[0], -point[1] });
        }

        return reflected;
    }

    // Convert the island's shape to a string representation for easy comparison
    private String convertToString(List<int[]> shape) {
        StringBuilder sb = new StringBuilder();

        // Sort the shape to make sure it is in a consistent order
        Collections.sort(shape, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        // Convert each point in the shape to a string and append it to the result
        for (int[] point : shape) {
            sb.append(point[0]).append(",").append(point[1]).append(",");
        }

        return sb.toString();
    }
}
