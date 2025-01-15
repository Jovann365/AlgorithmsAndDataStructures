package Exercises;

import DataStructures.HashTables.MapEntry;
import DataStructures.HashTables.CBHT;

import java.util.Scanner;

public class HashTable_Dialects {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CBHT<String, String> table = new CBHT<>(23);
        for (int i = 0; i <n; i++) {
            String word = sc.next();
            String translation = sc.next();
            if (table.search(word) == null) {
                table.insert(word, translation);
            }
        }
        System.out.println(table.toString());
        String sentence = sc.nextLine();
        String [] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.charAt(word.length() -1) == '.' ||  )
        }

    }
}
