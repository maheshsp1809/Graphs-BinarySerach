import java.util.*;

public class Disjoint {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> sizes = new ArrayList<>();

    public Disjoint(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            sizes.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByrank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v)
            return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_u) > rank.get(ulp_v)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }

    }

    public void unionBysize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v)
            return;
        if (sizes.get(ulp_u) > sizes.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            int sizeU = sizes.get(ulp_u);
            int sizeV = sizes.get(ulp_v);
            sizes.set(ulp_u, sizeU + sizeV);
        } else {
            parent.set(ulp_v, ulp_u);
            int sizeU = sizes.get(ulp_u);
            int sizeV = sizes.get(ulp_v);
            sizes.set(ulp_v, sizeU + sizeV);
        }

    }

    public static void main(String[] args) {
        Disjoint ds = new Disjoint(7);
        ds.unionBysize(1, 2);
        ds.unionBysize(2, 3);
        ds.unionBysize(4, 5);
        ds.unionBysize(6, 7);
        ds.unionBysize(5, 6);
        // if 3 and 7 belong to same componenet or not
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("same");
        } else {
            System.out.println("not smae");
        }
        ds.unionByrank(3, 7);
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("same");
        } else {
            System.out.println("not smae");
        }

    }
}
