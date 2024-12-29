package LeetCode.Trees;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SumRootToLeafNumbers {
    public static int sumNumbers(TreeNode root) {
        return sumNumbersUtil(root, 0);
    }
    public static int sumNumbersUtil(TreeNode root, int number) {
        if (root == null) {
            return 0;
        }
        number = number * 10 + root.val;
        if (root.left == null && root.right == null) {
            return number;
        }
        return sumNumbersUtil(root.left, number) + sumNumbersUtil(root.right, number);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sumNumbers(root));
    }
}
