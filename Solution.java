import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int V = sc.nextInt();
        int e = sc.nextInt();
        List<List<Integer>> adjr = new ArrayList<List<Integer>>();
        for (int i = 0; i < V; ++i) {
            adjr.add(new ArrayList<>());
        }
        for (int i = 0; i < e; ++i) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjr.get(v).add(u);
        }

    }
}