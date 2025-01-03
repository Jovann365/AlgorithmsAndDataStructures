package LeetCode.Trees;

import java.util.ArrayList;
import java.util.List;
import DataStructures.BTree.TreeNode;

/*
https://leetcode.com/problems/binary-tree-level-order-traversal/description/?envType=problem-list-v2&envId=tree
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 */

public class BTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> finalResult = new ArrayList<>();
        int n = depth(root) + 1;
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            findRow(root, 0, i, row);
            if (!row.isEmpty())
                finalResult.add(row);
        }
        return finalResult;
    }

    public static List<Integer> findRow(TreeNode node, int currLevel, int level, List<Integer> row) {
        if (node == null)
            return row;
        if (currLevel == level)
            row.add(node.val);
        findRow(node.left, currLevel+1, level, row);
        findRow(node.right, currLevel+1, level, row);
        return row;
    }

    public static int depth(TreeNode node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 0;
        return 1 + Math.max(depth(node.left), depth(node.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(3);
        System.out.println(levelOrder(root).toString());
    }
}
