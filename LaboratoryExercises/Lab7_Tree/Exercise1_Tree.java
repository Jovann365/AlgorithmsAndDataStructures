package LaboratoryExercises.Lab7_Tree;

import DataStructures.Tree.SLLTree;
import DataStructures.Tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise1_Tree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLLTree<Integer> tree = new SLLTree<>();
        int n = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        Map<Integer, Tree.Node<Integer>> nodes = new HashMap<>();
        for (int i = 0; i < n + q; i++) {
            String s = sc.nextLine();
            String[] functions = s.split(" ");
            if (functions[0].equals("root")) {
                Integer value = Integer.parseInt(functions[1]);
                tree.makeRoot(value);
                Tree.Node<Integer> node = tree.root();
                nodes.put(value, node);
            } else if (functions[0].equals("add")) {
                Tree.Node<Integer> node = nodes.get(Integer.parseInt(functions[1]));
                Tree.Node<Integer> newNode = tree.addChild(node, Integer.parseInt(functions[2]));
                nodes.put(Integer.parseInt(functions[2]), newNode);
            } else if (functions[0].equals("ask")) {
                System.out.println(tree.countleaves(nodes.get(Integer.parseInt(functions[1]))));
            }
        }
    }
}
