package Nov29;

import java.util.HashMap;
import java.util.Map;

class DisjointSet {
    private Map<Integer, Integer> parent;
    private Map<Integer, Integer> rank;

    public DisjointSet() {
        parent = new HashMap<>();
        rank = new HashMap<>();
    }

    public void makeSet(int v) {
        parent.put(v, v);
        rank.put(v, 0);
    }

    public int find(int v) {
        if (v != parent.get(v)) {
            parent.put(v, find(parent.get(v))); // Path compression
        }
        return parent.get(v);
    }

    public void union(int root1, int root2) {
        if (rank.get(root1) > rank.get(root2)) {
            parent.put(root2, root1);
        } else if (rank.get(root1) < rank.get(root2)) {
            parent.put(root1, root2);
        } else {
            parent.put(root1, root2);
            rank.put(root2, rank.get(root2) + 1);
        }
    }
}

public class DisjointSetGraphProblem {
    public static void main(String[] args) {
        // Example usage:
        DisjointSet ds = new DisjointSet();

        // Create sets for vertices 1, 2, 3, 4
        for (int i = 1; i <= 4; i++) {
            ds.makeSet(i);
        }

        // Perform some union operations
        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 1);

        // Check if two vertices are in the same set
        System.out.println("Are 2 and 3 in the same set? " + (ds.find(2) == ds.find(3)));
        System.out.println("Are 1 and 4 in the same set? " + (ds.find(1) == ds.find(4)));
    }
}
