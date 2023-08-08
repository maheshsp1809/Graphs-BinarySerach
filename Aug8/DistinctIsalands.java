package Aug8;

import java.util.*;

public class DistinctIsalands {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 1 },
                { 0, 0, 0, 1, 1 }
        };
        int n = 4;
        int m = 5;

        int result = distinctIsland(arr, n, m);
        System.out.println("Number of distinct islands: " + result);
    }

    public static int distinctIsland(int[][] arr, int n, int m) {
        boolean[][] vis = new boolean[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (!vis[i][j] && arr[i][j] == 1) {
                    ArrayList<String> vec = new ArrayList<>();
                    bfs(i, j, arr, vis, vec, i, j);
                    set.add(vec);
                }
            }
        }
        for (ArrayList<String> s : set) {
            System.out.print(s + " ");
        }

        return set.size();
    }

    public static void bfs(int row, int col, int[][] arr, boolean[][] vis, ArrayList<String> vec, int row0, int col0) {
        vis[row][col] = true;
        vec.add(toString(row - row0, col - col0));
        int n = arr.length;
        int m = arr[0].length;
        int[] di = { -1, 0, 1, 0 };
        int[] dj = { 0, 1, 0, -1 };
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { row, col });
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for (int k = 0; k < 4; ++k) {
                int nrow = r + di[k];
                int ncol = c + dj[k];
                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && arr[nrow][ncol] == 1 && (!vis[nrow][ncol])) {
                    vis[nrow][ncol] = true;
                    q.add(new int[] { nrow, ncol });
                    vec.add(toString(nrow - row0, ncol - col0));
                }
            }
        }
    }

    public static String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }
}
