package LeetCode.Trees;

import DataStructures.BTree.TreeNode;
import DataStructures.Tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
