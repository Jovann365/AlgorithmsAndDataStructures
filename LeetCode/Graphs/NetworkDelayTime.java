package LeetCode.Graphs;

import DataStructures.Graphs.ShoertestPath.AdjacencyListGraph;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/network-delay-time/description/?envType=problem-list-v2&envId=graph
You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

Example 1:

Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1
Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
*/

public class NetworkDelayTime {
    public static int networkDelayTime(int[][] times, int n, int k) {
            AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();
            for (int i = 0; i < times.length; i++) {
                graph.addEdge(times[i][0], times[i][1], times[i][2]);
            }
            for (int i = 1; i < n; i++) {
                graph.addVertex(i);
            }
            Map<Integer, Integer> paths = graph.shortestPath(k);
            int maximum = 0;
            for (int i = 1; i <= n; i++) {
                if (paths.get(i) != null) {
                    if (paths.get(i) > maximum && i != k)
                        maximum = paths.get(i);
                }
                else {
                    return -1;
                }
            }
            if (maximum == Integer.MAX_VALUE)
                return -1;
            else
                return maximum;
    }

    public static void main(String[] args) {
        int [][] testCase1 = {{2,1,1},{2,3,1},{3,4,1}};
//        System.out.println(networkDelayTime(testCase1, 4, 2));
        int [][] testCase2 = {{1,2,1}};
//        System.out.println(networkDelayTime(testCase2, 2, 1));
        System.out.println(networkDelayTime(testCase2, 2, 2));
    }
}
