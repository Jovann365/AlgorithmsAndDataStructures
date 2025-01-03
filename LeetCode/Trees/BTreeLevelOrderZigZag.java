package LeetCode.Trees;

import DataStructures.BTree.TreeNode;
import DataStructures.Tree.Tree;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/?envType=problem-list-v2&envId=tree
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 */

public class BTreeLevelOrderZigZag {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int n = depth(root) + 1;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            findRow(root, 0, i, row);
            if (i % 2 == 1)
                row = row.reversed();
            if (!row.isEmpty())
                result.add(row);
        }
        return result;
    }

    public static List<Integer> findRow(TreeNode node, int currLevel, int level, List<Integer> row) {
        if (node == null)
            return null;
        if (currLevel == level)
            row.add(node.val);
        findRow(node.left, currLevel + 1, level, row);
        findRow(node.right, currLevel + 1, level, row);
        return row;
    }

    public static int depth(TreeNode node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 0;
        return 1 + Math.max(depth(node.right), depth(node.left));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(3);
        System.out.println(zigzagLevelOrder(root).toString());
    }
}
