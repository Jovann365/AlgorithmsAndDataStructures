package Exercises;

import DataStructures.BTree.BNode;

public class MaxOneDifference {
    public static int maxDistance(BNode<Integer> root) {
        return 1 + maxDistanceUtil(root);
    }

    public static int maxDistanceUtil(BNode<Integer> root) {
        if (root == null) return 0;
        if ((root.left != null && root.info + 1 == root.left.info) || (root.right != null && root.info + 1 == root.right.info)) {
            return 1 + Math.max(maxDistanceUtil(root.left), maxDistanceUtil(root.right));
        }
        return Math.max(maxDistanceUtil(root.left), maxDistanceUtil(root.right));
    }

    public static void main(String[] args) {
        BNode<Integer> root = new BNode<>(5);
        root.left = new BNode<>(8);
        root.right = new BNode<>(11);
        root.left.left = new BNode<>(9);
        root.left.left.left = new BNode<>(6);
        root.right.right = new BNode<>(10);
        root.right.right.left = new BNode<>(15);
        System.out.println(maxDistance(root));
    }
}
