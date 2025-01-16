package Exercises;

/*
Ministerot za transport i vrski ima na raspolaganje odreden budzet koj treba da go iskroisti za da povrzi sto e mozno
povekje gradovi preku zeleznicki soobrakjaj so glavnata zeleznicka stanica.

Input:
5
Prilep
Bitola
Stip
Veles
Kicevo
5
Prilep Bitola 10
Veles Stip 12
Bitola Kicevo 15
Veles Prilep 13
Kicevo Prilep 20
Prilep 48

Output:
3 35
*/

import DataStructures.Graphs.AdjacencyMatrixGraph;
import DataStructures.Graphs.Edge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrainStations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> cities = new ArrayList<>();
        AdjacencyMatrixGraph<String> graph = new AdjacencyMatrixGraph<>(n);
        for (int i = 0; i <n; i++) {
            String city = sc.next();
            graph.addVertex(i, city);
            cities.add(city);
        }
        int m = sc.nextInt();
        for (int i = 0; i <m; i++) {
            graph.addEdge(graph.getIndex(sc.next()), graph.getIndex(sc.next()), sc.nextInt());
        }

        String mainStation = sc.next();
        int budget = sc.nextInt();
        int numCities = 0;
        int spent = 0;

        List<Edge> paths = graph.prim(graph.getIndex(mainStation));
        for (int i = 0; i < paths.size(); i++) {
            if (spent + paths.get(i).getWeight() <= budget) {
                spent += paths.get(i).getWeight();
                numCities++;
            }
        }

        System.out.println(numCities + " " + spent);
    }
}
