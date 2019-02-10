package problem121_best_time_to_buy_and_sell_stock.problem236_LCA;


/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */

class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int max=0;
        for(int x=0;x<prices.length;x++){
            if(prices[x]<min){
                min=prices[x];
            }
            else if(max<(prices[x]-min)){
                max=prices[x]-min;
            }
        }
        return max;
    }

}