package LeetCode.Trees;

import DataStructures.BTree.TreeNode;
import DataStructures.Tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
https://leetcode.com/problems/path-sum-ii/description/?envType=problem-list-v2&envId=tree
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

Example 1:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
Example 2:

Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:

Input: root = [1,2], targetSum = 0
Output: []
 */

public class PathSumII {
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        pathSumUtil(root, targetSum, result, currList, 0);
        return result;
    }

    public static void pathSumUtil(TreeNode node, int targetSum, List<List<Integer>> result, List<Integer> currList, int sum) {
       if (node == null)
           return;
       if (sum + node.val != targetSum || (sum + node.val == targetSum && (node.left != null || node.right != null))){
           currList.add(node.val);
           sum += node.val;
       }
       else if (sum + node.val == targetSum && node.left == null && node.right == null) {
           currList.add(node.val);
           sum += node.val;
           List<Integer> newList = new ArrayList<>();
           for (int i = 0; i < currList.size(); i++) {
               newList.add(i, currList.get(i));
           }
           result.add(newList);
       }
       if (node.left != null) {
           pathSumUtil(node.left, targetSum, result, currList, sum);
       }
       if (node.right != null) {
           pathSumUtil(node.right, targetSum, result, currList, sum);
       }
        if (!currList.isEmpty()) {
            sum = sum - node.val;
            currList.removeLast();
        } else {
           return;
       }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println(pathSum(root, 3).toString());
    }
}
