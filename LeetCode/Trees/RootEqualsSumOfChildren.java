package LeetCode.Trees;

import DataStructures.BTree.TreeNode;

public class RootEqualsSumOfChildren {
    public static boolean checkTree(TreeNode root) {
        if (root.val == sumUtil(root.left) + sumUtil(root.right))
            return true;
        return false;
    }

    public static int sumUtil(TreeNode root) {
        if (root == null)
            return 0;
        return root.val + sumUtil(root.left) + sumUtil(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        System.out.println(checkTree(root));
    }
}
