package day2.leetcode.medium;

public class UniquePath2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return uniquePaths(obstacleGrid, 0, 0);
    }

    private int uniquePaths(int[][] grid, int cR, int cC) {
        if (cR == grid.length || cC == grid[0].length) {
            return 0;
        }
        if (grid[cR][cC] == 1) {
            return 0;
        }
        if (cR == grid.length - 1 && cC == grid[0].length - 1) {
            return 1;
        }

        int sp1 = uniquePaths(grid, cR + 1, cC);
        int sp2 = uniquePaths(grid, cR, cC + 1);
        return sp1 + sp2;
    }

    public int uniquePathsWithObstaclesTD(int[][] obstacleGrid) {
        return uniquePathsTD(obstacleGrid, 0, 0,
                new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1]);
    }

    private int uniquePathsTD(int[][] grid, int cR, int cC, int[][] dp) {
        if (cR == grid.length || cC == grid[0].length) {
            return 0;
        }
        if (grid[cR][cC] == 1) {
            return 0;
        }
        if (cR == grid.length - 1 && cC == grid[0].length - 1) {
            return 1;
        }
        if (dp[cR][cC] != 0) {
            return dp[cR][cC];
        }
        int sp1 = uniquePathsTD(grid, cR + 1, cC, dp);
        int sp2 = uniquePathsTD(grid, cR, cC + 1, dp);
        dp[cR][cC] = sp1 + sp2;
        return dp[cR][cC];
    }

    public int uniquePathsWithObstaclesBU(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = 1;

        for (int row = 1; row < dp.length; row++) {
            if (obstacleGrid[row][0] != 1 && dp[row - 1][0] != 0) {
                dp[row][0] = 1;
            }
        }

        for (int col = 1; col < dp[0].length; col++) {
            if (obstacleGrid[0][col] != 1 && dp[0][col - 1] != 0) {
                dp[0][col] = 1;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
