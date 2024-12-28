package LaboratoryExercises.Lab3_Algorithms;

import DataStructures.Array.Array;

import java.util.Scanner;

public class Exercise1_Greedy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Array<Integer> a = new Array<>(n);
        for (int i=0; i<n; i++) {
            a.insertLast(sc.nextInt());
        }
        a.sort();
        long number = a.toNumber();
        if (number != 0)
            System.out.println(number);
        else{
            for (int i=0; i<n; i++){
                System.out.print("0");
            }
        }
    }
}
