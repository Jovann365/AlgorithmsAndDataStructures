package LaboratoryExercises.Lab5_Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class Exercise1_Stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stek = new Stack<>();
        boolean proverka = true;

        while(true) {
            String s = sc.next();
            if (s.equals("x"))
                break;
            if (s.startsWith("func")){
                stek.push(s);
            }
            if (s.startsWith("end") && stek.isEmpty()){
                proverka = false;
                break;
            }
            if (s.startsWith("end") && s.charAt(7) == stek.peek().charAt(4) && !stek.isEmpty()){
                stek.pop();
            }
            else if (s.startsWith("end") && s.charAt(7) != stek.peek().charAt(4) && !stek.isEmpty()){
                proverka = false;
                break;
            }


        }
        if (!stek.isEmpty()) proverka = false;
        if (proverka)
            System.out.println("Valid");
        else {
            System.out.println("Invalid");
        }
    }
}
