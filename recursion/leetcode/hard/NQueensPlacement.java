package day2.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class NQueensPlacement {
    public static void main(String[] args) {
        NQueensPlacement ob = new NQueensPlacement();
        System.out.println(ob.solveNQueens(2));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        placeQueens(n, n, res, new boolean[n][n], 0, 0);
        return res;
    }

    private List<String> getBoard(boolean[][] visited) {
        List<String> rows = new ArrayList<>();
        for (boolean[] row : visited) {
            StringBuilder sb = new StringBuilder();
            for (boolean col : row) {
                if (col) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            rows.add(sb.toString());
        }
        return rows;
    }

    private void placeQueens(int n, int queens, List<List<String>> res,
            boolean[][] visited, int currR, int currC) {
        if (queens == 0) {
            res.add(getBoard(visited));
            return;
        }
        if (currC == n) {
            currC = 0;
            currR++;
        }
        if (currR == n) {
            return;
        }

        if (isSafe(currR, currC, visited)) {
            visited[currR][currC] = true;
            placeQueens(n, queens - 1, res, visited, currR, currC + 1);
            visited[currR][currC] = false;
        }
        placeQueens(n, queens, res, visited, currR, currC + 1);
    }

    private boolean isSafe(int currR, int currC, boolean[][] visited) {
        return isUpSafe(currR - 1, currC, visited) &&
                isLeftSafe(currR, currC - 1, visited) &&
                isUpperLeftDiaSafe(currR - 1, currC - 1, visited) &&
                isUpperRightDiaSafe(currR - 1, currC + 1, visited);
    }

    private boolean isUpSafe(int currR, int currC, boolean[][] visited) {
        if (currR < 0) {
            return true;
        }
        return !visited[currR][currC] && isUpSafe(currR - 1, currC, visited);
    }

    private boolean isLeftSafe(int currR, int currC, boolean[][] visited) {
        if (currC < 0) {
            return true;
        }
        return !visited[currR][currC] && isLeftSafe(currR, currC - 1, visited);
    }

    private boolean isUpperLeftDiaSafe(int currR, int currC, boolean[][] visited) {
        if (currC < 0 || currR < 0) {
            return true;
        }
        return !visited[currR][currC] && isUpperLeftDiaSafe(currR - 1, currC - 1, visited);
    }

    private boolean isUpperRightDiaSafe(int currR, int currC, boolean[][] visited) {
        if (currC == visited.length || currR < 0) {
            return true;
        }
        return !visited[currR][currC] && isUpperRightDiaSafe(currR - 1, currC + 1, visited);
    }
}
