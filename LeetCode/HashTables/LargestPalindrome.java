package LeetCode.HashTables;

import DataStructures.HashTables.CBHT;

import java.util.ArrayList;
import java.util.List;

/*

 */

public class LargestPalindrome {
    public static int longestPalindrome(String s) {
        CBHT<Character, Integer> table = new CBHT<>(11);
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            char c =  s.charAt(i);
            if (!list.contains(c)) {
                list.add(c);
            }
            if (table.search(c) == null) {
                table.insert(c, 1);
            } else {
                table.insert(c, table.search(c).element.value + 1);
            }
        }

        int result = 0;
        boolean odd = false;

        for (int i = 0; i < list.size(); i++) {
            if (table.search(list.get(i)).element.value % 2 == 0) {
                result += table.search(list.get(i)).element.value;
            } else {
                result += table.search(list.get(i)).element.value - 1;
                odd = true;
            }
        }

        if (odd) {
            result++;
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "bananas";
        System.out.println(longestPalindrome(s));
    }
}
