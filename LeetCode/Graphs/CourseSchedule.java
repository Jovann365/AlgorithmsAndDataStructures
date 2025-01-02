package LeetCode.Graphs;

import DataStructures.Graphs.AdjacencyListGraph;

import java.util.*;
import java.util.Map.Entry;


public class CourseSchedule{
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();
        for (int i = 0; i < prerequisites.length; i++) {
            graph.addEdge(prerequisites[i][1], prerequisites[i][0]);
        }
        return graph.checkCourses();
    }

    public static void main(String[] args) {
        int [][] array = {{1,1}};
        System.out.println(canFinish(2, array));
    }
}