package Aug11;

import java.util.Arrays;

public class MinimumCostStringGeneration {

    public static int minimumCost(String S, String[] words, int K, int[] costs) {
        int[] dp = new int[S.length() + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= S.length(); i++) {
            for (int j = 0; j < K; j++) {
                if (i >= words[j].length()) {
                    String suffix = S.substring(i - words[j].length(), i);
                    if (suffix.equals(words[j])) {
                        int prevCost = (i - words[j].length() == 0) ? 0 : dp[i - words[j].length()];
                        dp[i] = Math.min(dp[i], prevCost + costs[j]);
                    }
                }
            }
        }

        return (dp[S.length()] == Integer.MAX_VALUE) ? -1 : dp[S.length()];
    }

    public static void main(String[] args) {
        String S = "lockdown";
        String[] words = { "lock", "down", "lo", "ck" };
        int K = words.length;
        int[] costs = { 50, 50, 5, 5 };

        int minimumCost = minimumCost(S, words, K, costs);

        if (minimumCost == -1) {
            System.out.println("No possible way to generate the string.");
        } else {
            System.out.println("Minimum cost: " + minimumCost);
        }
    }
}
