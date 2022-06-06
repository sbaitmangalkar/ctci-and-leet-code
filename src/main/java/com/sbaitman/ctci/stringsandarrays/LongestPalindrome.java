package com.sbaitman.ctci.stringsandarrays;

/**
 * LeetCode 5: Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 *
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 */
public class LongestPalindrome {
    public static String longestPalindromeSubstring(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;

        for(int i = 0; i < s.length(); i++) {
            // handling "racecar" type of strings where only one char has no matching other char
            int len1 = expandFromMiddle(s, i ,i);
            //handling other regular strings
            int len2 = expandFromMiddle(s, i, i + 1);
            int len = Math.max(len1, len2);

            if(len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }

        return s.substring(start, end + 1);
    }

    public static int expandFromMiddle(String s, int left, int right) {
        if (s == null || left > right) {
            return 0;
        }

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        String s1 = "racecar";
        String s2 = "babad";
        String res1 = longestPalindromeSubstring(s1);
        String res2 = longestPalindromeSubstring(s2);
        System.out.println("Result 1 = " + res1);
        System.out.println("Result 2 = " + res2);
    }
}
