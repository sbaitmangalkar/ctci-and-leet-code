package com.sbaitman.ctci.stringsandarrays;

import java.util.Arrays;

/**
 * LeetCode 14: Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        // Sort the given array and take the first and last string.
        // check only for these two strings because, the longest common prefix of all the strings
        // must be a prefix of the first string and a prefix of the last string in the sorted array

        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int i = 0;

        while(i < s1.length() && i < s2.length()) {
            if(s1.charAt(i) == s2.charAt(i)) {
                i++;
            } else {
                break;
            }
        }
        return s1.substring(0, i);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
