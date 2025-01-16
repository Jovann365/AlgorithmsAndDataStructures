package LeetCode.HashTables;

/*
https://leetcode.com/problems/fruit-into-baskets/?envType=problem-list-v2&envId=hash-table

You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
Example 2:

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
Example 3:

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
 */

import DataStructures.HashTables.CBHT;

import java.util.ArrayList;
import java.util.List;

public class FruitBasket {
    public static int totalFruit(int[] fruits) {
        CBHT<Integer, Integer> table = new CBHT<>(11);

        for (int i = 0; i < fruits.length; i++) {
            if (table.search(fruits[i]) == null) {
                table.insert(fruits[i], 1);
            } else {
                table.insert(fruits[i], table.search(fruits[i]).element.value + 1);
            }
        }

        int best = 0;
        int secondBest = 0;

        for (int i = 0; i < fruits.length; i++) {
            if (table.search(fruits[i]).element.value > best) {
                best = table.search(fruits[i]).element.value;
            }
        }

        for (int i = 0; i < fruits.length; i++) {
            if (table.search(fruits[i]).element.value > secondBest && table.search(fruits[i]).element.value < best)
                secondBest = table.search(fruits[i]).element.value;
        }

        return best + secondBest;
    }

    public static void main(String[] args) {
        int [] fruits = {1,2,1};
        System.out.println(totalFruit(fruits));
    }
}
