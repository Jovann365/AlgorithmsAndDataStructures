package LeetCode.Trees;

import DataStructures.BTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/longest-univalue-path/description/?envType=problem-list-v2&envId=tree

DIDNT PASS ALL TEST CASES!!!
Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value. This path may or may not pass through the root.
The length of the path between two nodes is represented by the number of edges between them.

Example 1:

Input: root = [5,4,5,1,1,null,5]
Output: 2
Explanation: The shown image shows that the longest path of the same value (i.e. 5).
Example 2:

Input: root = [1,4,5,4,4,null,5]
Output: 2
Explanation: The shown image shows that the longest path of the same value (i.e. 4).
 */


public class LongestUnivaluePath {
    public static int longestUnivaluePath(TreeNode root) {
        List<Integer> max = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        max.add(0);
        curr.add(0);
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 0;
        longestUnivaluePathUtil(root.left, root.val, curr, max);
        longestUnivaluePathUtil(root.right, root.val, curr, max);
        return max.getLast();
    }

    public static void longestUnivaluePathUtil (TreeNode root, int currElement, List<Integer> curr, List<Integer> max) {
        if (root == null) {
            curr.set(curr.size()-1, 0);
            return;
        }
        if (root.val == currElement) {
            curr.set(curr.size() -1, curr.getLast()+1);
            if (!max.isEmpty() && curr.getLast() > max.getLast()) {
                max.add(curr.getLast());
            }
        }
        else {
            curr.set(curr.size() -1, 0);
            currElement = root.val;
        }
        if (root.left != null) {
            longestUnivaluePathUtil(root.left, currElement, curr, max);
        }
        if (root.right != null) {
            longestUnivaluePathUtil(root.right, currElement, curr, max);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        TreeNode rootL = new TreeNode(4);
//        TreeNode rootR = new TreeNode(5);
//        rootL.left = new TreeNode(4);
//        rootL.right = new TreeNode(4);
//        rootR.right = new TreeNode(5);
//        root.left = rootL;
//        root.right = rootR;



        System.out.println(longestUnivaluePath(root));
    }
}
