package com.sbaitman.ctci.stringsandarrays;

import java.util.Locale;

public class FindDuplicates {
    private static boolean hasDuplicates(String s) {
        if(s == null) {
            return false;
        }
        s = s.toLowerCase(Locale.ROOT);
        int[] tracker = new int[127];

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            tracker[c] += 1;
        }

        for(int i = 0; i < tracker.length; i++) {
            if(tracker[i] > 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "Shyam";
        String s3 = "raDAR";
        String s4 = null;

        System.out.println(hasDuplicates(s1));
        System.out.println(hasDuplicates(s2));
        System.out.println(hasDuplicates(s3));
    }
}
