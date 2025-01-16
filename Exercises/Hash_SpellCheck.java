package Exercises;

/*
Потребно е да се направи проверка на текст даден на англиски, дали е во ред напишан (односно дали правилно се напишани зборовите). За таа цел прво се даваат речник на зборови (односно листа на зборови кои ги содржи англискиот јазик), а потоа се дава текст. Како резултат треба да се испечатат сите зборови кои се направилно напишани или ги нема во речникот.
Влез: Прво се дава број N на поими кои ќе ги содржи речникот, а во наредните N реда се дадени зборовите кои ги содржи англискиот јазик. Потоа се дава еден текст, кој треба да се провери дали е правилно напишан.
Излез: Се печати листа на зборови кои се неправилно напишани (секој во посебен ред). Доколку сите зборови се добро напишани се печати: Bravo.
Забелешка: Треба да се игнорираат интерпункциски знаци како точка (.), запирка (,), извичник (!) и прашалник (?). Исто така да се внимава на голема и мала буква, односно иако зборовите во речникот се со мали букви, во реченица може да појават со голема почетна буква и притоа се сметаат за точни. Работете со хеш табела со отворени кофички. Сами треба да го одредите бројот на кофички и хеш функцијата.

/

You need to do a spell check of a text written in English, if it's correctly written. For that, first you are given a dictionary of words (i.e. a list of all the words that are used), and then you are given a text. As a result you should print all the words that are spelled incorrectly or are not present in the dictionary.
Input: First you are given an integer N - number of terms in the dictionary, and then in the next N rows you have the words themselves. Then you are given a text, which should be spell-checked.
Output: You should print a list of words that are written incorrectly (each in a separate row). If all words are written correctly you should print: Bravo.
Note: You should ignore punctual marks such as dot(.), comma(,), exclamation mark(!) and question mark(?). You should also take in consideration uppercase / lowercase letters, i.e. if the words in the dictionary are with only lowercase letters, in a sentence they can appear with a capitalized first letter, and that should be considered as correct. Work with an Open bucket hash table. You should determine the number of buckets and the hash function yourselves.

For example:

Input
4
where
is
my
cat
Where is my cat?

Result
Bravo
 */

import DataStructures.HashTables.CBHT;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hash_SpellCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CBHT<String, Integer> table = new CBHT<>(11);
        List<String> wrong = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String word = sc.next();
            table.insert(word, 1);
        }
        sc.nextLine();
        String sentence = sc.nextLine();
        sentence = sentence.replaceAll("\\.", "");
        sentence = sentence.replaceAll("\\?", "");
        sentence = sentence.replaceAll("!", "");
        sentence = sentence.replaceAll(",", "");
        sentence = sentence.toLowerCase();

        String [] words = sentence.split(" ");
        if (!words[0].isEmpty()) {
            for (int i = 0; i < words.length; i++) {
                if (table.search(words[i]) == null) {
                    wrong.add(words[i]);
                }
            }
        }

        if (wrong.isEmpty()) {
            System.out.println("Bravo");
        } else {
            for (String s : wrong) {
                System.out.println(s);
            }
        }
    }
}
