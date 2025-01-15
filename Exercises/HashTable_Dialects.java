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
        sc.nextLine();
        String sentence = sc.nextLine();
        String [] words = sentence.split(" ");
        String translated = "";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String oldWord = word;
            Character s = ' ';
            boolean uppercase = false;
            if (word.charAt(word.length()-1) == '.' || word.charAt(word.length()-1) == '!' || word.charAt(word.length()-1) == '?' || word.charAt(word.length()-1) == ',') {
                s = word.charAt(word.length()-1);
                word = word.substring(0, word.length()-1);
            }
            if (Character.isUpperCase(word.charAt(0))) {
                uppercase = true;
            }
            word = word.toLowerCase();
            String newWord = oldWord;
            if (table.search(word) != null) {
             newWord=table.search(word).element.value;
             if (uppercase) {
                 newWord = newWord.replace(newWord.charAt(0), Character.toUpperCase(newWord.charAt(0)));
             }
             if (s != ' ') {
                 newWord = newWord.concat(s.toString());
             }
            }
            translated = translated.concat(newWord + " ");
        }
        System.out.println(translated);
    }
}
