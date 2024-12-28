package LaboratoryExercises.Lab1;

import DataStructures.Array.Array;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Array<Integer> array = new Array<>(n);
        for (int i=0; i<n; i++){
            array.insert(i, sc.nextInt());
        }
        System.out.print("{");
        for (int i=0; i<n; i++){
            System.out.print(array.get(i));
            if (i<n-1)
                System.out.print(",");
        }
        System.out.println("}");
        int zbir = 0;
        for (int i=0; i<n; i++){
            zbir += array.get(i);
        }
        float aritmeticka = (float) zbir / (float) n;
        for (int i=0; i<n; i++){
            if (array.get(i) < aritmeticka){
                array.delete(i);
                i--;
                n--;
            }
        }
        System.out.print("{");
        for (int i=0; i<n; i++){
            System.out.print(array.get(i));
            if (i<n-1)
                System.out.print(",");
        }
        System.out.println("}");
        sc.close();
    }
}
