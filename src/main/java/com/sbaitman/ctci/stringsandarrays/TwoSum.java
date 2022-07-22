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
        int[] result = new int[2];
        int index0 = 0;
        int index1 = 0;
        Map<Integer, Integer> table = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            index1 = i;
            int temp = target - nums[i];
            if (table.containsKey(temp)) {
                index0 = table.get(temp);
                break;
            } else {
                table.put(nums[i], i);
            }
        }

        result[0] = index0;
        result[1] = index1;
        return result;
    }

    public static void main(String[] args) {
        int[] res1 = twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(Arrays.toString(res1));
    }
}
