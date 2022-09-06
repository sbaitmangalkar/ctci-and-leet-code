package com.sbaitman.ctci.stringsandarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode 15: 3Sum
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
 * and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 *
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 * Constraints:
 *
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class ThreeSum {
    public static List<List<Integer>> threeSumBruteForce(int[] nums) {
        if(nums == null || nums.length <= 0) {
            return new ArrayList();
        }
        List<List<Integer>> result = new ArrayList();

        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++) {
                for(int k = 0; k < nums.length; k++) {
                    if(i != j && i != k && j != k) {
                        if((nums[i] + nums[j] + nums[k]) == 0) {
                            List<Integer> res = new ArrayList();
                            res.add(nums[i]);
                            res.add(nums[j]);
                            res.add(nums[k]);
                            if(!result.contains(res)) {
                                result.add(res);
                            }
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        for(int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1;
            int hi =  nums.length - 1;
            while(lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if(sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    lo++;
                    hi--;
                } else if(sum > 0) {
                    hi--;
                } else if(sum < 0) {
                    lo++;
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] input = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSum(input);
        System.out.println(result);
    }
}
