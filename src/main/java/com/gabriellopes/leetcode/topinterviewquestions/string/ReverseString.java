package com.gabriellopes.leetcode.topinterviewquestions.string;

public class ReverseString {

    /* time complexity: O(n/2) -> O(n); space complexity: O(1) */
    public static void reverseString(char[] s) {
        int j = s.length - 1;

        for(int i = 0; i <= j; i++) {
            char temp = s[j];

            s[j] = s[i];
            s[i] = temp;

            j--;
        }
    }

    public static void main(String[] args) {
        char[] input = new char[]{'a', 'b', 'c'};

        reverseString(input);

        for(char c : input) {
            System.out.println(c);
        }

    }
}
