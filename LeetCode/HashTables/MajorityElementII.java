package LeetCode.HashTables;

/*
https://leetcode.com/problems/majority-element-ii/description/?envType=problem-list-v2&envId=hash-table
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
Example 1
Input: nums = [3,2,3]
Output: [3]
Example 2:
Input: nums = [1]
Output: [1]
Example 3:
Input: nums = [1,2]
Output: [1,2]
 */

import DataStructures.HashTables.CBHT;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public static List<Integer> majorityElement(int[] nums) {
        CBHT<Integer, Integer> table = new CBHT<>(nums.length);
        List<Integer> elements = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (table.search(nums[i]) == null) {
                table.insert(nums[i], 1);
            } else {
                int value = table.search(nums[i]).element.value;
                table.insert(nums[i], value + 1);
            }

        }
        for (int i = 0; i < nums.length; i++) {
            if (table.search(nums[i]).element.value > (nums.length/3) && !elements.contains(nums[i]))
                elements.add(nums[i]);
        }
        return elements;
    }

    public static void main(String[] args) {
        int [] array = {3,2,3};
        System.out.println(majorityElement(array).toString());
    }
}
