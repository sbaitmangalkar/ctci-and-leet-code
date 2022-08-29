package com.sbaitman.ctci.stringsandarrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 1: Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum {
    private static int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> table = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int expected = target - nums[i];
            if(table.containsKey(expected)) {
                return new int[]{table.get(expected), i};
            } else {
                table.put(nums[i], i);
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        int[] res1 = twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(Arrays.toString(res1));
    }
}
