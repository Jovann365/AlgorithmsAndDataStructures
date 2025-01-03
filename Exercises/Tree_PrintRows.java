package Exercises;

/*
Print the tree by its rows.
Example:
Input:      Output:
    1       1
   / \      2 3
  2   3
*/

import DataStructures.BTree.BNode;
import DataStructures.BTree.BTree;

public class Tree_PrintRows {
    public static void printTree (BTree<Integer> tree) {
        int n = tree.depth() + 1;
        for (int i = 0; i < n; i++) {
            printRowUtil(tree.root, 0, i);
            System.out.println();
        }
    }

    public static void printRowUtil (BNode<Integer> node, int currLevel, int level) {
        if (node == null)
            return;
        if (currLevel == level)
            System.out.print(node.info + " ");
        printRowUtil(node.left, currLevel+1, level);
        printRowUtil(node.right, currLevel+1, level);
    }

    public static void main(String[] args) {
        BTree<Integer> tree = new BTree<>(1);
        BNode<Integer> root = tree.root;
        root.left = new BNode<>(2);
        root.right = new BNode<>(3);
        root.left.left = new BNode<>(4);
        root.right.right = new BNode<>(5);
        root.right.right.left = new BNode<>(6);
        root.right.right.left.right = new BNode<>(7);
        printTree(tree);
    }
}
