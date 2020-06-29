package com.gabriellopes.leetcode.topinterviewquestions.array;

public class BestTimeToBuyAndSellStockII {

    public static int maxProfit(int[] prices) {
        int diff = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                diff += prices[i] - prices[i-1];
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        int [] input = new int[]{7,1,5,3,6,4};
        int [] input2 = new int[]{1,2,3,4,5};

        System.out.println(maxProfit(input2));
    }
}
