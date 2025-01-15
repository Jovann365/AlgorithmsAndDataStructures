package LeetCode.Trees;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/?envType=problem-list-v2&envId=tree

Given an n-ary tree, return the level order traversal of its nodes' values.
Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

Example 1:

Input: root = [1,null,3,2,4,null,5,6]
Output: [[1],[3,2,4],[5,6]]
Example 2:

Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 */


// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class NTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        int n = treeDepth(root);
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            levelOrderUtil(root, i, 0, list);
            result.add(list);
        }
        return result;
    }

    public static int treeDepth(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.children == null || root.children.isEmpty()) {
            return 1;
        }

        int maxDepth = 0;
        for (Node child : root.children) {
            int childDepth = treeDepth(child);
            if (childDepth > maxDepth) {
                maxDepth = childDepth;
            }
        }

        return maxDepth + 1;
    }

    public static List<Integer> levelOrderUtil(Node node, int level, int currLevel, List<Integer> list) {
        if (node == null)
            return null;
        if (level == currLevel) {
            list.add(node.val);
        }
        if (node.children == null)
            return list;
        for (Node child : node.children) {
            levelOrderUtil(child, level, currLevel+1, list);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Node> list1 = new ArrayList<>();
        list1.add(new Node(2));
        list1.add(new Node(4));
        List<Node> list2 = new ArrayList<>();
        list2.add(new Node(5));
        list2.add(new Node(6));
        Node node3 = new Node(3, list2);
        list1.add(node3);
        Node root = new Node(1, list1);
        System.out.println(levelOrder(root).toString());
    }

}
