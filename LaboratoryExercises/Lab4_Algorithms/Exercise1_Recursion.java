package LaboratoryExercises.Lab4_Algorithms;

import java.util.Scanner;

public class Exercise1_Recursion {
    public static int recursion(int left, int right, int []a, int m){
        if (a[(left + right) /2] == m){
            return (left + right)/2;
        }else if ((left == right && a[left] != m) || left < 0 || right > a.length){
            return -1;
        }
        else
        {
            if (m > a[(left+right)/2]){
                return recursion((left+right)/2+1,right,a,m);
            }else{
                return recursion(left, (left+right)/2-1,a, m);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int left = 0;
        int right = n-1;
        int result = recursion(left, right, arr, m);
        if (result == -1){
            System.out.println("Ne postoi");
        }
        else {
            System.out.println(result);
        }
    }
}
