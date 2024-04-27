package recursion.leetcode.medium;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        System.out.println(cc.coinChange(new int[] {1,2,5, 9864}, 7));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        int res =  getCombinations(coins, amount, 0, 0, dp);
        return res;
    }

    private int getCombinations(int[] coins, int amount, int currIdx, int coinCount, int[] dp){
        if(0 == amount){
            return coinCount;
        }
        if(0>amount || currIdx==coins.length){
            return -1;
        }
        
        if(dp[amount]!=-1){
            return dp[amount];
        }
        int sp1 = getCombinations(coins, amount-coins[currIdx], currIdx, coinCount+1, dp);
        int sp2 = getCombinations(coins, amount, currIdx+1, coinCount, dp);
        if(sp1!=-1 && sp2!=-1){
            dp[amount] = Math.min(sp1, sp2);
        }else if(sp1 != -1){
            dp[amount] = sp1;
        }else{
            dp[amount] = sp2;
        }
        return dp[amount];
    }
}
