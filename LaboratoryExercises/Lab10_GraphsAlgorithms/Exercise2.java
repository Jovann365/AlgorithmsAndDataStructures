package LaboratoryExercises.Lab10_GraphsAlgorithms;

import DataStructures.Graphs.ShoertestPath.AdjacencyListGraph;

import java.util.Map;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();
        String [][] transformations = new String[n][2];
        for (int i = 0; i < n; i++) {
            transformations[i][0] = sc.next();
            transformations[i][1] = sc.next();
            graph.addVertex(transformations[i][0]);
            graph.addVertex(transformations[i][1]);
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            graph.addEdge(sc.next(), sc.next(), sc.nextInt());
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            String source = transformations[i][0];
            String destination = transformations[i][1];
            Map<String, Integer> paths = graph.shortestPath(source);
            sum += paths.get(destination);
        }
        System.out.println(sum);
    }
}
