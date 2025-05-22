package BST;

import java.util.ArrayList;

public class binarySearchTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root,int val) {
        if (root == null) {
            root = new Node(val);
            root.data = val;
            return root;
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        }
        else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return search(root.left, key);
        }
        else {
            return search(root.right, key);
        }
    }

    public static Node delete(Node root, int val) {
        if (root.data > val) {
            root.left = delete(root.left, val);
        }
        else if (root.data < val) {
            root.right = delete(root.right, val);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }
            Node Is = findInorderSuccessor(root.right);
            root.data = Is.data;
            delete(root.right, val);
            root.right = delete(root.right, Is.data);
        }
        return root;

    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // print in range code
    public static void printInRange(Node root, int X, int Y) {
        if (root == null) {
            return;
        }
        if (root.data >= X && root.data <= Y) {
            printInRange(root.left, X, Y);
            System.out.print(root.data + " ");
            printInRange(root.right, X, Y);
        }
        else if (root.data >= X) {
            printInRange(root.left, X, Y);
        }
        else {
            printInRange(root.right, X, Y);
        }
        
    }

    // root to leaf path code
    public static void printRootToLeaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            System.out.println(path);
        }
        printRootToLeaf(root.left, path);
        printRootToLeaf(root.right, path);
        path.remove(path.size() - 1);

}

    public static void main(String[] args) {
        //   int values[] = {5, 1, 3, 4, 2, 7};
        // int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        int values[] = {8, 5, 3, 6, 10, 11, 14};
          Node root = null;
          for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
          }
        //   inOrder(root);
        //   System.out.println();
        // if (search(root, 7)) {
        //     System.out.println("Found");
        // } else {
        //     System.out.println("Not Found");
        // }
        // root = delete(root, 4);
        // root = delete(root, 10);
        // root = delete(root, 5);
        // inOrder(root);
        // printInRange(root, 3, 12);
        ArrayList<Integer> path = new ArrayList<>();
        printRootToLeaf(root, path);
    }
}
