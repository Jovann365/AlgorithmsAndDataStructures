package LaboratoryExercises.Lab4_Algorithms;

import java.util.Scanner;

public class Exercise2_DynamicProgramming {
    public static int check(int X){
        int [] array = new int[X+1];
        for (int i=0; i<X+1; i++){
            array[i] = Integer.MAX_VALUE;
        }
        array[0] = 0;
        for (int i=1; i<X+1; i++){
            for (int j=1; j * j <= i; j++){
                array[i] = Math.min(array[i], array[i-j*j] + 1);
            }
        }
        return array[X];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int X = input.nextInt();
        int result;
        result = check(X);
        System.out.println(result);
    }
}
