package Graphs-BinarySerach;

import java.util.ArrayList;

public class MaximumNonAdjacent {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int max = Integer.MIN_VALUE;
        if (nums.size() == 1)
            return nums.get(0);

        int prev2 = 0;
        int prev = nums.get(0);
        int pick = Integer.MIN_VALUE;
        for (int ind = 1; ind < nums.size(); ++ind) {
            pick = nums.get(ind);
            if (ind > 1)
                pick += prev2;
            int notpick = prev;
            int cur = Math.max(pick, notpick);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }

    public static int h(ArrayList<Integer> nums, ArrayList<Integer> dp, int ind) {
        if (ind < 0)
            return 0;
        if (ind == 0)
            return nums.get(0);
        if (dp.get(ind) != 0)
            return dp.get(ind);
        int pick = nums.get(ind) + h(nums, dp, ind - 2);
        int notpick = 0 + h(nums, dp, ind - 1);
        dp.set(ind, Math.max(pick, notpick));
        return dp.get(ind);
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(List.of(2, 7, 9, 3, 1, 8, 4, 5));
        System.out.println("Maximum Non-Adjacent Sum: " + maximumNonAdjacentSum(nums));
    }
}
import java.util.*;
import java.io.*;
import java.util.*;

public class Solution {
    // public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
    // ArrayList<Integer> dp=new ArrayList<>();
    // for(int i=0;i<nums.size();++i){
    // dp.add(0);
    // }
    // if(nums.size()==1)
    // return nums.get(0);
    // dp.set(0,nums.get(0));
    // int pick=nums.get(1);
    // for(int ind=1;ind<nums.size();++ind){
    // if(ind>1)
    // pick=nums.get(ind)+dp.get(ind-2);
    // int notpick=dp.get(ind-1);
    // dp.set(ind,Math.max(pick,notpick));
    // }
    // return dp.get(dp.size()-1);

    // // return h(nums,dp,nums.size()-1);
    // }
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int max = Integer.MIN_VALUE;
        if (nums.size() == 1)
            return nums.get(0);

        int prev2 = 0;
        int prev = nums.get(0);
        int pick = Integer.MIN_VALUE;
        for (int ind = 1; ind < nums.size(); ++ind) {
            pick = nums.get(ind);
            if (ind > 1)
                pick += prev2;
            int notpick = prev;
            int cur = Math.max(pick, notpick);
            prev2 = prev;
            prev = cur;
        }
        return prev;

    }

    public static int h(ArrayList<Integer> nums, ArrayList<Integer> dp, int ind) {
        if (ind < 0)
            return 0;
        if (ind == 0)
            return nums.get(0);
        if (dp.get(ind) != 0)
            return dp.get(ind);
        int pick = nums.get(ind) + h(nums, dp, ind - 2);
        int notpick = 0 + h(nums, dp, ind - 1);
        dp.set(ind, Math.max(pick, notpick));
        return dp.get(ind);
    }
}
