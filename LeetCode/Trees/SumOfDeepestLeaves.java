package LeetCode.Trees;

import DataStructures.BTree.TreeNode;

/*
https://leetcode.com/problems/deepest-leaves-sum/description/?envType=problem-list-v2&envId=tree

Given the root of a binary tree, return the sum of values of its deepest leaves.

Example 1:

Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15

Example 2:

Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 19
 */

public class SumOfDeepestLeaves {
    static int sum = 0;
    public static int deepestLeavesSum(TreeNode root) {
        int depth = findDepth(root);
        sum = 0;
        deepestLeavesSumUtil(root, depth, 1);
        return sum;
    }

    public static void deepestLeavesSumUtil (TreeNode root, int level, int currLevel) {
        if (root == null)
            return;
        if (currLevel == level)
            sum += root.val;
        deepestLeavesSumUtil(root.left, level, currLevel+1);
        deepestLeavesSumUtil(root.right, level, currLevel+1);
    }

    public static int findDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(findDepth(root.left), findDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(deepestLeavesSum(root));
    }
}
