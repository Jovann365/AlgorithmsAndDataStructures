package LeetCode.Graphs;

import DataStructures.Graphs.AdjacencyMatrixGraph;
import DataStructures.Graphs.Edge;

import java.util.ArrayList;
import java.util.List;

/*
DOESN'T PASS IN LeetCode
https://leetcode.com/problems/redundant-connection/description/?envType=problem-list-v2&envId=graph
In this problem, a tree is an undirected graph that is connected and has no cycles.
You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.
Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.

Example 1:

Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]
Example 2:


Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
Output: [1,4]

 */

public class RedundantConnection {
    public static int[] findRedundantConnection(int[][] edges) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            if (!list.contains(edges[i][0]))
                list.add(edges[i][0]);
            if (!list.contains(edges[i][1]))
                list.add(edges[i][1]);
        }
        AdjacencyMatrixGraph<Integer> graph = new AdjacencyMatrixGraph<>(list.size());
        for (int i = 0; i < list.size(); i++) {
            graph.addVertex(i, list.get(i));
        }
        for (int i = 0; i < edges.length; i++) {
            int source = graph.getIndex(edges[i][0]);
            int destination = graph.getIndex(edges[i][1]);
            graph.addEdge(source, destination, 1);
        }
        int [] result = new int[2];
        List<Edge> edgesResult = graph.prim(1);
        System.out.println(edgesResult.toString());
        for (int i = edges.length - 1; i >= 0; i--) {
            Edge edge = new Edge(graph.getIndex(edges[i][0]), graph.getIndex(edges[i][1]), 1);
            boolean check = false;
            for (int j = 0; j < edgesResult.size(); j++) {
                if (edgesResult.get(j).getTo() == edge.getTo() && edgesResult.get(j).getFrom() == edge.getFrom()){
                    check = true;
                }
            }
            if (!check){
                result[0] = edges[i][0];
                result[1] = edges[i][1];
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        int [] result = findRedundantConnection(edges);
        System.out.println(result[0] + " " + result[1]);
}
}
