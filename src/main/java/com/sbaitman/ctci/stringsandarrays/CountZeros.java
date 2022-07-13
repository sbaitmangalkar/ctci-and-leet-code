package com.sbaitman.ctci.stringsandarrays;

public class CountZeros {
    private static int count(String s) {
        if(s == null) {
            return -1;
        }

        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            int maxCount = 0;
            for(int j = i; j < s.length(); j++) {
                if(s.charAt(j) != '0') {
                    break;
                }
                maxCount++;
            }
            if(maxCount > count) {
                count = maxCount;
            }
            i += maxCount; // Both for loops run in sync
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "1001100001";
        System.out.println(count(s));
    }
}
