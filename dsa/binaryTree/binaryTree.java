// package binaryTree;

// import java.util.Arrays;
// import java.util.LinkedList;
// import java.util.Queue;

// public class binaryTree {
//     static class Node {
//         int data;
//         Node left;
//         Node right;

//         Node(int data) {
//             this.data = data;
//             this.left = null;
//             this.right = null;
//         }
//     }

//     static class BinaryTree {
//         static int idx = -1;

//         public static Node buildTree(int nodes[]) {
//             idx++;
//             if (nodes[idx] == -1) {
//                 return null;
//             }
//             Node newNode = new Node(nodes[idx]);
//             newNode.left = buildTree(nodes);
//             newNode.right = buildTree(nodes);
//             return newNode;
//         }
//     }

//     public static void preOrder(Node root) {
//         if (root == null) {
//             return;
//         }
//         System.out.print(root.data);
//         preOrder(root.left);
//         preOrder(root.right);
//     }

//     public static void inOrder(Node root) {
//         if (root == null) {
//             return;
//         }
//         inOrder(root.left);
//         System.out.print(root.data + " ");
//         inOrder(root.right);
//     }

//     public static void postOrder(Node root) {
//         if (root == null) {
//             return;
//         }
//         postOrder(root.left);
//         postOrder(root.right);
//         System.out.print(root.data + " ");
//     }

//     public static void levelOrder(Node root) {
//         if (root == null) {
//             return;
//         }
//         Queue<Node> q = new LinkedList<>();
//         q.add(root);
//         q.add(null);

//         while (!q.isEmpty()) {
//             Node currNode = q.remove();
//             if (currNode == null) {
//                 System.out.println();
//                 if (!q.isEmpty()) {
//                     q.add(null);
//                 } else {
//                     break;
//                 }
//             } else {
//                 System.out.print(currNode.data + " ");
//                 if (currNode.left != null) {
//                     q.add(currNode.left);
//                 }
//                 if (currNode.right != null) {
//                     q.add(currNode.right);
//                 }
//             }
//         }
//     }

//     public static int countOfNodes(Node root) {
//         if (root == null) {
//             return 0;
//         }
//         int leftNodes = countOfNodes(root.left);
//         int rightNodes = countOfNodes(root.right);
//         return leftNodes + rightNodes + 1;
//     }

//     public static int sumOfNodes(Node root) {
//         if (root == null) {
//             return 0;
//         }
//         int leftSum = sumOfNodes(root.left);
//         int rightSum = sumOfNodes(root.right);
//         return leftSum + rightSum + root.data;
//     }

//     public static int heightOfTree(Node root) {
//         if (root == null) {
//             return 0;
//         }
//         int leftHeight = heightOfTree(root.left);
//         int rightHeight = heightOfTree(root.right);
//         return Math.max(leftHeight, rightHeight) + 1;
//     }

//     public static int diameterOfTree(Node root) {
//         if (root == null) {
//             return 0;
//         }
//         int leftDiameter = diameterOfTree(root.left);
//         int rightDiameter = diameterOfTree(root.right);
//         int leftHeight = heightOfTree(root.left);
//         int rightHeight = heightOfTree(root.right);
//         int selfDiameter = leftHeight + rightHeight + 1;
//         return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));
//     }

//     static class TreeInfo {
//         int diameter;
//         int height;
//         TreeInfo(int diameter, int height) {
//             this.diameter = diameter;
//             this.height = height;
//         }
//     }
    
//     public static TreeInfo diameter(Node root) {
//         if (root == null) {
//             return new TreeInfo(0, 0);
//         }
//         TreeInfo left = diameter(root.left);
//         TreeInfo right = diameter(root.right);
//         int selfDiameter = left.height + right.height + 1;
//         int maxDiameter = Math.max(selfDiameter, Math.max(left.diameter, right.diameter));
//         int maxHeight = Math.max(left.height, right.height) + 1;
//         return new TreeInfo(maxDiameter, maxHeight);
//     }
    
//     public static boolean isSubTree(Node root, Node subRoot) {
//         if (root == null && subRoot == null) {
//             return true;
//         }
//         if (root == null || subRoot == null) {
//             return false;
//         }
//         if (root.data == subRoot.data) {
//             if (isSubTree(root.left, subRoot.left) && isSubTree(root.right, subRoot.right)) {
//                 return true;
//             }
//         }
//         return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
//         }

//     public static Node buildTree(int nodes[]) {
//         if (nodes.length == 0) {
//             return null;
//         }
//         Node newNode = new Node(nodes[0]);
//         int index = 0;
//         for (int i = 0; i < nodes.length; i++) {
//             if (nodes[i] != -1) {
//                 index = i;
//                 break;
//             }
//         }
//         newNode.left = buildTree(Arrays.copyOfRange(nodes, 1, index + 1));
//         newNode.right = buildTree(Arrays.copyOfRange(nodes, index + 1, nodes.length));
//         return newNode;

//     }

//     public static void main(String[] args) {
//         int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
//         BinaryTree tree = new BinaryTree();
//         Node root = tree.buildTree(nodes);
//         // System.out.println(root.data);
//         // preOrder(root);
//         // inOrder(root);
//         // postOrder(root);
//         // levelOrder(root);
//         // System.out.println(countOfNodes(root));
//         // System.out.println(sumOfNodes(root));
//         // System.out.println(heightOfTree(root));
//         // System.out.println(diameterOfTree(root));
//         // TreeInfo treeInfo = diameter(root);
//         // System.out.println(treeInfo.diameter);1
//         // System.out.println(isSubTree(root, root.left));
//         System.out.println(root.data);


//     }
// }

