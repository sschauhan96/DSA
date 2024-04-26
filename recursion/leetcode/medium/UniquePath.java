package day2.leetcode.medium;

public class UniquePath {
    public static void main(String[] args) {

    }

    private int pathTravelledViaRecursion(int m, int n, int currR, int currC) {
        if (currR == m || currC == n) {
            return 0;
        }
        if (currR == m - 1 && currC == n - 1) {
            return 1;
        }
        int sp1 = pathTravelledViaRecursion(m, n, currR + 1, currC);
        int sp2 = pathTravelledViaRecursion(m, n, currR, currC + 1);
        return sp1 + sp2;
    }

    private int pathTravelledViaDP(int m, int n, int currR, int currC, int[][] dp) {
        if (currR == m || currC == n) {
            return 0;
        }
        if (currR == m - 1 && currC == n - 1) {
            return 1;
        }
        if (dp[currR][currC] != 0) {
            return dp[currR][currC];
        }
        int sp1 = pathTravelledViaDP(m, n, currR + 1, currC, dp);
        int sp2 = pathTravelledViaDP(m, n, currR, currC + 1, dp);
        dp[currR][currC] = sp1 + sp2;
        return dp[currR][currC];
    }

    private int pathTravelledViaBU(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int sp1 = dp[i - 1][j];
                int sp2 = dp[i][j - 1];
                dp[i][j] = sp1 + sp2;
            }
        }
        return dp[m - 1][n - 1];
    }
}
