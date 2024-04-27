package arrays.leetcode.easy;

public class BuyAndSaleStock {
    public int maxProfit(int[] prices) {
        int currMin = prices[0];
        int maxProfit = 0;
        for(int i=1; i<prices.length; i++){
            currMin = Math.min(currMin, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i]-currMin);
        }
        return maxProfit;
    }
}
