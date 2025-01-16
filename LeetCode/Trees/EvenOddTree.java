package LeetCode.Trees;

/*
https://leetcode.com/problems/even-odd-tree/description/?envType=problem-list-v2&envId=tree

A binary tree is named Even-Odd if it meets the following conditions:
The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.

Example 1:

Input: root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
Output: true
Explanation: The node values on each level are:
Level 0: [1]
Level 1: [10,4]
Level 2: [3,7,9]
Level 3: [12,8,6,2]
Since levels 0 and 2 are all odd and increasing and levels 1 and 3 are all even and decreasing, the tree is Even-Odd.
Example 2:

Input: root = [5,4,2,3,3,7]
Output: false
Explanation: The node values on each level are:
Level 0: [5]
Level 1: [4,2]
Level 2: [3,3,7]
Node values in level 2 must be in strictly increasing order, so the tree is not Even-Odd.
Example 3:

Input: root = [5,9,1,3,5,7]
Output: false
Explanation: Node values in the level 1 should be even integers.
 */


import DataStructures.BTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class EvenOddTree {
    static boolean check = true;
    public static boolean isEvenOddTree(TreeNode root) {
        check = true;
        List<List<Integer>> levels = new ArrayList<>();
        isEvenOddTreeUtil(root, 0, levels);
        return check;
    }

    public static void isEvenOddTreeUtil(TreeNode root, int level, List<List<Integer>> levels){
        if (root == null)
            return;
        if (levels.size()-1 < level)
            levels.add(level, new ArrayList<>());
        if (level % 2 == 0 && root.val % 2 == 0)
            check = false;
        if (level % 2 == 1 && root.val % 2 == 1)
            check = false;
        if (!levels.get(level).isEmpty()) {
            if (level % 2 == 0 && levels.get(level).getLast() >= root.val)
                check = false;
            if (level % 2 == 1 && levels.get(level).getLast() <= root.val)
                check = false;
        }
        levels.get(level).add(root.val);
        isEvenOddTreeUtil(root.left, level+1, levels);
        isEvenOddTreeUtil(root.right, level+1, levels);
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(3);
//        root.right.left = new TreeNode(7);

        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(2);
        System.out.println(isEvenOddTree(root));
    }
}
