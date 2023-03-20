package com.sbaitman.ctci.stringsandarrays;

/**
 * LeetCode 35: Search Insert Position
 *
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 *
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 */
public class Search {
    public static int searchInsert(int[] nums, int target) {
        // iterative
        int lo = 0;
        int hi = nums.length - 1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(target < nums[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;

        // recursive
        //return search(nums, target, 0, nums.length - 1);
    }

    private static int search(int[] nums, int target, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        while(lo <= hi) {
            if(nums[mid] == target) {
                return mid;
            } else if(target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
    }
}
