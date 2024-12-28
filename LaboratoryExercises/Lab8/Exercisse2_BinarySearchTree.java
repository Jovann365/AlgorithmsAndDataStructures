package LaboratoryExercises.Lab8;

import DataStructures.BTree.BNode;
import DataStructures.SearchTrees.BinarySearchTree;

import java.util.Scanner;

public class Exercisse2_BinarySearchTree {
    public static int lessThan (BNode<Integer> root, Integer value) {
        if (root == null) return 0;
        if (root.info < value) return 1 + lessThan(root.left, value) + lessThan(root.right, value);
        return lessThan(root.left, value);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int i = 0; i < n + q; i++){
            String type = sc.next();
            Integer value = sc.nextInt();
            if (type.equals("insert")) {
                tree.insert(value);
            } else {
                System.out.println(lessThan(tree.getRoot(), value));
            }
        }
    }
}
