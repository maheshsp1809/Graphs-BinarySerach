package TreesKunal;

public class BinaryTree {

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

        if (value < node.data) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }

        return node;
    }

    public static int height(Node node) {
        if (node == null)
            return 0;
        int l = height(node.left);
        int r = height(node.right);
        return 1 + Math.max(l, r);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        bt.insert(6);
        bt.insert(5);
        bt.insert(4);
        bt.insert(4);
        bt.insert(3);
        bt.insert(2);

        int h = height(bt.root);
        System.out.println(h);

    }
}