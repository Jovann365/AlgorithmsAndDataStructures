package LeetCode.Trees;

import DataStructures.BTree.TreeNode;
import DataStructures.SearchTrees.BinarySearchTree;

/*
https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/?envType=problem-list-v2&envId=tree
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Example 1:

Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 */

public class KthSmallestInABST {
    static BinarySearchTree<Integer> tmp = new BinarySearchTree<>();
    public static int kthSmallest(TreeNode root, int k) {
        BinarySearchTree<Integer> tree = makeTree(root);
        for (int i = 0; i < k - 1; i++){
            tree.remove(tree.findMin());
        }
        return tree.findMin();
    }
    public static BinarySearchTree<Integer> makeTree (TreeNode root) {
        if (root == null)
            return null;
        else {
            tmp.insert(root.val);
            makeTree(root.left);
            makeTree(root.right);
        }
        return tmp;
    }
}
