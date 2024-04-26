package day2.leetcode.easy;

public class ClimbStairs {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairsViaRecursion(n));
        System.out.println(climbStairsViaDP(n, new int[n + 1]));
        System.out.println(climbStairsViaBU(n));
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int prevR = 1;
        int prevToPrevR = 1;
        for (int i = 2; i <= n; i++) {
            int temp = prevR + prevToPrevR;
            prevToPrevR = prevR;
            prevR = temp;
        }
        return prevR;
    }

    public static int climbStairsViaBU(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int climbStairsViaDP(int n, int[] dp) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int sp1 = climbStairsViaDP(n - 1, dp);
        int sp2 = climbStairsViaDP(n - 2, dp);
        dp[n] = sp1 + sp2;
        return dp[n];
    }

    public static int climbStairsViaRecursion(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        int sp1 = climbStairsViaRecursion(n - 1);
        int sp2 = climbStairsViaRecursion(n - 2);
        return sp1 + sp2;
    }
}
