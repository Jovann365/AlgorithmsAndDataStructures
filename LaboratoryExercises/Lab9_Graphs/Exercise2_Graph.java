package LaboratoryExercises.Lab9_Graphs;

import DataStructures.Graphs.AdjacencyListGraph;

import java.util.Scanner;

public class Exercise2_Graph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            graph.addEdge(sc.nextInt(), sc.nextInt());
        }
        int r = sc.nextInt();
        graph.removeVertex(r);
        System.out.println(graph.countSections());
    }
}
