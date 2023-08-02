package Aug3;

import java.util.*;

public class AlienDict {
    public static void main(String[] args) {
        int N = 5;
        int K = 4;
        String[] dict = { "baa", "abcd", "abca", "cab", "cad" };

        Solution ob = new Solution();
        String order = ob.findOrder(dict, N, K);
        System.out.println(order);
    }
}

class Solution {
    public String findOrder(String[] dict, int n, int K) {
        HashMap<Character, List<Character>> adja = new HashMap<>();
        for (int i = 0; i < K; ++i) {
            char vertex = (char) (i + 'a');
            adja.put(vertex, new ArrayList<>());
        }
        for (int i = 1; i < n; ++i) {
            String w1 = dict[i - 1];
            String w2 = dict[i];
            int minl = Math.min(w1.length(), w2.length());
            for (int j = 0; j < minl; ++j) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adja.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }

        List<Character> topo = topoSort(K, adja);
        StringBuilder ans = new StringBuilder();
        for (char c : topo) {
            ans.append(c);
        }
        return ans.toString();
    }

    public static List<Character> topoSort(int V, HashMap<Character, List<Character>> adj) {
        int[] indegree = new int[V];
        for (char vertex : adj.keySet()) {
            for (char neighbor : adj.get(vertex)) {
                indegree[neighbor - 'a']++;
            }
        }
        Queue<Character> q = new LinkedList<>();
        for (char vertex : adj.keySet()) {
            if (indegree[vertex - 'a'] == 0) {
                q.add(vertex);
            }
        }
        List<Character> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            char node = q.poll();
            topo.add(node);
            for (char neighbor : adj.get(node)) {
                indegree[neighbor - 'a']--;
                if (indegree[neighbor - 'a'] == 0)
                    q.add(neighbor);
            }
        }
        return topo;
    }
}
