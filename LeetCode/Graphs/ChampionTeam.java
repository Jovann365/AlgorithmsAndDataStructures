package LeetCode.Graphs;

import DataStructures.Graphs.AdjacencyListGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChampionTeam {
    public static int numConnected(AdjacencyListGraph<Integer> graph, int vertex) {
        Set<Integer> visited = new HashSet<>();
        graph.DFSUtilA(vertex, visited);
        return visited.size();
    }

    public static int findChampion(int n, int[][] edges) {
        List<Integer> teams = new ArrayList<>();
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();
        for (int i = 0; i < edges.length; i++) {
            if (!teams.contains(edges[i][0])) teams.add(edges[i][0]);
            if (!teams.contains(edges[i][1])) teams.add(edges[i][1]);
            graph.addEdge(edges[i][0], edges[i][1]);
        }
        List<Integer> sorted = graph.topologicalSort();
        if (numConnected(graph, sorted.getFirst()) == teams.size()) {
            return sorted.getFirst();
        }
        else
            return -1;
    }

    public static void main(String[] args) {
        int [][] edges = {{0,2},{1,3},{1,2}};
        System.out.println(findChampion(0, edges));
    }
}
