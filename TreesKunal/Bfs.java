package TreesKunal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Bfs {

    Node root;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Insert a node
    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (node.left == null) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }

        return node;
    }

    public static ArrayList<ArrayList<Integer>> levelorder(Node node) {
        if (node == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        q.add(node);
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node nody = q.poll();
                level.add(nody.data);
                if (nody.left != null) {
                    q.add(nody.left);

                }
                if (nody.right != null) {
                    q.add(nody.right);

                }
            }
            result.add(level);

        }
        return result;
    }

    public static List<Double> averageOfLevels(Node node) {
        if (node == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        q.add(node);
        while (!q.isEmpty()) {
            int size = q.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                Node nody = q.poll();
                sum += nody.data;
                if (nody.left != null) {
                    q.add(nody.left);

                }
                if (nody.right != null) {
                    q.add(nody.right);

                }
            }
            result.add(sum / size);
        }
        return result;
    }

    public static int nextRight(Node node, int val) {
        if (node == null)
            return -1;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node nody = q.poll();
            if (nody.left != null) {
                q.add(nody.left);

            }
            if (nody.right != null) {
                q.add(nody.right);

            }
            if (nody.data == val) {
                return q.poll().data;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Bfs bt = new Bfs();

        bt.insert(1);
        bt.insert(2);
        bt.insert(3);
        bt.insert(4);
        bt.insert(8);
        bt.insert(6);
        bt.insert(7);

        ArrayList<ArrayList<Integer>> ans = levelorder(bt.root);
        System.out.println(ans);

        System.out.println();

        // 2. Average of levels question
        List<Double> ans2 = averageOfLevels(bt.root);
        System.out.println("Average of levels" + ans2);
        System.out.println();

        // 3.NextRight element in a binary tree
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter whose next Right you want");
        int valToSearch = obj.nextInt();
        int nextRightValue = nextRight(bt.root, valToSearch);
        System.out.println("Next right value: " + nextRightValue);
        obj.close();
    }
}
