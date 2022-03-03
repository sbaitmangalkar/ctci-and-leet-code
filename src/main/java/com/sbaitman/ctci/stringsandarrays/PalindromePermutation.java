package com.sbaitman.ctci.stringsandarrays;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    // Using a hash map to keep count of characters.
    // A string is said to be permutation of palindrome if it has not more than one char that is odd in count
    public boolean isPermutationOfPalindrome(String str) {
        Map<Character, Integer> charFrequencyTable = buildCharFrequencyTable(str.toLowerCase());

        int oddCount = 0;

        for (Map.Entry<Character, Integer> characterIntegerEntry : charFrequencyTable.entrySet()) {
            if(characterIntegerEntry.getValue() % 2 != 0) {
                oddCount += 1;
            }
        }

        if(oddCount > 1) {
            return false;
        }
        return true;
    }

    private Map<Character, Integer> buildCharFrequencyTable(String str) {
        char[] arr = str.toCharArray();
        Map<Character, Integer> result = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(isValidChar(arr[i])) {
                if(result.containsKey(arr[i])) {
                    result.put(arr[i], result.get(arr[i]) + 1);
                } else {
                    result.put(arr[i], 1);
                }
            }
        }
        return result;
    }

    private boolean isValidChar(char c) {
        int val = Character.getNumericValue(c);
        int aVal = Character.getNumericValue('a');
        int zVal = Character.getNumericValue('z');
        if(aVal <= val && zVal >= val) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        System.out.println(palindromePermutation.isPermutationOfPalindrome("Tact Coa"));
    }
}
