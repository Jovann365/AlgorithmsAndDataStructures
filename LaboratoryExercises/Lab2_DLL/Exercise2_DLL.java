package LaboratoryExercises.Lab2_DLL;

import DataStructures.List.DLL;
import DataStructures.List.DLLNode;

import java.util.Scanner;

public class Exercise2_DLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<>();
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            list.insertLast(a);
        }
        DLLNode<Integer> tmp = list.getFirst();
        while (tmp != null) {
            System.out.print(tmp.element);
            if (tmp.succ != null){
                System.out.print("<->");
            }
            tmp = tmp.succ;
        }
        int m = sc.nextInt();
        int k = sc.nextInt();
        boolean check = false;
        tmp = list.getFirst();
        while(tmp!=null) {
            if (tmp == list.find(m)){
                check = true;
                break;
            }
            tmp = tmp.succ;
        }
        if(!check) {
            System.out.println();
            System.out.print("Elementot ne postoi vo listata");
        }else {
            for (int i = 0; i < k; i++) {
                if (tmp.pred !=null) {
                    list.swap(tmp, tmp.pred);
                    tmp = tmp.pred;
                }
                else {
                    list.insertLast(tmp.element);
                    list.deleteFirst();
                    tmp = list.find(m);
                }
            }
        }
        tmp = list.getFirst();
        System.out.println();
        while (tmp != null) {
            System.out.print(tmp.element);
            if (tmp.succ != null) {
                System.out.print("<->");
            }
            tmp = tmp.succ;
        }
    }

}
