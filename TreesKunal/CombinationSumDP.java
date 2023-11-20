package TreesKunal;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumDP {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<List<Integer>>> dp = new ArrayList<>();

        for (int i = 0; i <= target; i++) {
            dp.add(new ArrayList<>());
        }

        dp.get(0).add(new ArrayList<>()); // Base case: There's one way to get a sum of 0, which is an empty list.

        for (int candidate : candidates) {
            for (int i = candidate; i <= target; i++) {
                for (List<Integer> prevList : dp.get(i - candidate)) {
                    List<Integer> newList = new ArrayList<>(prevList);
                    newList.add(candidate);
                    dp.get(i).add(newList);
                }
            }
        }
        System.out.println(dp);
        return dp.get(target);
    }

    public static void main(String[] args) {
        CombinationSumDP solution = new CombinationSumDP();
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        List<List<Integer>> combinations = solution.combinationSum(candidates, target);

        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}
