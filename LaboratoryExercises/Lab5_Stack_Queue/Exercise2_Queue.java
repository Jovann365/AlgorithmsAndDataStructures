package LaboratoryExercises.Lab5_Stack_Queue;

import DataStructures.Queue.ArrayQueue;

import java.util.Scanner;
import java.util.Stack;

class Student {
    String ime;
    int prilozhuvanje;
    int indeks;
    int sredno;
    Student (String ime, int prilozhuvanje, int indeks, int sredno) {
        this.ime = ime;
        this.prilozhuvanje = prilozhuvanje;
        this.indeks = indeks;
        this.sredno = sredno;
    }
}


public class Exercise2_Queue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayQueue<Student> prilozhuvanje = new ArrayQueue<>(n);
        ArrayQueue<Student> indeks = new ArrayQueue<>(n);
        ArrayQueue<Student> sredno = new ArrayQueue<>(n);
        Stack<Student> gotovi = new Stack<>();
        for (int i = 0; i <n; i++){
            String ime;
            ime = sc.nextLine();
            int pri = sc.nextInt();
            int ind = sc.nextInt();
            int sr = sc.nextInt();
            sc.nextLine();
            Student s = new Student(ime, pri, ind, sr);

            if (s.prilozhuvanje == 1) {
                prilozhuvanje.enqueue(s);
            }
            else if (s.prilozhuvanje == 0 && s.indeks == 1){
                indeks.enqueue(s);
            } else if (s.prilozhuvanje == 0 && s.indeks == 0 && s.sredno == 1) {
                sredno.enqueue(s);
            }
        }

        while (!prilozhuvanje.isEmpty() || !indeks.isEmpty() || !sredno.isEmpty()){
            if (!prilozhuvanje.isEmpty()){
                int s = 2;
                if (prilozhuvanje.size() <2) {
                    s = prilozhuvanje.size();
                }
                for (int i = 0; i < s; i ++) {
                    Student a = prilozhuvanje.dequeue();
                    if (a.indeks == 1) {
                        indeks.enqueue(a);
                    } else if (a.sredno == 1) {
                        sredno.enqueue(a);
                    }else {
                        gotovi.push(a);
                    }
                }
            }

            if (!indeks.isEmpty()){
                int s = 3;
                if (indeks.size() <3) {
                    s = indeks.size();
                }
                for (int i =0; i<s; i++){
                    Student a = indeks.dequeue();
                    if (a.sredno == 1) {
                        sredno.enqueue(a);
                    }else {
                        gotovi.push(a);
                    }
                }
            }

            if (!sredno.isEmpty()){
                Student a = sredno.dequeue();
                gotovi.push(a);
            }
        }
        Stack<Student> flipped = new Stack<>();
        while (!gotovi.isEmpty()){
            flipped.push(gotovi.pop());
        }
        while (!flipped.isEmpty()){
            System.out.println(flipped.pop().ime);
        }

    }
}
