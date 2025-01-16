package LeetCode.Graphs;

import DataStructures.Graphs.AdjacencyMatrixGraph;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/submissions/1510866155/?envType=problem-list-v2&envId=graph

You are given an integer n. There is an undirected graph with n nodes, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting nodes ai and bi.
Return the number of pairs of different nodes that are unreachable from each other.


Example 1:

Input: n = 3, edges = [[0,1],[0,2],[1,2]]
Output: 0
Explanation: There are no pairs of nodes that are unreachable from each other. Therefore, we return 0.
Example 2:

Input: n = 7, edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]
Output: 14
Explanation: There are 14 pairs of nodes that are unreachable from each other:
[[0,1],[0,3],[0,6],[1,2],[1,3],[1,4],[1,5],[2,3],[2,6],[3,4],[3,5],[3,6],[4,6],[5,6]].
Therefore, we return 14.

LONG TEST CASE
 */

public class UnreachableNodes {
    public static long countPairs(int n, int[][] edges) {
        AdjacencyMatrixGraph<Integer> graph = new AdjacencyMatrixGraph<>(n);
        for (int i = 0; i < n; i++) {
            graph.addVertex(i, i);
        }
        for (int i = 0; i < edges.length; i++) {
            graph.addEdge(edges[i][0], edges[i][1], 1);
        }

        long numUnconnected = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> visited = new ArrayList<>();
            isConnected(graph, i, visited);
            numUnconnected += n - visited.size();
        }

        return numUnconnected / 2;
    }

    public static void isConnected(AdjacencyMatrixGraph<Integer> graph, int node, List<Integer> visited) {
        visited.add(node);
        for (int neighbour : graph.getNeighbors(node)) {
            if (!visited.contains(neighbour)) {
                isConnected(graph, neighbour, visited);
            }
        }
    }

    public static void main(String[] args) {
        int n = 7;
        int [][] edges = {{0,2},{0,5},{2,4},{1,6},{5,4}};
        System.out.println(countPairs(n, edges));
    }
}
