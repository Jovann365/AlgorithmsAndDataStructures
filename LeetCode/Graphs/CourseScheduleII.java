package LeetCode.Graphs;

import DataStructures.Graphs.AdjacencyListGraph;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/course-schedule-ii/description/?envType=problem-list-v2&envId=graph
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
 */

public class CourseScheduleII {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] result = new int[numCourses];
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();
        if (prerequisites.length != 0) {
            for (int i = 0; i < prerequisites.length; i++) {
                graph.addEdge(prerequisites[i][1], prerequisites[i][0]);
            }
        }
        if (!graph.checkCourses()) return new int[0];
        else {
            int counter = 0;
            List<Integer> sorted = graph.topologicalSort();
            for (int i = 0; i <sorted.size(); i++) {
                result[counter] = sorted.get(i);
                counter++;
            }
            for (int i =0; i<numCourses; i++) {
                if (!sorted.contains(i)) {
                    result[counter] = i;
                    counter++;
                }
            }
        }
        if (prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++) {
                result[i] = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [][] array = {};
        int [] test = findOrder(2,array);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }
}
