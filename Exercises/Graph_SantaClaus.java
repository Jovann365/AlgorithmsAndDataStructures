package Exercises;

/*
Во земjата Лапониjа живее Дедо Мраз. Во слободното време кога не е Нова Година, додека џуџињата си работат на играчките
 за следната година, Дедо Мраз има хоби. Тоj сака да одгледува рибички. Но тоj своите рибички ги одгледува во природни
 езера. Езерата се меѓусебно поврзани со рекички, и рекичките течат од едно езерце до друго. Рибите од едно езеро
 слободно можат преку рекичките да отидат во друго езеро. Секоjа пролет дедо мраз сака да прави порибување на езерцата
 со нови рибички. Ваша задача е да му кажете на Дедо Мраз доколку тоj пушти нови рибички во езерцето X, во колку други
 езерца ќе можат рибичките сами да стигнат, а со тоа да нема потреба тоj самиот да ги порибува тие езерца.
Влез: Во првата линиjа од влезот е даден броj N < 15 броjот на езерца. Во втората линиjа е даден броj U < 20 броjот на
 реки меѓу езерцата. Во следните U линии се дадени парови од 2 броjа R и Q, што значи постои рекичка коjа тече од R до
 Q, каде R и Q се броеви на езерцата. Во последната линиjа е даден броj L, во кое езерце Дедо Мраз ќе ги пушти рибичките.
Излез: Се испишува броjот, колку езерца освен почетното ќе бидат порибени.
 */

import DataStructures.Graphs.AdjacencyMatrixGraph;
import DataStructures.Graphs.Edge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph_SantaClaus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        AdjacencyMatrixGraph<Integer> graph = new AdjacencyMatrixGraph<>(n);
        for (int i = 0; i < n; i++) {
            graph.addVertex(i,i);
        }
        for (int i = 0; i < m; i++) {
            graph.addEdge(sc.nextInt(), sc.nextInt(), 1);
        }
        int p = sc.nextInt();
        List<Edge> prim = graph.prim(p);
        List<Integer> lakes = new ArrayList<>();
        for (int i = 0; i < prim.size(); i++) {
            if (!lakes.contains(prim.get(i).getTo()))
                lakes.add(prim.get(i).getTo());
            if (!lakes.contains(prim.get(i).getFrom()))
                lakes.add(prim.get(i).getFrom());
        }
        System.out.println(lakes.size() - 1);
    }
}
