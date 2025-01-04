package LaboratoryExercises.Lab10_GraphsAlgorithms;

import DataStructures.Graphs.AdjacencyMatrixGraph;
import DataStructures.Graphs.Edge;
import DataStructures.Graphs.ShoertestPath.AdjacencyListGraph;

import java.util.*;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        AdjacencyMatrixGraph<String> graph = new AdjacencyMatrixGraph<>(n);
        for (int i = 0; i < n; i ++) {
            graph.addVertex(i, sc.next());
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String source = sc.next();
            String destination = sc.next();
            graph.addEdge(graph.getIndex(source),graph.getIndex(destination), sc.nextInt());
        }
        List<Edge> edges = graph.kruskal();
        int sum = 0;
        for (int i = 0; i < edges.size(); i++) {
            sum += edges.get(i).getWeight();
        }
        System.out.println(sum);
    }
}
