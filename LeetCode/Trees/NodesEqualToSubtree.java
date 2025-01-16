package LeetCode.Trees;

import DataStructures.BTree.TreeNode;

/*
https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/description/?envType=problem-list-v2&envId=tree

Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.
Note:
The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
A subtree of root is a tree consisting of root and all of its descendants.

Example 1:

Input: root = [4,8,5,0,1,null,6]
Output: 5
Explanation:
For the node with value 4: The average of its subtree is (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4.
For the node with value 5: The average of its subtree is (5 + 6) / 2 = 11 / 2 = 5.
For the node with value 0: The average of its subtree is 0 / 1 = 0.
For the node with value 1: The average of its subtree is 1 / 1 = 1.
For the node with value 6: The average of its subtree is 6 / 1 = 6.
Example 2:

Input: root = [1]
Output: 1
Explanation: For the node with value 1: The average of its subtree is 1 / 1 = 1.
 */

public class NodesEqualToSubtree {
    public static int averageOfSubtree(TreeNode root) {
        if (root == null)
            return 0;
        int average = findSum(root) / findCount(root);
        if (root.val == average)
            return 1 + averageOfSubtree(root.left) + averageOfSubtree(root.right);
        return averageOfSubtree(root.left) + averageOfSubtree(root.right);
    }

    public static int findSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + findSum(root.left) + findSum(root.right);
    }

    public static int findCount(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + findCount(root.left) + findCount(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(averageOfSubtree(root));
    }
}
