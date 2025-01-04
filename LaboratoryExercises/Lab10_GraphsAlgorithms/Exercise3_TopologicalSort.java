package LaboratoryExercises.Lab10_GraphsAlgorithms;

import DataStructures.Graphs.AdjacencyListGraph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Exercise3_TopologicalSort {
    public static int findMax(AdjacencyListGraph<String> graph, String vertex, Map<String, Integer> weights){
        int max = 0;
        for (String neighbour : graph.getNeighbors(vertex)) {
            if (weights.get(neighbour) > max)
                max = weights.get(neighbour);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> weights = new HashMap<>();
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String vertex = sc.next();
            int time = sc.nextInt();
            graph.addVertex(vertex);
            weights.put(vertex, time);
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String source = sc.next();
            String destination = sc.next();
            graph.addEdge(source, destination);
        }
        int maxTime = 0;
        List<String> sorted = graph.topologicalSort();
        // int [] maxTimes = new int[sorted.size()];
        for (int i = sorted.size()-1; i >= 0; i--) {
//            maxTimes[i] = weights.get(sorted.get(i)) + findMax(graph, sorted.get(i), weights);
//            weights.put(sorted.get(i), maxTimes[i]);
            weights.put(sorted.get(i), weights.get(sorted.get(i)) + findMax(graph, sorted.get(i), weights));
            if (weights.get(sorted.get(i)) > maxTime)
                maxTime = weights.get(sorted.get(i));
        }
//        int maxTime = maxTimes[0];
//        for (int i = 0; i < sorted.size(); i++) {
//            if (maxTimes[i] > maxTime) maxTime = maxTimes[i];
//        }
        System.out.println(maxTime);
    }
}
