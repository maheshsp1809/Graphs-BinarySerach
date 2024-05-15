import java.util.Arrays;

public class Ninjadp {
    public static void main(String[] args) {
        int[][] points = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int result = ninjaTraining(3, points);
        System.out.println("Maximum points: " + result);
    }

    public static int ninjaTraining(int n, int[][] points) {
        int[][] dp = new int[n][4];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = h(n - 1, 3, points, dp);
        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        return ans;
    }

    public static int h(int n, int last, int[][] points, int[][] dp) {
        if (n == 0) {
            int maxi = 0;
            for (int i = 0; i < 3; ++i) {
                if (i != last) {
                    maxi = Math.max(points[0][i], maxi);
                }
            }
            return maxi;
        }
        if (dp[n][last] != -1)
            return dp[n][last];
        int max = 0;
        for (int task = 0; task < 3; ++task) {

            if (task != last) {
                int point = points[n][task] + h(n - 1, task, points, dp);
                max = Math.max(max, point);

            }
        }
        return dp[n][last] = max;
    }
}
