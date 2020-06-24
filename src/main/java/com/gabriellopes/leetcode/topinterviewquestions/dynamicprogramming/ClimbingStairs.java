package com.gabriellopes.leetcode.topinterviewquestions.dynamicprogramming;

import java.util.Arrays;

public class ClimbingStairs {

    public static int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return climbStairs(n, memo);
    }

    private static int climbStairs(int n, int[] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (memo[n] > -1) {
            return memo[n];
        } else {
            memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);

            return memo[n];
        }
    }

    private static int recursiveClimbStairs(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return recursiveClimbStairs(n - 1) + recursiveClimbStairs(n - 2);
        }
    }

    public static void main(String[] args) {
//        System.out.println(recursiveClimbStairs(4));
        System.out.println(climbStairs(4));
    }
}
