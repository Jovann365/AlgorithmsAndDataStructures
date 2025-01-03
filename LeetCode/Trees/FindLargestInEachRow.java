package LeetCode.Trees;

import DataStructures.BTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/?envType=problem-list-v2&envId=tree
Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).

Example 1:

Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]
Example 2:

Input: root = [1,2,3]
Output: [1,3]
 */

public class FindLargestInEachRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> maxItems = new ArrayList<>();
        if (root == null) return maxItems;
        largestValuesUtil(root, maxItems, 0);
        return maxItems;
    }

    public void largestValuesUtil(TreeNode root, List<Integer> maxItems, int level) {
        if (maxItems.size() > level) {
            if (root.val > maxItems.get(level)) {
                maxItems.set(level, root.val);
            }
        } else {
            maxItems.add(root.val);
        }

        if (root.left != null) {
            largestValuesUtil(root.left, maxItems, level+1);
        }
        if (root.right != null) {
            largestValuesUtil(root.right, maxItems, level+1);
        }
    }
}
