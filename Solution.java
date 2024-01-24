package GraphsBinarySerach;

import java.util.*;

public class Solution {
    public List<Integer> getTotalExecutionTime(int n, List<String> logs) {
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        int prevTimestamp = 0;

        for (String log : logs) {
            String[] params = log.split(":");

            int functionId = Integer.parseInt(params[0]);
            int timestamp = Integer.parseInt(params[2]);

            if (params[1].equals("start")) {
                // start
                if (!stack.empty()) {
                    result[stack.peek()] += timestamp - prevTimestamp;
                }

                stack.push(functionId);

                prevTimestamp = timestamp;
            } else {
                // end
                stack.pop();

                result[functionId] += timestamp - prevTimestamp + 1;

                prevTimestamp = timestamp + 1;
            }
        }

        List<Integer> resultList = new ArrayList<>();
        for (int value : result) {
            resultList.add(value);
        }

        return resultList;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 3;
        List<String> logs = Arrays.asList("0:start:0", "2:start:4", "2:end:5", "1:start:7", "1:end:10", "0:end:11");

        List<Integer> result = solution.getTotalExecutionTime(n, logs);

        // Print the result
        for (int time : result) {
            System.out.println(time);
        }
    }
}
