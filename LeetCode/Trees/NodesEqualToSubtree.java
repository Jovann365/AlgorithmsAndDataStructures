package LeetCode.Trees;

import DataStructures.BTree.TreeNode;

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
