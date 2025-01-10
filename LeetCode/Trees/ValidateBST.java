package LeetCode.Trees;

import DataStructures.BTree.TreeNode;

// Not valid solution

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (root == null) return true;
        boolean l = true;
        boolean r = true;
        if (left != null) {
            if (left.val >= root.val) return false;
            l = isValidBSTUtil(left.left, left, right) && isValidBSTUtil(left.right, left, right);
        }
        if (right != null) {
            if (right.val <= root.val) return false;
            r = isValidBSTUtil(right.left, left, right) && isValidBSTUtil(right.right, left, right);
        }
        return l && r;
    }

    public boolean isValidBSTUtil(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null) return true;
        if (root.left != null && (root.left.val >= root.val || root.left.val >= right.val)) return false;
        if (root.right != null && (root.right.val <= root.val || root.right.val <= left.val)) return false;
        return isValidBSTUtil(root.left, left, right) && isValidBSTUtil(root.right, left, right);
    }
}
