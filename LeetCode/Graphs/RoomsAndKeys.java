package LeetCode.Graphs;

import DataStructures.Graphs.AdjacencyListGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/problems/keys-and-rooms/submissions/1510634186/?envType=problem-list-v2&envId=graph
 */

public class RoomsAndKeys {
    public static void checkRooms(AdjacencyListGraph<Integer> graph, int node, List<Integer> checked) {
        checked.add(node);
        for (int neighbour : graph.getNeighbors(node)) {
            if (!checked.contains(neighbour))
                checkRooms(graph, neighbour, checked);
        }
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();
        for (int i = 0; i < rooms.size(); i++) {
            List<Integer> keys = rooms.get(i);
            for (int j = 0; j < keys.size(); j++) {
                graph.addEdge(i, keys.get(j));
            }
        }

        List<Integer> checked = new ArrayList<>();
        checkRooms(graph, 0, checked);
        for (int i = 0; i < rooms.size(); i++) {
            if (!checked.contains(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room0 = new ArrayList<>();
        room0.add(1);
        List<Integer> room1 = new ArrayList<>();
        List<Integer> room2 = new ArrayList<>();
        room2.add(3);
        List<Integer> room3 = new ArrayList<>();
        rooms.add(room0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        System.out.println(canVisitAllRooms(rooms));
    }
}
