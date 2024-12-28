package LaboratoryExercises.Lab9_Graphs;

import java.util.Scanner;

import DataStructures.Graphs.AdjacencyListGraph;

public class Exercise1_Graph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();
        for (int i = 0; i <n; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            graph.addEdge(node1, node2);
        }
        int start = sc.nextInt();
        int sum = sc.nextInt();
        System.out.println(graph.count(start, sum));
    }
}
