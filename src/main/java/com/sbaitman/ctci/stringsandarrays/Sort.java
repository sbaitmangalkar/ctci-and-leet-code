package com.sbaitman.ctci.stringsandarrays;

/**
 * LeetCode: 912
 *  Sort an Array
 *
 *  Given an array of integers nums, sort the array in ascending order and return it.
 *
 * You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.
 *
 *
 * Example 1:
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 * Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
 *
 * Example 2:
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 * Explanation: Note that the values of nums are not necessairly unique.
 */
public class Sort {
    public int[] sortArray(int[] nums) {
        return sort(nums);
    }

    private int[] sort(int[] nums) {
        //mergeSort(nums, new int[nums.length], 0, nums.length - 1);
        //quickSort(nums, 0, nums.length - 1);
        threeWayQuickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void threeWayQuickSort(int[] nums, int lo, int hi) {
        if(hi <= lo) {
            return;
        }
        int lt = lo;
        int gt = hi;
        int v = nums[lo];
        int i = lo;

        while(i <= gt) {
            if(nums[i] < v) {
                swap(nums, lt++, i++);
            } else if(nums[i] > v) {
                swap(nums, i, gt--);
            } else {
                i++;
            }
        }
        threeWayQuickSort(nums, lo, lt - 1);
        threeWayQuickSort(nums, gt + 1, hi);
    }

    private void quickSort(int[] nums, int lo, int hi) {
        if(hi <= lo) {
            return;
        }
        int partition = partition(nums, lo, hi);
        quickSort(nums, lo, partition - 1);
        quickSort(nums, partition + 1, hi);
    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        while(true) {
            //Find left item to swap
            while(nums[++i] < nums[lo]){
                if(i == hi) break;
            }

            //Find right item to swap
            while(nums[lo] < nums[--j]) {
                if(j == lo) break;
            }

            if(i >= j) {
                break;
            }
            // swap left and right
            swap(nums, i, j);
        }
        //swap with partition
        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



    private void mergeSort(int[] nums, int[] aux, int lo, int hi) {
        if(hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, aux, lo, mid);
        mergeSort(nums, aux, mid+1, hi);
        merge(nums, aux, lo, mid, hi);
    }

    private void merge(int nums[], int[] aux, int lo, int mid, int hi) {
        for(int k = lo; k <= hi; k++) {
            aux[k] = nums[k];
        }

        int i = lo;
        int j = mid + 1;
        for(int k = lo; k <= hi; k++) {
            if(i > mid) nums[k] = aux[j++];
            else if(j > hi) nums[k] = aux[i++];
            else if(aux[i] < aux[j]) nums[k] = aux[i++];
            else nums[k] = aux[j++];
        }
    }
}
