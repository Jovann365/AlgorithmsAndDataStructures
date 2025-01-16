package LeetCode.HashTables;

import DataStructures.HashTables.CBHT;

public class NumberOfBalloons {
    public static int maxNumberOfBalloons(String text) {
        CBHT<Character, Integer> table = new CBHT<>(text.length());
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (table.search(text.charAt(i)) == null) {
                table.insert(text.charAt(i), 1);
            } else {
                table.insert(text.charAt(i), table.search(text.charAt(i)).element.value + 1);
            }
        }
        int numB = 0, numA = 0, numL = 0, numO = 0, numN = 0;

        if (table.search('b') != null)
             numB = table.search('b').element.value;
        if (table.search('a') != null)
            numA = table.search('a').element.value;
        if (table.search('l') != null)
            numL = table.search('l').element.value;
        numL = numL / 2;
        if (table.search('o') != null)
            numO = table.search('o').element.value;
        numO = numO / 2;
        if (table.search('n') != null)
            numN = table.search('n').element.value;

        if (numB == 0 || numA == 0 || numL == 0 || numO == 0 || numN == 0)
            return 0;
        else {
            while (numB != 0 && numA != 0 && numL != 0 && numO != 0 && numN != 0) {
                count++;
                numB--;
                numA--;
                numL--;
                numO--;
                numN--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String text = "loonbalxballpoon";
        System.out.println(maxNumberOfBalloons(text));
    }
}
