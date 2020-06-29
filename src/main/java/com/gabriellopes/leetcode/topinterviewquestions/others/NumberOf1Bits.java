package com.gabriellopes.leetcode.topinterviewquestions.others;

public class NumberOf1Bits {

    public static int hammingWeight(long n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }

            mask <<= 1;
        }
        return bits;
    }

    public static long bestHammingWeight(long n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }


    public static void main(String[] args) {
        int i = 9;

        System.out.println(hammingWeight(i));
        System.out.println(bestHammingWeight(i));
    }
}
