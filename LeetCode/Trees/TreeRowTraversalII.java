package LeetCode.Trees;

import DataStructures.BTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeRowTraversalII {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int n = depth(root) + 1;
        for (int i = n-1; i >= 0; i--) {
            List<Integer> row = new ArrayList<>();
            getRow(root, row, 0, i);
            if (!row.isEmpty())
                result.add(row);
        }
        return result;
    }

    public static void getRow(TreeNode node, List<Integer> row, int currLevel, int level) {
        if (node == null)
            return;
        if (currLevel == level)
            row.add(node.val);
        getRow(node.left, row, currLevel+1, level);
        getRow(node.right, row, currLevel+1, level);
    }

    public static int depth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(levelOrderBottom(root).toString());
    }
}
