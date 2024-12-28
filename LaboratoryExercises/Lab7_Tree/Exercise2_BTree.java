package LaboratoryExercises.Lab7_Tree;

import DataStructures.BTree.BNode;
import DataStructures.BTree.BTree;

import java.util.Scanner;

public class Exercise2_BTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        BTree<String> tree = new BTree<>();
        for (int i = 0; i < n + q; i++){
            String entry = sc.nextLine();
            String [] split = entry.split(" ");
            if (split[0].equals("root")) {
                tree.makeRoot(split[1]);
            }
            else if (split[0].equals("add")) {
                BNode<String> insert = tree.search(tree.root, split[1]);
                if (split[3].equals("LEFT")) {
                    tree.addChild(insert, 1, split[2]);
                } else {
                    tree.addChild(insert, 2, split[2]);
                }
            }
            else if (split[0].equals("ask")) {
                BNode<String> depth = tree.search(tree.root, split[1]);
                System.out.println(tree.depthR(depth) + 1);
            }
        }
    }
}
