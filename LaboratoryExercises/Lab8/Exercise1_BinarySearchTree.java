package LaboratoryExercises.Lab8;

import DataStructures.SearchTrees.BinarySearchTree;

import java.util.Scanner;

public class Exercise1_BinarySearchTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        sc.nextLine();
        for (int i = 0; i < n + q; i++) {
            String line = sc.nextLine();
            String [] split = line.split(" ");
            if (split[0].equals("insert")) {
                tree.insert(Integer.parseInt(split[1]));
            } else if (split[0].equals("ask")) {
                System.out.println(tree.depth(tree.getRoot(), Integer.parseInt(split[1])));
            }
        }
    }
}
