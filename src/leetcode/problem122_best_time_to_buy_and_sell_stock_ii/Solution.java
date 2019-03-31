package leetcode.problem122_best_time_to_buy_and_sell_stock_ii;


/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        if(prices==null||prices.length<2){
            return maxProfit;
        }
        for(int x=0;x<prices.length-1;x++){
            if(prices[x+1]-prices[x]>0){
                maxProfit+=prices[x+1]-prices[x];
            }
        }
        return maxProfit;
    }
}