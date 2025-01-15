package LeetCode.Graphs;

/*
https://leetcode.com/problems/sum-of-distances-in-tree/description/?envType=problem-list-v2&envId=tree

There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.
You are given the integer n and the array edges where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.
Return an array answer of length n where answer[i] is the sum of the distances between the ith node in the tree and all other nodes.

Example 1:

Input: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
Output: [8,12,6,10,10,10]
Explanation: The tree is shown above.
We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
equals 1 + 1 + 2 + 2 + 2 = 8.
Hence, answer[0] = 8, and so on.
Example 2:

Input: n = 1, edges = []
Output: [0]
Example 3:

Input: n = 2, edges = [[1,0]]
Output: [1,1]


!!!USE WITH UNDIRECTED GRAPH!!!
 */

import DataStructures.Graphs.ShoertestPath.AdjacencyListGraph;

import java.util.Map;

public class SumOfDistances {
    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[] result = new int[n];
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();
        if (n == 1) {
            result[0] = 0;
            return result;
        }
        for (int i = 0; i < edges.length; i++) {
            graph.addEdge(edges[i][0], edges[i][1], 1);
        }
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> paths = graph.shortestPath(i);
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    sum += paths.get(j);
                }
            }
            result[i] = sum;
        }
        return result;
    }

    public static void main(String[] args) {
        int [][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
        int [] result = sumOfDistancesInTree(6, edges);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
