package com.sbaitman.ctci.stringsandarrays;

public class OneAway {
    public boolean isOneEditAway(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return isOneReplaceAway(s1, s2);
        } else if (s1.length() + 1 == s2.length()) {
            return isOneInsertAway(s1, s2);
        } else if (s1.length() - 1 == s2.length()) {
            return isOneInsertAway(s2, s1);
        }
        return false;
    }

    private boolean isOneInsertAway(String s1, String s2) {
        int i = 0;
        int j = 0;
        while(i < s1.length() && j < s2.length()) {
            if(s1.charAt(i) != s2.charAt(j)) {
                if( i != j) {
                    return false;
                }
            } else {
                i++;
            }
            j++;
        }
        return false;
    }

    private boolean isOneReplaceAway(String s1, String s2) {
        boolean foundDifference = false;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                if(foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
