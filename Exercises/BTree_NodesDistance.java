package Exercises;



/*
Find the distance between two nodes of a tree

Test case:
7
1 ROOT
1 LEFT 2
1 RIGHT 3
2 LEFT 4
3 RIGHT 5
2 RIGHT 6
3 LEFT 7
2
1 7
3 4
2 6
 */

import DataStructures.BTree.BNode;
import DataStructures.BTree.BTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BTree_NodesDistance {
    public static boolean findPath(BNode<Integer> root, int destination, List<Integer> path) {
        if (root == null) {
            return false;
        }
        path.add(root.info);
        if (root.info == destination) {
            return true;
        }
        if (findPath(root.left, destination, path) || findPath(root.right, destination, path)){
            return true;
        }
        path.removeLast();
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BTree<Integer> tree = new BTree<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int source = sc.nextInt();
            String where = sc.next();
            if (where.equals("ROOT")) {
                tree.makeRoot(source);
            } else {
                if (where.equals("LEFT")) {
                    tree.addChild(tree.search(tree.root, source), BNode.LEFT, sc.nextInt());
                } else {
                    tree.addChild(tree.search(tree.root, source), BNode.RIGHT, sc.nextInt());
                }
            }
        }
        int source = sc.nextInt();
        int dest = sc.nextInt();
        List<Integer> path = new ArrayList<>();
        findPath(tree.search(tree.root, source), dest, path);
        System.out.println(path.size() - 1);
    }
}
