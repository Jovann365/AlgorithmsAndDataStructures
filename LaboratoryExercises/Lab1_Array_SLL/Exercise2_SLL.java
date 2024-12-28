package LaboratoryExercises.Lab1_Array_SLL;

import DataStructures.List.SLLNode;
import DataStructures.List.SLL;

import java.util.Scanner;

public class Exercise2_SLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<String> lista = new SLL<>();
        for (int i = 0; i < n; i++) {
            lista.insertLast(sc.next());
        }

        int l = sc.nextInt();
        SLLNode<String> temp = lista.getFirst();

        while(temp.succ!=null){
            System.out.print(temp.element);
            System.out.print("->");
            temp = temp.succ;
        }
        System.out.print(temp.element);

        System.out.println();
        temp = lista.getFirst();
        while(temp!=null){
            if (temp.element.length() > l){
                lista.insertBefore("Outlier", temp);
            }
            temp = temp.succ;
        }
        temp = lista.getFirst();
        while(temp!=null){
            System.out.print(temp.element);
            if(temp.succ != null) {
                System.out.print("->");
            }
            temp = temp.succ;
        }
    }
}
