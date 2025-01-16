package LeetCode.Graphs;

import DataStructures.Graphs.AdjacencyListGraph;
import DataStructures.Graphs.AdjacencyMatrixGraph;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/satisfiability-of-equality-equations/description/?envType=problem-list-v2&envId=graph

You are given an array of strings equations that represent relationships between variables where each string equations[i] is of length 4 and takes one of two different forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (not necessarily different) that represent one-letter variable names.

Return true if it is possible to assign integers to variable names so as to satisfy all the given equations, or false otherwise.


Example 1:

Input: equations = ["a==b","b!=a"]
Output: false
Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.
There is no way to assign the variables to satisfy both equations.
Example 2:

Input: equations = ["b==a","a==b"]
Output: true
Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
 */

public class EquationSolver {
    public static boolean equationsPossible(String[] equations) {
        List<Character> nodes = new ArrayList<>();
        for (int i = 0; i < equations.length; i++) {
            if (!nodes.contains(equations[i].charAt(0))) nodes.add(equations[i].charAt(0));
            if (!nodes.contains(equations[i].charAt(3))) nodes.add(equations[i].charAt(3));
        }
        AdjacencyMatrixGraph<Character> graph = new AdjacencyMatrixGraph<>(nodes.size());
        for (int i = 0; i < nodes.size(); i++) {
            graph.addVertex(i, nodes.get(i));
        }

        for (int i = 0; i <equations.length; i++) {
            if (equations[i].charAt(1) == '=') {
                graph.addEdge(graph.getIndex(equations[i].charAt(0)), graph.getIndex(equations[i].charAt(3)), 1);
            }
        }

        for (int i = 0; i < nodes.size(); i++) {
            Character currNode = nodes.get(i);
            for (int j = 0; j < nodes.size(); j++) {
                if (i != j) {
                    if (graph.isEdge(graph.getIndex(currNode), graph.getIndex(nodes.get(j))) && !graph.isEdge(graph.getIndex(nodes.get(j)), graph.getIndex(currNode)))
                        return false;
                    if (!graph.isEdge(graph.getIndex(currNode), graph.getIndex(nodes.get(j))) && graph.isEdge(graph.getIndex(nodes.get(j)), graph.getIndex(currNode)))
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String [] equations = {"a==b","b!=a"};
        System.out.println(equationsPossible(equations));
    }
}
