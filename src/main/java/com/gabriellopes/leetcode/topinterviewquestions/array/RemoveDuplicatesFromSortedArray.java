package com.gabriellopes.leetcode.topinterviewquestions.array;

public class RemoveDuplicatesFromSortedArray {

    /* time complexity: O(n), space complexity: O(1) */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    public static void main(String[] args) {
        int[] input = new int[]{0, 0, 1, 2, 2, 4};

        int noDuplicatesLength = removeDuplicates(input);

        for(int i = 0; i < noDuplicatesLength; i++) {
            System.out.println(input[i]);
        }

    }
}
