package com.sbaitman.ctci.stringsandarrays;

/**
 * LeetCode 28: Find the Index of the First Occurrence in a String
 *
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 *
 *
 *
 * Example 1:
 *
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * Example 2:
 *
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 */
public class IndexOfFirst {
    public static int strStr(String haystack, String needle) {
        int hlength = haystack.length();
        int nlength = needle.length();

        if(hlength == nlength) {
            if(haystack.equals(needle)) {
                return 0;
            }
        }

        for(int i = 0; i < hlength - nlength + 1; i++) {
            if(haystack.substring(i, i + nlength).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
