package LaboratoryExercises.Lab2_DLL;

import DataStructures.List.DLL;

import java.util.Scanner;

public class Exercise1_DLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            list.insertLast(x);
        }

        int brojac = 0;
        for (int i = 2; i < n; i++) {
            int sumL = 0;
            int sumR = 0;
            int countL = 0;
            int countR =0;
            for (int j=i; j>1; j--){
                sumL += list.getByIndex(j).pred.element;
                countL++;
            }
            for (int j=i; j<n; j++){
                sumR += list.getByIndex(j).succ.element;
                countR++;
            }
            if (((float)sumL / (float)countL) > ((float)sumR / (float)countR)) {
                brojac++;
            }
        }
        System.out.println(brojac);
    }
}
